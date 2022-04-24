package pe.com.easyjobs.accountsapi.service;

import pe.com.easyjobs.accountsapi.entity.Technician;

import java.util.List;

public interface TechnicianService {
    Technician getById(Long id);
    Technician updateTechnician(Long id);
    Technician createTechnician(Technician technician);
    boolean deleteTechnician(Long id);
    List<Technician> getAllTechnicians();
}
