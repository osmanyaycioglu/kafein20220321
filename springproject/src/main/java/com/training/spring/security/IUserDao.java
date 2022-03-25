package com.training.spring.security;

import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<UserLoc, Long> {

    UserLoc findByUsername(String username);
}
