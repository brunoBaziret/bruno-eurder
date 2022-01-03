package com.switchfully.brunoeurder.domain.mapper;

import com.switchfully.brunoeurder.domain.user.User;
import com.switchfully.brunoeurder.domain.user.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto mapToUserDto(User user) {
        return new UserDto()
                .setUserUniqueID(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setAddress(user.getAddress())
                .setPhoneNumber(user.getPhoneNumber());
    }

    public User mapToUser(UserDto userDto) {
        return new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getAddress(),
                userDto.getPhoneNumber());
    }
}
