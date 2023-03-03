package com.exam.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

    @Entity
    @Table(name="users")
    public class User implements UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        //@Column(name="userId",nullable="false")
        private Long id;
        private String username;
        private String password;
        private String Fname;
        private String Lname;
        private String Email;
        private String profile;
        private boolean enabled=true;

        @OneToMany(cascade= CascadeType.ALL,fetch =FetchType.EAGER,mappedBy="user")
        @JsonIgnore
        private Set<UserRole> userRoles=new HashSet<>();

        public User() {

        }

        public Set<UserRole> getUserRoles() {
            return userRoles;
        }

        public void setUserRoles(Set<UserRole> userRoles) {
            this.userRoles = userRoles;
        }



        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        public void setUsername(String name) {
            this.username = name;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            //here we create a class Authority in which GrantedAuthority is being implemented
            Set<Authority> set= new HashSet<>();
		this.userRoles.forEach(userRole->{
			//to get the user roles of the users
			set.add(new Authority(userRole.getRole().getRoleName()));
		});
            return null;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFname() {
            return Fname;
        }

        public void setFname(String fname) {
            Fname = fname;
        }

        public String getLname() {
            return Lname;
        }

        public void setLname(String lname) {
            Lname = lname;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public User(Long id, String name, String password, String fname, String lname, String email, String profile,
                    boolean enabled) {
            super();
            this.id = id;
            this.username = name;
            this.password = password;
            Fname = fname;
            Lname = lname;
            Email = email;
            this.profile = profile;
            this.enabled = enabled;
        }


//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		Set<Authority> set= new HashSet<>();
//		this.userRoles.forEach(userRole->{
//			//to get the user roles of the users
//			set.add(new Authority(userRole.getRole().getRoleName()));
//		});
//		return null;
//	}
//
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
    }

