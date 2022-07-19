package com.example.blogproject.dto;

import com.example.blogproject.model.BlogPost;
import com.example.blogproject.model.PostComment;
import com.example.blogproject.model.Role;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
@ToString
public class UserDTO {
    private long id;
    private String emailAddress;
    private String password;
    private List<BlogPost> blogPosts;
    private PostComment post_comment;
    private Set<Role> roles;

}
