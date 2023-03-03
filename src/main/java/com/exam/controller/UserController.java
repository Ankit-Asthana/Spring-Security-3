package com.exam.controller;

import com.exam.service.UserService;
import org.springframework.web.bind.annotation.*;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
//import com.exam.services.UserService;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles=new HashSet<>();

        Role role=new Role();
        role.setRoleId(50L);
        role.setRoleName("Normal");

        UserRole userRole =new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);
        return this.userService.createUser(user, roles);
    }
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
    }

//	@ExceptionHandler(UserNotFoundException.class)
//	public ResponseIntity<?> exceptionHandler(UserNotFoundException ex){
//		return ResponseEntity;
//	}
}
