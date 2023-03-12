package com.roberto.apiwithsecurity.config;

import com.roberto.apiwithsecurity.entity.UserInfo;
import com.roberto.apiwithsecurity.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repository.findByName(username);

        return userInfo.map(UserInforUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not found" + username));

    }
}
