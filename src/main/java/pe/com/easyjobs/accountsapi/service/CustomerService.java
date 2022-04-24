package pe.com.easyjobs.accountsapi.service;

import pe.com.easyjobs.accountsapi.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer getById(Long id);
    Customer updateCustomer(Long id);
    Customer createCustomer(Customer customer);
    boolean deleteCustomer(Long id);
    List<Customer> getAllCustomers();
}
