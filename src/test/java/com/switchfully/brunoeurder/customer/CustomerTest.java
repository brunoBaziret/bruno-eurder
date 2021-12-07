package com.switchfully.brunoeurder.customer;

import com.switchfully.brunoeurder.domain.customer.Address;
import com.switchfully.brunoeurder.domain.customer.Customer;
import com.switchfully.brunoeurder.domain.customer.CustomerDto;
import com.switchfully.brunoeurder.domain.mapper.CustomerMapper;
import com.switchfully.brunoeurder.repository.customer.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class CustomerTest {
    @Test
    void givenCustomerInformation_whenCreatingNewCustomerUserAndAddingItToCustomerRepository_thenCustomerRepositoryContainsNewCustomerUser() {
        //GIVEN
        //Customer information = Albert Einstein, albert@einstein.com, 112 Mercer St, NJ, 08544 USA, +1 609-258-3000
        //WHEN
        CustomerDto customerDto = new CustomerDto()
                .setFirstName("Albert")
                .setLastName("Einstein")
                .setEmail("albert@einstein.com")
                .setAddress(new Address("Mercer Street", "112", "08544, NJ", "Princeton", "USA"))
                .setPhoneNumber("+1 609-258-3000");

        Customer expected = new CustomerMapper().mapToCustomer(customerDto);

        CustomerRepository actual = new CustomerRepository();
        actual.add(expected);

        //THEN

        Assertions.assertThat(actual.getCustomerList()).containsExactly(expected);
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