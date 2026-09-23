package com.bestbuds.service;

import com.bestbuds.model.NewsArticle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClientException;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class NewsService {

    private final RestClient restClient;
    private final String apiKey;
    private static final Logger logger =
            LoggerFactory.getLogger(NewsService.class);

    private static final String NEWS_SEARCH =
            "cannabis | marijuana | \"medical marijuana\" | "
                    + "\"recreational marijuana\" | \"cannabis industry\" | "
                    + "\"cannabis legalization\" | \"marijuana legalization\" | "
                    + "\"cannabis laws\" | \"marijuana laws\" | "
                    + "\"cannabis dispensary\" | \"marijuana dispensary\" | "
                    + "\"cannabis business\" | \"cannabis market\" | "
                    + "\"cannabis research\" | \"medical cannabis\" | "
                    + "\"cannabis tax\" | \"marijuana tax\" | "
                    + "\"cannabis products\" | \"cannabis edibles\" | "
                    + "\"CBD oil\" | \"CBD products\" | "
                    + "\"hemp industry\" | \"hemp products\" | "
                    + "sativa | indica";

    private static final int NEWS_PAGE_LIMIT = 3;
    private static final int NEWS_PAGE_COUNT = 5;
    private static final int NEWS_SEARCH_MAX_LENGTH = 100;

    private static final Duration NEWS_CACHE_DURATION =
            Duration.ofDays(1);

    private List<NewsArticle> cachedNews =
            new ArrayList<>();

    private Instant cacheExpiration =
            Instant.EPOCH;

    public NewsService(
            RestClient.Builder restClientBuilder,
            @Value("${news.api.url}") String apiUrl,
            @Value("${news.api.key}") String apiKey
    ) {
        this.restClient = restClientBuilder
                .baseUrl(apiUrl)
                .build();

        this.apiKey = apiKey;
    }

    // Get the latest cannabis news
    public List<NewsArticle> getNews() {

        if (!cachedNews.isEmpty()
                && Instant.now().isBefore(cacheExpiration)) {
            return cachedNews;
        }

        LocalDate publishedAfter =
                LocalDate.now(ZoneOffset.UTC).minusDays(30);

        List<CompletableFuture<Map<String, Object>>> newsRequests =
                new ArrayList<>();

        for (int page = 1; page <= NEWS_PAGE_COUNT; page++) {

            int pageNumber = page;

            CompletableFuture<Map<String, Object>> newsRequest =
                    CompletableFuture.supplyAsync(
                            () -> getNewsPage(
                                    publishedAfter,
                                    pageNumber
                            )
                    );

            newsRequests.add(newsRequest);
        }

        List<NewsArticle> newsArticles =
                new ArrayList<>();

        for (CompletableFuture<Map<String, Object>> newsRequest
                : newsRequests) {

            Map<String, Object> response =
                    newsRequest.join();

            newsArticles.addAll(
                    convertNews(response)
            );
        }

        sortNews(newsArticles);

        cachedNews = newsArticles;

        cacheExpiration =
                Instant.now().plus(NEWS_CACHE_DURATION);

        return cachedNews;
    }

    // Search recent cannabis news
    public List<NewsArticle> searchNews(String query) {

        if (query == null
                || query.isBlank()
                || query.length() > NEWS_SEARCH_MAX_LENGTH) {
            return new ArrayList<>();
        }

        String searchQuery =
                prepareSearchQuery(query);

        if (searchQuery.isBlank()) {
            return new ArrayList<>();
        }

        LocalDate publishedAfter =
                LocalDate.now(ZoneOffset.UTC).minusDays(30);

        Map<String, Object> response = getNewsSearchPage(
                publishedAfter,
                searchQuery,
                1
        );

        List<NewsArticle> newsArticles =
                convertNews(response);

        sortNews(newsArticles);

        return newsArticles;
    }

    // Prepare the user's news search term
    private String prepareSearchQuery(String query) {

        String searchQuery =
                query.trim();

        searchQuery = searchQuery.replaceAll(
                "[+|()\"-]",
                " "
        );

        searchQuery = searchQuery.replaceAll(
                "\\s+",
                " "
        );

        return searchQuery.trim();
    }

    // Get one page of cannabis news
    private Map<String, Object> getNewsPage(
            LocalDate publishedAfter,
            int page
    ) {

        try {
            return restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/news/all")
                            .queryParam("api_token", apiKey)
                            .queryParam("search", NEWS_SEARCH)
                            .queryParam(
                                    "search_fields",
                                    "title,description,keywords"
                            )
                            .queryParam("language", "en")
                            .queryParam(
                                    "published_after",
                                    publishedAfter
                            )
                            .queryParam(
                                    "limit",
                                    NEWS_PAGE_LIMIT
                            )
                            .queryParam("page", page)
                            .build())
                    .retrieve()
                    .body(
                            new ParameterizedTypeReference<
                                    Map<String, Object>
                            >() {
                            }
                    );

        } catch (RestClientException e) {
            logger.warn(
                    "Unable to retrieve news page {}: {}",
                    page,
                    e.getMessage()
            );

            return null;
        }
    }

    // Get one page of cannabis news search results
    private Map<String, Object> getNewsSearchPage(
            LocalDate publishedAfter,
            String query,
            int page
    ) {

        String combinedSearch =
                "(" + NEWS_SEARCH + ") + (\"" + query + "\")";

        try {
            return restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/news/all")
                            .queryParam("api_token", apiKey)
                            .queryParam("search", combinedSearch)
                            .queryParam(
                                    "search_fields",
                                    "title,description,keywords"
                            )
                            .queryParam("language", "en")
                            .queryParam(
                                    "published_after",
                                    publishedAfter
                            )
                            .queryParam(
                                    "limit",
                                    NEWS_PAGE_LIMIT
                            )
                            .queryParam("page", page)
                            .build())
                    .retrieve()
                    .body(
                            new ParameterizedTypeReference<
                                    Map<String, Object>
                            >() {
                            }
                    );

        } catch (RestClientException e) {
            logger.warn(
                    "Unable to retrieve news search results: {}",
                    e.getMessage()
            );

            return null;
        }
    }

    // Sort news articles from newest to oldest
    private void sortNews(
            List<NewsArticle> newsArticles
    ) {
        newsArticles.sort(
                (firstArticle, secondArticle) ->
                        secondArticle.getPublishedAt()
                                .compareTo(
                                        firstArticle.getPublishedAt()
                                )
        );
    }

    // Convert the news API response into Best Buds news articles
    private List<NewsArticle> convertNews(
            Map<String, Object> response
    ) {

        List<NewsArticle> newsArticles =
                new ArrayList<>();

        if (response == null) {
            return newsArticles;
        }

        Object data =
                response.get("data");

        if (!(data instanceof List<?> articles)) {
            return newsArticles;
        }

        for (Object articleObject : articles) {

            if (!(articleObject instanceof Map<?, ?> article)) {
                continue;
            }

            NewsArticle newsArticle =
                    new NewsArticle();

            newsArticle.setUuid(
                    getStringValue(article, "uuid")
            );

            newsArticle.setTitle(
                    getStringValue(article, "title")
            );

            newsArticle.setDescription(
                    getStringValue(article, "description")
            );

            newsArticle.setPublishedAt(
                    getStringValue(article, "published_at")
            );

            newsArticle.setImageUrl(
                    getStringValue(article, "image_url")
            );

            newsArticle.setUrl(
                    getStringValue(article, "url")
            );

            newsArticle.setSource(
                    getStringValue(article, "source")
            );

            newsArticles.add(newsArticle);
        }

        return newsArticles;
    }

    // Get a string value from the news API response
    private String getStringValue(
            Map<?, ?> article,
            String key
    ) {
        Object value =
                article.get(key);

        if (value == null) {
            return "";
        }

        return value.toString();
    }
}