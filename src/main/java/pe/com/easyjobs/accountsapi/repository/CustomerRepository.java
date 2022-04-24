package pe.com.easyjobs.accountsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.easyjobs.accountsapi.entity.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer listCustomerbyId(Long id);
    List<Customer> listAllCustomers();
}
