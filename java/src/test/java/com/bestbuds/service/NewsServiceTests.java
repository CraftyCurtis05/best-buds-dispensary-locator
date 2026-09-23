package com.bestbuds.service;

import com.bestbuds.model.NewsArticle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.ExpectedCount.times;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;

public class NewsServiceTests {

    private NewsService newsService;
    private MockRestServiceServer mockServer;

    @BeforeEach
    public void setup() {

        RestClient.Builder restClientBuilder =
                RestClient.builder();

        mockServer = MockRestServiceServer.bindTo(
                restClientBuilder
        ).build();

        newsService = new NewsService(
                restClientBuilder,
                "https://news.example.com",
                "test-api-key"
        );
    }

    @Test
    public void getNews_returns_news_articles() {

        String responseBody = """
                {
                    "data": [
                        {
                            "uuid": "article-1",
                            "title": "Cannabis News Article",
                            "description": "Test description",
                            "published_at": "2026-09-23T12:00:00.000000Z",
                            "image_url": "https://example.com/image.jpg",
                            "url": "https://example.com/article",
                            "source": "example.com"
                        }
                    ]
                }
                """;

        mockServer.expect(
                times(5),
                request -> {
                }
        )
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(
                                responseBody,
                                APPLICATION_JSON
                        )
                );

        List<NewsArticle> newsArticles =
                newsService.getNews();

        assertNotNull(newsArticles);
        assertEquals(5, newsArticles.size());

        NewsArticle firstArticle =
                newsArticles.get(0);

        assertEquals(
                "article-1",
                firstArticle.getUuid()
        );

        assertEquals(
                "Cannabis News Article",
                firstArticle.getTitle()
        );

        assertEquals(
                "Test description",
                firstArticle.getDescription()
        );

        assertEquals(
                "2026-09-23T12:00:00.000000Z",
                firstArticle.getPublishedAt()
        );

        assertEquals(
                "https://example.com/image.jpg",
                firstArticle.getImageUrl()
        );

        assertEquals(
                "https://example.com/article",
                firstArticle.getUrl()
        );

        assertEquals(
                "example.com",
                firstArticle.getSource()
        );

        mockServer.verify();
    }

    @Test
    public void getNews_returns_available_articles_when_one_request_fails() {

        String responseBody = """
                {
                    "data": [
                        {
                            "uuid": "article-1",
                            "title": "Cannabis News Article",
                            "description": "Test description",
                            "published_at": "2026-09-23T12:00:00.000000Z",
                            "image_url": "https://example.com/image.jpg",
                            "url": "https://example.com/article",
                            "source": "example.com"
                        }
                    ]
                }
                """;

        mockServer.expect(
                times(4),
                request -> {
                }
        )
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(
                                responseBody,
                                APPLICATION_JSON
                        )
                );

        mockServer.expect(
                request -> {
                }
        )
                .andExpect(method(GET))
                .andRespond(
                        withServerError()
                );

        List<NewsArticle> newsArticles =
                newsService.getNews();

        assertNotNull(newsArticles);
        assertEquals(4, newsArticles.size());

        mockServer.verify();
    }

    @Test
    public void getNews_uses_cached_news_on_second_request() {

        String responseBody = """
                {
                    "data": [
                        {
                            "uuid": "article-1",
                            "title": "Cannabis News Article",
                            "description": "Test description",
                            "published_at": "2026-09-23T12:00:00.000000Z",
                            "image_url": "https://example.com/image.jpg",
                            "url": "https://example.com/article",
                            "source": "example.com"
                        }
                    ]
                }
                """;

        mockServer.expect(
                times(5),
                request -> {
                }
        )
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(
                                responseBody,
                                APPLICATION_JSON
                        )
                );

        List<NewsArticle> firstRequest =
                newsService.getNews();

        List<NewsArticle> secondRequest =
                newsService.getNews();

        assertEquals(5, firstRequest.size());
        assertEquals(5, secondRequest.size());

        mockServer.verify();
    }

    @Test
    public void searchNews_returns_empty_list_when_request_fails() {

        mockServer.expect(
                request -> {
                }
        )
                .andExpect(method(GET))
                .andRespond(
                        withServerError()
                );

        List<NewsArticle> newsArticles =
                newsService.searchNews("medical");

        assertNotNull(newsArticles);
        assertEquals(0, newsArticles.size());

        mockServer.verify();
    }

    @Test
    public void searchNews_returns_empty_list_for_blank_query() {

        List<NewsArticle> newsArticles =
                newsService.searchNews("   ");

        assertNotNull(newsArticles);
        assertEquals(0, newsArticles.size());

        mockServer.verify();
    }

    @Test
    public void searchNews_returns_empty_list_when_query_is_too_long() {

        String longQuery =
                "a".repeat(101);

        List<NewsArticle> newsArticles =
                newsService.searchNews(longQuery);

        assertNotNull(newsArticles);
        assertEquals(0, newsArticles.size());

        mockServer.verify();
    }

    @Test
    public void searchNews_returns_articles_sorted_newest_first() {

        String responseBody = """
                {
                    "data": [
                        {
                            "uuid": "older-article",
                            "title": "Older Cannabis Article",
                            "description": "Older test article",
                            "published_at": "2026-09-20T12:00:00.000000Z",
                            "image_url": "https://example.com/older.jpg",
                            "url": "https://example.com/older",
                            "source": "example.com"
                        },
                        {
                            "uuid": "newer-article",
                            "title": "Newer Cannabis Article",
                            "description": "Newer test article",
                            "published_at": "2026-09-23T12:00:00.000000Z",
                            "image_url": "https://example.com/newer.jpg",
                            "url": "https://example.com/newer",
                            "source": "example.com"
                        }
                    ]
                }
                """;

        mockServer.expect(
                request -> {
                }
        )
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(
                                responseBody,
                                APPLICATION_JSON
                        )
                );

        List<NewsArticle> newsArticles =
                newsService.searchNews("medical");

        assertNotNull(newsArticles);
        assertEquals(2, newsArticles.size());

        assertEquals(
                "newer-article",
                newsArticles.get(0).getUuid()
        );

        assertEquals(
                "older-article",
                newsArticles.get(1).getUuid()
        );

        mockServer.verify();
    }
}