package kz.downtown.jar.dtos;

import kz.downtown.jar.models.Report;
import lombok.Data;

@Data
public class ReportDTO {
    private Long id;
    private String reportText;
    private String blockId;
    private String serviceName;

    public ReportDTO(Report report) {
        this.setId(report.getId());
        this.setReportText(report.getReportText());
        this.setBlockId(report.getBlockId());
        this.setServiceName(report.getServiceName());
    }
}
