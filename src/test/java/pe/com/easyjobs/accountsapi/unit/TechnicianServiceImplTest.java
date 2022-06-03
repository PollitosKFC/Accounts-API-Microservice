package pe.com.easyjobs.accountsapi.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.com.easyjobs.accountsapi.entity.Technician;
import pe.com.easyjobs.accountsapi.repository.TechnicianRepository;
import pe.com.easyjobs.accountsapi.service.TechnicianService;
import pe.com.easyjobs.accountsapi.service.TechnicianServiceImpl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class TechnicianServiceImplTest {
    @MockBean
    private TechnicianRepository technicianRepository;

    @Autowired
    private TechnicianService technicianService;


    @TestConfiguration
        static class TechnicianServiceImplTestConfiguration {
        @Bean
        public TechnicianService technicianService(){return new TechnicianServiceImpl();}
    }

    @Test
    @DisplayName("When Get Technician By Technician Id With Valid Id Then Returns Technician")
    public void WhenGetTechnicianByTechnicianIdWithValidIdThenReturnsTechnician() {
        // Arrange
        Long id = 1L;
        Technician technician = new Technician();
        technician.setId(id);
        when(technicianRepository.findById(id)).thenReturn(Optional.of(technician));
        // Act
        Technician technicianResult = technicianRepository.findById(id).get();
        // Assert
        assertThat(technicianResult).isEqualTo(technician);
    }

    @Test
    @DisplayName("When Get Technician By Technician Id With Invalid Id Then Returns Technician")
    public void WhenGetTechnicianByTechnicianIdWithInvalidIdThenReturnsTechnician() {
        // Arrange
        Long id = 1L;
        when(technicianRepository.findById(id)).thenReturn(Optional.empty());
        String expectedMessage = "Technician not found";
        // Act
        Throwable exception = catchThrowable(() -> {
            Technician technician = technicianService.getByTechnicianId(id);
        });
        // Assert
        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    @DisplayName("When createdTechnician with valid data then return Technician")
    public void WhenCreatedTechnicianWithValidDataThenReturnTechnician() {
        // Arrange
        Technician technician = new Technician();
        technician.setId(null);
        technician.setPhoneNumber(Long.valueOf(123456789));
        technician.setFirstName("firstname");
        technician.setLastName("lastname");
        technician.setAddress("address");
        technician.setCity("City");
        technician.setDistrict("District");
        technician.setVerified(false);
        technician.setGender("gender");

        when(technicianRepository.save(technician)).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Technician technicianResult = technicianService.createTechnician(technician);

        // Assert
        assertThat(technicianResult).isEqualTo(technician);
    }
}
