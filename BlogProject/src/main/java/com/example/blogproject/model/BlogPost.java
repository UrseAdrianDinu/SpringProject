package com.example.blogproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "BLOG_POST")
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blog_post_id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User author;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "DATE_CREATED")
    private LocalDate dateCreated;

    public BlogPost(Long blog_post_id, User author, String title, String content, LocalDate dateCreated) {
        this.blog_post_id = blog_post_id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.dateCreated = dateCreated;
    }

    public BlogPost() {

    }

    public Long getBlog_post_id() {
        return blog_post_id;
    }

    public void setBlog_post_id(Long blog_post_id) {
        this.blog_post_id = blog_post_id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
