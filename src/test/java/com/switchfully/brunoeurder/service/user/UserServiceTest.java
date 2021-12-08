package com.switchfully.brunoeurder.service.user;

import com.switchfully.brunoeurder.domain.user.Address;
import com.switchfully.brunoeurder.domain.user.User;
import com.switchfully.brunoeurder.domain.user.UserDto;
import com.switchfully.brunoeurder.domain.mapper.UserMapper;
import com.switchfully.brunoeurder.repository.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserServiceTest {
        @Test
        void givenUserInformation_whenSavingUser_thenUserRepositoryContainsUser
                () {
            //GIVEN
            User expectedUser = new User(
                    "Albert",
                    "Einstein",
                    "albert@einstein.com",
                    new Address("Mercer Street", "112", "08544, NJ", "Princeton", "USA"),
                    "+1 609-258-3000");

            UserRepository userRepository = new UserRepository();
            UserService userService = new UserService(userRepository);

            //WHEN
            userService.saveUser(expectedUser);
            List<User> actualUserList = userRepository.getUserList();

            //THEN
            Assertions.assertThat(actualUserList.contains(expectedUser));
        }

        @Test
        void givenIncompleteUserInformation_whenCreatingNewUser_thenThrowsNullPointerException() {
            //GIVEN User
            // information with first name missing (null)

            //WHEN, THEN
            Assertions.assertThatThrownBy(() -> {
                UserDto userDto = new UserDto()
                        .setFirstName(null)
                        .setLastName("Einstein")
                        .setEmail("albert@einstein.com")
                        .setAddress(new Address("Mercer Street", "112", "New Jersey", "08544", "USA"))
                        .setPhoneNumber("+1 609-258-3000");
                new UserMapper().mapToUser(userDto);
            }).isInstanceOf(NullPointerException.class).hasMessageContaining("Missing value");
        }
    }