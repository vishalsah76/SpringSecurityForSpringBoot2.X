package com.security.services;

import com.security.models.CustomUserDetail;
import com.security.models.User;
import com.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user =this.userRepository.findByUserName(s);
        if(user==null) throw  new UsernameNotFoundException("NO USER FOUND");
        return new CustomUserDetail(user);
    }
}
