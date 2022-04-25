package pe.com.easyjobs.accountsapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.com.easyjobs.accountsapi.entity.Customer;
import pe.com.easyjobs.accountsapi.repository.CustomerRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setUpdatedDate_n(new Date());
        customer.setRegisterDate_n(new Date());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id) {
        Optional<Customer> customer = getById(id);
        if(customer == null) {
            return null;
        }
        customer.get().setUpdatedDate_n(new Date());
        return customerRepository.save(customer.get());
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
