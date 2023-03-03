package com.exam.repo;

import com.exam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.Role;

public interface UserRepository extends JpaRepository<User,Long>{

    public User findByUsername(String username);
}
