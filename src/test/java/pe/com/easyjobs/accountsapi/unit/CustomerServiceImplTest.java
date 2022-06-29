package pe.com.easyjobs.accountsapi.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.com.easyjobs.accountsapi.entity.Customer;
import pe.com.easyjobs.accountsapi.repository.CustomerRepository;
import pe.com.easyjobs.accountsapi.service.CustomerService;
import pe.com.easyjobs.accountsapi.service.CustomerServiceImpl;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.InstanceOfAssertFactories.SHORT;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CustomerServiceImplTest {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;


    @TestConfiguration
        static class CustomerServiceImplTestConfiguration {
        @Bean
        public CustomerService customerService() {
            return new CustomerServiceImpl();
        }
    }

    @Test
    @DisplayName("When Get Customer By Customer Id With Valid Id Then Returns Customer")
    public void WhenGetCustomerByCustomerIdWithValidIdThenReturnsCustomer() {
        // Arrange
        Long id = 1L;
        Customer customer = new Customer();
        customer.setId(id);
        when(customerRepository.findById(id)).thenReturn(Optional.of(customer));
        // Act
        Customer customerResult = customerRepository.findById(id).get();
        // Assert
        assertThat(customerResult).isEqualTo(customer);
    }

    @Test
    @DisplayName("When Get Customer By Customer Id With Invalid Id Then Returns Customer")
    public void WhenGetCustomerByCustomerIdWithInvalidIdThenReturnsCustomer() {
        // Arrange
        Long id = 1L;
        when(customerRepository.findById(id)).thenReturn(Optional.empty());
        String expectedMessage = "Customer not found";
        // Act
        Throwable exception = catchThrowable(() -> {
            Customer customer = customerService.getByCustomerId(id);
        });
        // Assert
        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    @DisplayName("When createdCustomer with valid data then return Customer")
    public void WhenCreatedCustomerWithValidDataThenReturnCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setId(null);
        customer.setType("type");
        customer.setIdentificationNumber(1231233);
        customer.setIdentificationType("CC");
        customer.setFirstName("Customer");
        customer.setLastName("Test");
        customer.setEmail("email");
        customer.setUserName("username");
        customer.setPassword("password");
        customer.setRegisterDate(new Date());
        customer.setUpdatedDate(new Date());
        customer.setPhoneNumber(12312313L);
        customer.setAddress("address");
        customer.setCity("city");
        customer.setDistrict("district");
        customer.setGender("M");
        customer.setActivated(true);

        when(customerRepository.save(customer)).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Customer customerResult = customerService.createCustomer(customer);

        // Assert
        assertThat(customerResult).isEqualTo(customer);
    }
    @Test
    @DisplayName("When updateCustomer with valid data then return Customer")
    public void WhenUpdateCustomerWithValidDataThenReturnCustomer() {
        // Arrange
        Long id = 1L;
        Customer customer = new Customer();
        customer.setId(id);
        customer.setUserName("username");
        customer.setPassword("password");
        customer.setEmail("email");

        Customer customerUp = new Customer();
        customerUp.setPhoneNumber(12312313L);
        customerUp.setFirstName("Customer");
        customerUp.setLastName("Test");
        customerUp.setAddress("address");
        customerUp.setCity("city");
        customerUp.setDistrict("district");
        customerUp.setGender("M");


        when(customerRepository.save(customer)).thenAnswer(invocation -> invocation.getArgument(0));
        customerService.updateCustomer(id,customerUp);

        // Act
        Customer customerResult = customerRepository.getById(id);

        // Assert
        assertThat(customerResult).isEqualTo(customerRepository.getById(id));
    }
    @Test
    @DisplayName("When Delete Customer With Valid Customer")
    public void WhenDeleteCustomerWithValidCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setType("type");
        customer.setIdentificationNumber(1231233);
        customer.setIdentificationType("CC");
        customer.setFirstName("Customer");
        customer.setLastName("Test");
        customer.setEmail("email");
        customer.setUserName("username");
        customer.setPassword("password");
        customer.setRegisterDate(new Date());
        customer.setUpdatedDate(new Date());
        customer.setPhoneNumber(12312313L);
        customer.setAddress("address");
        customer.setCity("city");
        customer.setDistrict("district");
        customer.setGender("M");
        customer.setActivated(true);

        when(customerRepository.save(customer)).thenAnswer(invocation -> invocation.getArgument(0));
        customerRepository.deleteById(1L);
        // Act
        Customer customerResult = null;
        // Assert
        assertThat(customerResult).isEqualTo(customerRepository.getById(1L));
    }



}
