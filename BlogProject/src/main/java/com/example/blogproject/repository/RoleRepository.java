package com.example.blogproject.repository;

import com.example.blogproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()

public interface RoleRepository extends JpaRepository<Role, Long> {

}
