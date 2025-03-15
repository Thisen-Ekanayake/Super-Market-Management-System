package com.thisenekanayake.supermarket_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // check if customer is registered
    @GetMapping("/check/{mobile_no}")
    public boolean isCustomerRegistered(@PathVariable String mobile_no) {
        return customerService.findCustomerByMobile(mobile_no).isPresent();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerEntity customer) {
        CustomerEntity savedCustomer = customerService.registerCustomer(customer);
        return ResponseEntity.ok(Map.of(
                "messege", "Customer registered successfully!",
                "customer", savedCustomer
        ));
    }
}
