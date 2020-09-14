package kz.downtown.jar.service.interfaces;

import kz.downtown.jar.dtos.SubserviceInsertUpdateDTO;
import kz.downtown.jar.models.Subservice;

import java.util.List;

public interface SubserviceInterface {

    Subservice getSubserviceById(Long id);

    Subservice getSubserviceByName(String name);

    List<Subservice> getSubservicesByServiceId(Long serviceId);

    List<Subservice> getAllSubservices();

    void addSubservice(SubserviceInsertUpdateDTO subserviceInsertUpdateDTO);

    void removeSubserviceById(Long id);

    void updateSubservice(SubserviceInsertUpdateDTO subserviceInsertUpdateDTO) throws Exception;
}
