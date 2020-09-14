package kz.downtown.jar.service.interfaces;

import kz.downtown.jar.dtos.ReportInsertUpdateDTO;
import kz.downtown.jar.models.Report;

import java.util.List;

public interface ReportInterface {

    Report getReportById(Long id);

    List<Report> getAllReports();

    List<Report> getReportsByBlockId(Long id);

    List<Report> getReportsByServiceName(String name);

    void addReport(ReportInsertUpdateDTO reportInsertUpdateDTO);

    void removeReportById(Long id);

    void updateReport(ReportInsertUpdateDTO reportInsertUpdateDTO) throws Exception;
}
