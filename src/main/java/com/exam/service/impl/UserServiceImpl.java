package com.exam.service.impl;

import java.util.Set;

import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
//import com.exam.services.UserService;
//import org.springframework.security.core.userdetails.UserDetails;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRole) throws Exception {
        User local= this.userRepository.findByUsername(user.getUsername());
        if(local!= null) {
            System.out.println("User is already present in database");
            throw new Exception("User is present");
        }
        else {
            for(UserRole ur:userRole) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRole);
            local=this.userRepository.save(user);
        }
        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        // TODO Auto-generated method stub
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        // TODO Auto-generated method stub
        this.userRepository.deleteById(userId);
    }

}
