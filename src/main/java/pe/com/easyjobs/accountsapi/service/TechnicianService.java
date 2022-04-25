package pe.com.easyjobs.accountsapi.service;

import org.springframework.stereotype.Service;
import pe.com.easyjobs.accountsapi.entity.Technician;

import java.util.List;
@Service
public interface TechnicianService {
    Technician getById(Long id);
    Technician updateTechnician(Long id);
    Technician createTechnician(Technician technician);
    boolean deleteTechnician(Long id);
    List<Technician> getAllTechnicians();
}
