package com.example.blogproject.repository;

import com.example.blogproject.model.BlogPost;
import com.example.blogproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    List<BlogPost> findAllByAuthorOrderByDateCreatedDesc(User user);
}
