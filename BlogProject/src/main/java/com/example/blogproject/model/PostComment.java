package com.example.blogproject.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "POST_COMMENT")
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_comment_id")
    private Long id;

    @OneToMany(targetEntity = User.class, mappedBy = "post_comment")
    private Set<User> users;
}
