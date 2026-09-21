package com.bestbuds.model;

public class NewsArticle {

    private String uuid;
    private String title;
    private String description;
    private String publishedAt;
    private String imageUrl;
    private String url;
    private String source;

    public NewsArticle() {
    }

    public NewsArticle(
            String uuid,
            String title,
            String description,
            String publishedAt,
            String imageUrl,
            String url,
            String source
    ) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.publishedAt = publishedAt;
        this.imageUrl = imageUrl;
        this.url = url;
        this.source = source;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}