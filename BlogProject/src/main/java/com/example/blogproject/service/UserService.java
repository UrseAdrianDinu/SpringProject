package com.example.blogproject.service;

import com.example.blogproject.dto.RoleDTO;
import com.example.blogproject.dto.UserDTO;
import com.example.blogproject.model.Role;
import com.example.blogproject.model.User;
import com.example.blogproject.repository.RoleRepository;
import com.example.blogproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserDTO createUser() {
        User user = new User();
        user.setEmailAddress("email" + "@users.com");
        user.setPassword("PASSWORD");
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleName("Software Eng");
        roles.add(role);
        user.setRoles(roles);
        return convertUserToDTO(userRepository.save(user));
    }

    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = convertToRole(roleDTO);
        return convertRoleToDTO(roleRepository.save(role));
    }

    public List<RoleDTO> getAllRoles()
    {
       return roleRepository
               .findAll().
               stream().
               map(this::convertRoleToDTO).
               collect(Collectors.toList());
    }

    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public List<User> createHardcodedUsers(int numberOfUsers) {
        List<User> hardcodedUsers = new ArrayList<>();
        for (int i = 0; i < numberOfUsers; i++) {
            User user = new User();
            user.setEmailAddress("email" + i + "@users.com");
            Role role = new Role();
            role.setRoleName("AUTHOR");
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
            hardcodedUsers.add(userRepository.save(user));
        }
        return hardcodedUsers;
    }

    public RoleDTO convertRoleToDTO(Role role)
    {
        return RoleDTO.builder()
                .id(role.getId())
                .roleName(role.getRoleName())
                .users(role.getUsers())
                .build();
    }

    public Role convertToRole(RoleDTO roleDTO)
    {
        return Role.builder()
                .id(roleDTO.getId())
                .roleName(roleDTO.getRoleName())
                .users(roleDTO.getUsers())
                .build();
    }

    public UserDTO convertUserToDTO(User user)
    {
        return UserDTO.builder()
                .id(user.getId())
                .emailAddress(user.getEmailAddress())
                .password(user.getPassword())
                .blogPosts(user.getBlogPosts())
                .post_comment(user.getPost_comment())
                .roles(user.getRoles())
                .build();
    }

    public User convertToUser(UserDTO userDTO)
    {
        return User.builder()
                .id(userDTO.getId())
                .emailAddress(userDTO.getEmailAddress())
                .password(userDTO.getPassword())
                .blogPosts(userDTO.getBlogPosts())
                .post_comment(userDTO.getPost_comment())
                .roles(userDTO.getRoles())
                .build();
    }


}
