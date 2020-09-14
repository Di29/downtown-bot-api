package kz.downtown.jar.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CallInsertUpdateDTO {
    private Long id;
    private String blockName;
    private String serviceName;
    private String subserviceName;
    private Long officeNumber;
    private Date createdAt;
}
