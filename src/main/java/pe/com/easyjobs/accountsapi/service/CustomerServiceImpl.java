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
    public Customer getByCustomerId(Long id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setRegisterDate(new Date());
        newCustomer.setUpdatedDate(new Date());
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setPassword(customer.getPassword());
        newCustomer.setPhoneNumber(customer.getPhoneNumber());
        newCustomer.setAddress(customer.getAddress());
        newCustomer.setCity(customer.getCity());
        newCustomer.setDistrict(customer.getDistrict());
        newCustomer.setGender(customer.getGender());
        newCustomer.setType("CUSTOMER");
        newCustomer.setActivated(true);
        newCustomer.setIdentificationType(customer.getIdentificationType());
        newCustomer.setIdentificationNumber(customer.getIdentificationNumber());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer customerToUpdate = customerRepository.getById(id);
        if(customerToUpdate == null) {
            return null;
        }
        customerToUpdate.setUpdatedDate(new Date());
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
        customerToUpdate.setAddress(customer.getAddress());
        customerToUpdate.setCity(customer.getCity());
        customerToUpdate.setDistrict(customer.getDistrict());
        customerToUpdate.setGender(customer.getGender());
        customerToUpdate.setIdentificationType(customer.getIdentificationType());
        customerToUpdate.setIdentificationNumber(customer.getIdentificationNumber());
        return customerRepository.save(customerToUpdate);
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customerToDeactivate = customerRepository.getById(id);
        if(customerToDeactivate == null) {
            return null;
        }
        customerToDeactivate.setActivated(false);
        return customerRepository.save(customerToDeactivate);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}
