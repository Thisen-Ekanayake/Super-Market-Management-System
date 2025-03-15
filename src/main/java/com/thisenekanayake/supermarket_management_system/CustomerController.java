package com.thisenekanayake.supermarket_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.MarshalledObject;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // unified endpoint: check if registered & register if not
    @PostMapping("/check-or-register")
    public ResponseEntity<?> checkOrRegisterCustomer(@RequestBody Map<String, String> payload) {
        String mobile_no = payload.get("mobile_no");

        Optional<CustomerEntity> existingCustomer = customerService.findCustomerByMobile(mobile_no);

        if (existingCustomer.isPresent()) {
            return ResponseEntity.ok(Map.of(
                    "message", "Customer is already registered!",
                    "customer", existingCustomer.get()
            ));
        }

        // if not registered, check if they want to register
        if (payload.containsKey("fullName")) {
            CustomerEntity newCustomer = new CustomerEntity();
            newCustomer.setfullName(payload.get("fullName"));
            newCustomer.setMobile_no(Long.parseLong(mobile_no)); // convert string to long
            newCustomer.setAddress(payload.get("address")); // no need to declare string
            newCustomer.setEmail(payload.get("email"));
            newCustomer.setNic(Long.parseLong(payload.get("nic"))); // convert string to long

            CustomerEntity savedCustomer = customerService.registerCustomer(newCustomer);
            return ResponseEntity.ok(Map.of(
                    "message", "Customer registered successfully!",
                    "customer", savedCustomer
            ));
        }

        return ResponseEntity.ok(Map.of("message", "Customer is not registered."));
    }
}