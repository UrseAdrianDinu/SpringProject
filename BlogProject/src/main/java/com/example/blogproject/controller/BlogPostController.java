package com.example.blogproject.controller;

import com.example.blogproject.dto.RoleDTO;
import com.example.blogproject.dto.UserDTO;
import com.example.blogproject.model.Role;
import com.example.blogproject.model.User;
import com.example.blogproject.service.BlogPostService;
import com.example.blogproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BlogPostController {

    private final BlogPostService blogPostService;

    private final UserService userService;

    public BlogPostController(BlogPostService blogPostService, UserService userService) {
        this.blogPostService = blogPostService;
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public  ResponseEntity<UserDTO> createUser() {
        UserDTO result = userService.createUser();
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/roles")
    public List<RoleDTO> getRoles() {
        return userService.getAllRoles();
    }

    @PostMapping("/createRole")
    public ResponseEntity<RoleDTO> createRole(@RequestBody  RoleDTO roleDTO) {
        RoleDTO result = userService.createRole(roleDTO);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

    @PostMapping("/createHUsers")
    public List<User> createHUsers() {
        return userService.createHardcodedUsers(2);
    }
}
