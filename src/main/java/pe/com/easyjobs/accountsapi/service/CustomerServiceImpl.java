package pe.com.easyjobs.accountsapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.easyjobs.accountsapi.entity.Customer;
import pe.com.easyjobs.accountsapi.repository.CustomerRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setUpdatedDate(new Date());
        customer.setRegisterDate(new Date());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id) {
        Customer customer = getById(id);
        if(customer == null) {
            return null;
        }
        customer.setUpdatedDate(new Date());
        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        if (getById(id) == null) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}
