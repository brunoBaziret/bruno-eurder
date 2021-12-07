package com.switchfully.brunoeurder.service.customer;

import com.switchfully.brunoeurder.domain.customer.Customer;
import com.switchfully.brunoeurder.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) {
        customerRepository.add(customer);
    }
}
