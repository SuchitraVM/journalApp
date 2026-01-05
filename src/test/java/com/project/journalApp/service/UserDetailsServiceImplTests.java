package com.project.journalApp.service;

import com.project.journalApp.Repository.UserRepository;
import com.project.journalApp.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void loadUSerByUserNameTest() {
//        when(userRepository.findByUserName(anyString()))
//                .thenReturn((com.project.journalApp.entity.User) builder()
//                        .username("ram").password("bhjhcc").roles().build());
//        UserDetails user = userDetailsService.loadUserByUsername("ram");
//        Assertions.assertNotNull(user);
//
//    }

    @Test
    void loadUserByUserNameTest() {

        User mockUser = User.builder()
                .userName("ram")
                .password("bhihcc")
                .roles(List.of("USER"))
                .build();

        when(userRepository.findByUserName(anyString()))
                .thenReturn(mockUser);

        UserDetails userDetails =
                userDetailsService.loadUserByUsername("ram");

        assertNotNull(userDetails);
        assertEquals("ram", userDetails.getUsername());
    }


}
