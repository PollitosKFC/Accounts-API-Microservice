package pe.com.easyjobs.accountsapi.service;

import org.springframework.stereotype.Service;
import pe.com.easyjobs.accountsapi.entity.Customer;

import java.util.List;
import java.util.Optional;
@Service
public interface CustomerService {
    Optional<Customer> getById(Long id) throws Exception;
    Customer updateCustomer(Long id);
    Customer createCustomer(Customer customer);
    boolean deleteCustomer(Long id);
    List<Customer> getAllCustomers();
}
