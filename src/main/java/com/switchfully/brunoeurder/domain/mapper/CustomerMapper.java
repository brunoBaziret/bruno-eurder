package com.switchfully.brunoeurder.domain.mapper;

import com.switchfully.brunoeurder.domain.customer.Customer;
import com.switchfully.brunoeurder.domain.customer.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto mapToCustomerDto (Customer customer) {
        return new CustomerDto()
                .setCustomerUniqueID(customer.getCustomerUniqueID())
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName())
                .setEmail(customer.getEmail())
                .setAddress(customer.getAddress())
                .setPhoneNumber(customer.getPhoneNumber());
    }

    public Customer mapToCustomer(CustomerDto customerDto) {
        return new Customer(
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                customerDto.getAddress(),
                customerDto.getPhoneNumber());
    }
}
