package kz.downtown.jar.service.interfaces;

import kz.downtown.jar.dtos.ServiceInsertUpdateDTO;
import kz.downtown.jar.models.Service;

import java.util.List;

public interface ServiceInterface {

    Service getServiceById(Long id);

    Service getServiceByName(String name);

    List<Service> getAllServices();

    void addService(ServiceInsertUpdateDTO serviceInsertUpdateDTO);

    void removeServiceById(Long id);

    void updateService(ServiceInsertUpdateDTO serviceInsertUpdateDTO) throws Exception;
}
