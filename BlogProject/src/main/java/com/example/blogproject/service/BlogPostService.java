package com.example.blogproject.service;

import com.example.blogproject.model.BlogPost;
import com.example.blogproject.model.User;
import com.example.blogproject.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public List<BlogPost> getAllAuthorPosts(User author) {
        return blogPostRepository.findAllByAuthorOrderByDateCreatedDesc(author);
    }

}
