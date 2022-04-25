package pe.com.easyjobs.accountsapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.com.easyjobs.accountsapi.entity.Technician;
import pe.com.easyjobs.accountsapi.repository.TechnicianRepository;

import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TechnicianServiceImpl implements TechnicianService{

    @Autowired
    private TechnicianRepository technicianRepository;

    @Override
    public Technician getById(Long id) {
        return technicianRepository.findById(id).orElse(null);
    }

    @Override
    public Technician createTechnician(Technician technician) {
        technician.setUpdatedDate_n(new Date());
        technician.setRegisterDate_n(new Date());
        return technicianRepository.save(technician);
    }

    @Override
    public Technician updateTechnician(Long id) {
        Technician technician = getById(id);
        if(technician == null) {
            return null;
        }
        technician.setUpdatedDate_n(new Date());
        return technicianRepository.save(technician);
    }

    @Override
    public boolean deleteTechnician(Long id) {
        technicianRepository.deleteById(id);
        if (getById(id) == null) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();
    }
}
