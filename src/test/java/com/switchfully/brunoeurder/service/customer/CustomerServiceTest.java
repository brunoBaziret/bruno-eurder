package com.switchfully.brunoeurder.service.customer;

import com.switchfully.brunoeurder.domain.customer.Address;
import com.switchfully.brunoeurder.domain.customer.Customer;
import com.switchfully.brunoeurder.domain.customer.CustomerDto;
import com.switchfully.brunoeurder.domain.mapper.CustomerMapper;
import com.switchfully.brunoeurder.repository.customer.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {
        @Test
        void givenCustomerInformation_whenSavingCustomer_thenCustomerRepositoryContainsCustomer() {
            //GIVEN
            Customer expectedCustomer = new Customer(
                    "Albert",
                    "Einstein",
                    "albert@einstein.com",
                    new Address("Mercer Street", "112", "08544, NJ", "Princeton", "USA"),
                    "+1 609-258-3000");

            CustomerRepository customerRepository = new CustomerRepository();
            CustomerService customerService = new CustomerService(customerRepository);

            //WHEN
            customerService.saveCustomer(expectedCustomer);
            List<Customer> actualCustomerList = customerRepository.getCustomerList();

            //THEN
            Assertions.assertThat(actualCustomerList.contains(expectedCustomer));
        }

        @Test
        void givenIncompleteCustomerInformation_whenCreatingNewCustomer_thenThrowsNullPointerException() {
            //GIVEN Customer information with first name missing (null)

            //WHEN, THEN
            Assertions.assertThatThrownBy(() -> {
                CustomerDto customerDto = new CustomerDto()
                        .setFirstName(null)
                        .setLastName("Einstein")
                        .setEmail("albert@einstein.com")
                        .setAddress(new Address("Mercer Street", "112", "New Jersey", "08544", "USA"))
                        .setPhoneNumber("+1 609-258-3000");
                new CustomerMapper().mapToCustomer(customerDto);
            }).isInstanceOf(NullPointerException.class).hasMessageContaining("Missing value");
        }
    }