package kz.downtown.jar.dtos;

import lombok.Data;

@Data
public class ReportInsertUpdateDTO {
    private Long id;
    private String reportText;
    private String blockId;
    private String serviceName;
}
