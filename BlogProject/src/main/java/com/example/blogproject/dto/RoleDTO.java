package com.example.blogproject.dto;

import com.example.blogproject.model.User;
import lombok.Builder;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
@ToString
public class RoleDTO {
    private Long id;
    private Set<User> users;
    private String roleName;

}
