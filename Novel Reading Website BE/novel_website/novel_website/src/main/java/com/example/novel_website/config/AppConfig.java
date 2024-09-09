package com.example.novel_website.config;

import com.example.novel_website.model.User;
import com.example.novel_website.model.UserDetailsImpl;
import com.example.novel_website.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    @Autowired
    UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                User user = userRepository.findByEmailAndIsActive(email)
                        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
                return UserDetailsImpl.build(user);
            }
        };
    }
}
