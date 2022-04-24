package pe.com.easyjobs.accountsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.easyjobs.accountsapi.entity.Technician;

import java.util.List;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    Technician listTechicianbyId(Long id);
    List<Technician> listAllTechicians();
}
