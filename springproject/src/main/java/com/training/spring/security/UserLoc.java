package com.training.spring.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserLoc {

    @Id
    @GeneratedValue
    private Long userId;
    private String username;
    private String password;
    private String role;
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userIdParam) {
        userId = userIdParam;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String usernameParam) {
        username = usernameParam;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String passwordParam) {
        password = passwordParam;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String roleParam) {
        role = roleParam;
    }
    
    
    
    
}
