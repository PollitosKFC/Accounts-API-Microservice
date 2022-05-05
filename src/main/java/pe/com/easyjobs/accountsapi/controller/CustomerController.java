package pe.com.easyjobs.accountsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.com.easyjobs.accountsapi.entity.Customer;
import pe.com.easyjobs.accountsapi.service.CustomerService;

import java.util.List;
import java.util.Optional;
@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/createCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer customerCreated = customerService.createCustomer(customer);
        return ResponseEntity.ok(customerCreated);
    }

    @GetMapping(value = "/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping(value = "/getCustomerById/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
        Customer customer = customerService.getByCustomerId(id);
        return ResponseEntity.ok(customer);
    }

    @PutMapping(value = "/updateCustomer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer){
        Customer customerUpdated = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(customerUpdated);
    }

    @PutMapping(value = "/deleteCustomer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
        Customer customerDeleted = customerService.deleteCustomer(id);
        return ResponseEntity.ok(customerDeleted);
    }

}

