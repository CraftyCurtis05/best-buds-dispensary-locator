package com.bestbuds.controller;

import com.bestbuds.model.NewsArticle;
import com.bestbuds.service.NewsService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    // Get the latest cannabis news
    @GetMapping
    public ResponseEntity<List<NewsArticle>> getNews() {
        List<NewsArticle> newsArticles =
                newsService.getNews();

        return ResponseEntity.ok(newsArticles);
    }

    // Search cannabis news
    @GetMapping("/search")
    public ResponseEntity<List<NewsArticle>> searchNews(
            @RequestParam String query
    ) {
        List<NewsArticle> newsArticles =
                newsService.searchNews(query);

        return ResponseEntity.ok(newsArticles);
    }
}