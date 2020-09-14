package kz.downtown.jar.dtos;

import kz.downtown.jar.models.Call;
import lombok.Data;

import java.util.Date;

@Data
public class CallDTO {
    private Long id;
    private String blockName;
    private String serviceName;
    private String subserviceName;
    private Long officeNumber;
    private Date createdAt;

    public CallDTO(Call call) {
        this.setBlockName(call.getBlockName());
        this.setServiceName(call.getServiceName());
        this.setSubserviceName(call.getSubserviceName());
        this.setOfficeNumber(call.getOfficeNumber());
        this.setCreatedAt(call.getCreatedAt());
    }
}
