package com.joinme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.joinme.entity.User;
import com.joinme.pojo.UserData;
import com.joinme.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //private BCryptPasswordEncoder byCryptPasswordEncoder;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(UserData userData) {
    	User user = new User();
    	user.setUsername(userData.getUsername());
        user.setPassword(passwordEncoder.encode(userData.getPassword()));
        user.setRole(userData.getRole());// Hash the password
        return userRepository.save(user);
    }
    public boolean checkUserCredentials(String username, String password) {
    	//String encode = passwordEncoder.encode(password);
    	//System.out.println(encode);
        User userData = userRepository.findByUsername(username);
        //System.out.println(userData.getPassword());
        if (userData != null && passwordEncoder.matches(password, userData.getPassword())) {
            return true;
        }
        return false;
    }

    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }
}
