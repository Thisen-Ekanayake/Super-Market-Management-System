package com.thisenekanayake.supermarket_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<CustomerEntity> findCustomerByMobile(String mobile_no) {
        return customerRepository.findByMobileNumber(mobile_no);
    }

    public CustomerEntity registerCustomer(CustomerEntity customer) {
        return customerRepository.save(customer); // save customer to the database
    }
}
