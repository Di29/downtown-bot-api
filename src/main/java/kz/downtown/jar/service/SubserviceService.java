package kz.downtown.jar.service;

import kz.downtown.jar.dtos.SubserviceInsertUpdateDTO;
import kz.downtown.jar.models.Subservice;
import kz.downtown.jar.repository.SubserviceRepository;
import kz.downtown.jar.service.interfaces.SubserviceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubserviceService implements SubserviceInterface {

    private final SubserviceRepository repository;

    public SubserviceService(SubserviceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subservice getSubserviceById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Subservice getSubserviceByName(String name) {
        return repository.findSubserviceBySubserviceName(name);
    }

    @Override
    public List<Subservice> getSubservicesByServiceId(Long serviceId) {
        return repository.findSubservicesByServiceId(serviceId);
    }

    @Override
    public List<Subservice> getAllSubservices() {
        return repository.findAll();
    }

    @Override
    public void addSubservice(SubserviceInsertUpdateDTO subserviceInsertUpdateDTO) {
        Subservice subservice = new Subservice(subserviceInsertUpdateDTO);
        repository.save(subservice);
    }

    @Override
    public void removeSubserviceById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateSubservice(SubserviceInsertUpdateDTO subserviceInsertUpdateDTO) throws Exception {
        if(!repository.existsById(subserviceInsertUpdateDTO.getId())) {
            throw new Exception("Subservice doesn't exist");
        }
        Subservice subservice = new Subservice(subserviceInsertUpdateDTO);
        repository.save(subservice);
    }
}
