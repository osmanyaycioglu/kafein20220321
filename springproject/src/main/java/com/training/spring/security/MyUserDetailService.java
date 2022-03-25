package com.training.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserDao                    userDao;

    private final BCryptPasswordEncoder encoderLoc = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(final String usernameParam) throws UsernameNotFoundException {
        UserLoc findByUsernameLoc = this.userDao.findByUsername(usernameParam);
        if (findByUsernameLoc == null) {
            throw new UsernameNotFoundException("Böyle biri yok");
        }
        return User.builder()
                   .username(usernameParam)
                   .password(this.encoderLoc.encode(findByUsernameLoc.getPassword()))
                   .roles(findByUsernameLoc.getRole())
                   .build();
    }

}
