package com.switchfully.brunoeurder.repository.user;

import com.switchfully.brunoeurder.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository {
    private final List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
    }

    public void add(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    @Override
    public String toString() {
        return "CustomerRepository{" +
                "customerList=" + userList +
                '}';
    }
}
