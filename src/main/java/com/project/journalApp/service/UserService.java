package com.project.journalApp.service;

import com.project.journalApp.Repository.UserRepository;
import com.project.journalApp.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveNewUser(User user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("ROLE_USER"));
            return userRepository.save(user);
        }catch (Exception e){
            log.info("hello");
            log.error("exception occured for {}",user.getUserName(),e);
            log.debug("debug");
            log.trace("trace");
            return null;

        }
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }


    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    public User saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("ROLE_USER","ADMIN"));
        return userRepository.save(user);
    }
}
