package pe.com.easyjobs.accountsapi.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import pe.com.easyjobs.accountsapi.entity.Customer;

import java.util.List;
@Qualifier("customerRepository")
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //Customer listCustomerbyId(Long id);
    //List<Customer> listAllCustomers();
}
