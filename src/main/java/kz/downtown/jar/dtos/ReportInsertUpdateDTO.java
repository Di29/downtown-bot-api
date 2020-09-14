package kz.downtown.jar.dtos;

import lombok.Data;

@Data
public class ReportInsertUpdateDTO {
    private Long id;
    private String reportText;
    private Long blockId;
    private String serviceName;
}
