package com.switchfully.brunoeurder.service.user;

import com.switchfully.brunoeurder.domain.user.User;
import com.switchfully.brunoeurder.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.add(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getUserList();
    }

    public User getUser(String userUniqueID) {
        for (User user : userRepository.getUserList()) {
            if (user.getUserUniqueID().equals(userUniqueID)) {
                return user;
            }
        }
        throw new NoSuchElementException("User not found");
    }
}
