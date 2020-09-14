package kz.downtown.jar.dtos;

import lombok.Data;

@Data
public class SubserviceInsertUpdateDTO {
    private Long id;
    private String subserviceName;
    private Long serviceId;
}
