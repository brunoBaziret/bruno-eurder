package com.switchfully.brunoeurder.api.user;

import com.switchfully.brunoeurder.domain.user.User;
import com.switchfully.brunoeurder.domain.user.UserDto;
import com.switchfully.brunoeurder.domain.mapper.UserMapper;
import com.switchfully.brunoeurder.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/users")

public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUserAccount(@RequestBody UserDto userDto, @RequestHeader(required = false) String authorization) {
        logger.info("Method 'createCustomerAccount' started");
        User user = userMapper.mapToUser(userDto);
        userService.saveUser(user);
        logger.info("Method 'createCustomerAccount' finished");
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsers(@RequestHeader(required = false) String authorization) {
        logger.info("Method 'getAllUsers' started");
        List<User> userList = userService.getAllUsers();
        List<UserDto> userDtoList = userList.stream()
                .map(userMapper::mapToUserDto)
                .collect(Collectors.toList());
        logger.info("Method 'getAllUsers' finished");
        return userDtoList;
    }

    @GetMapping(path = "{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable("id") String id, @RequestHeader(required = false) String authorization ) {
        logger.info("Method 'getUser' started");
        User user = userService.getUser(id);
        UserDto userDto= userMapper.mapToUserDto(user);
        logger.info("Method 'getUser' finished");
        return userDto;
    }
}
