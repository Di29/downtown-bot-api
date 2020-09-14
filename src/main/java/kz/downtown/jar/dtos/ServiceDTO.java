package kz.downtown.jar.dtos;

import kz.downtown.jar.models.Service;
import lombok.Data;

@Data
public class ServiceDTO {
    private Long id;
    private String serviceName;
    private String pictureUrl;

    public ServiceDTO(Service service) {
        this.setId(service.getId());
        this.setServiceName(service.getServiceName());
        this.setPictureUrl(service.getPictureUrl());
    }
}
