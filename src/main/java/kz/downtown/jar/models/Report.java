package kz.downtown.jar.models;

import kz.downtown.jar.dtos.ReportInsertUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reports")
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "report_text")
    private String reportText;

    @Column(name = "block_id")
    private String blockId;

    @Column(name = "service_name")
    private String serviceName;

    public Report(ReportInsertUpdateDTO dto) {
        setId(dto.getId());
        setBlockId(dto.getBlockId());
        setReportText(dto.getReportText());
        setServiceName(dto.getServiceName());
    }
}
