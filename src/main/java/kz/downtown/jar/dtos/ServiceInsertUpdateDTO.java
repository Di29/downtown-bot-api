package kz.downtown.jar.dtos;

import lombok.Data;

@Data
public class ServiceInsertUpdateDTO {
    private Long id;
    private String serviceName;
    private String pictureUrl;
}
