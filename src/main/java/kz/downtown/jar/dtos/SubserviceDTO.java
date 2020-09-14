package kz.downtown.jar.dtos;

import kz.downtown.jar.models.Subservice;
import lombok.Data;

@Data
public class SubserviceDTO {
    private Long id;
    private String subserviceName;
    private Long serviceId;

    public SubserviceDTO(Subservice subservice) {
        this.setId(subservice.getId());
        this.setSubserviceName(subservice.getSubserviceName());
        this.setServiceId(subservice.getServiceId());
    }
}
