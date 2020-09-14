package kz.downtown.jar.service;

import kz.downtown.jar.dtos.ServiceInsertUpdateDTO;
import kz.downtown.jar.models.Service;
import kz.downtown.jar.repository.ServiceRepository;
import kz.downtown.jar.service.interfaces.ServiceInterface;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements ServiceInterface {

    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Service getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Service getServiceByName(String name) {
        return serviceRepository.findServiceByServiceName(name);
    }

    @Override
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public void addService(ServiceInsertUpdateDTO serviceInsertUpdateDTO) {
        Service service = new Service(serviceInsertUpdateDTO);
        serviceRepository.save(service);
    }

    @Override
    public void removeServiceById(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public void updateService(ServiceInsertUpdateDTO serviceInsertUpdateDTO) throws Exception {
        if(!serviceRepository.existsById(serviceInsertUpdateDTO.getId())) {
            throw new Exception("Service doesn't exist");
        }

        Service service = new Service(serviceInsertUpdateDTO);
        serviceRepository.save(service);
    }
}
