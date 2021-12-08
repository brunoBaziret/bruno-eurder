package com.switchfully.brunoeurder.api.user;

import com.switchfully.brunoeurder.domain.customer.Customer;
import com.switchfully.brunoeurder.domain.customer.CustomerDto;
import com.switchfully.brunoeurder.domain.mapper.CustomerMapper;
import com.switchfully.brunoeurder.service.customer.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customers")

public class UserController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateCustomerAccount(@RequestBody CustomerDto customerDto, @RequestHeader(required = false) String authorization) {
        logger.info("Method 'createCustomerAccount' started");
        Customer customer = customerMapper.mapToCustomer(customerDto);
        customerService.saveCustomer(customer);
        logger.info("Method 'createCustomerAccount' finished");
    }
}
