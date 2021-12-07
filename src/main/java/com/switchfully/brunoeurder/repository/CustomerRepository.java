package com.switchfully.brunoeurder.repository;

import com.switchfully.brunoeurder.domain.customer.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository {
    private final List<Customer> customerList;

    public CustomerRepository() {
        this.customerList = new ArrayList<>();
    }

    public void add(Customer customer) {
        customerList.add(customer);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    @Override
    public String toString() {
        return "CustomerRepository{" +
                "customerList=" + customerList +
                '}';
    }
}
