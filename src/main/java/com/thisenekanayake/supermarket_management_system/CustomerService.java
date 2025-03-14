package com.thisenekanayake.supermarket_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerEntity registerCustomer(CustomerEntity customer) {
        return customerRepository.save(customer); // save customer to the database
    }
}
