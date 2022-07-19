package com.example.blogproject.dto;

public class BlogPostDTO {
    private String title;
    private String content;
    private String authorEmail;

    public BlogPostDTO(String title, String content, String authorEmail) {
        this.title = title;
        this.content = content;
        this.authorEmail = authorEmail;
    }

    public BlogPostDTO() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }
}
