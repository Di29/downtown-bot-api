package kz.downtown.jar.service;

import kz.downtown.jar.dtos.ReportInsertUpdateDTO;
import kz.downtown.jar.models.Report;
import kz.downtown.jar.repository.ReportRepository;
import kz.downtown.jar.service.interfaces.ReportInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService implements ReportInterface {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Report getReportById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public List<Report> getReportsByBlockId(Long id) {
        return reportRepository.findReportsByBlockId(id);
    }

    @Override
    public void addReport(ReportInsertUpdateDTO reportInsertUpdateDTO) {
        Report report = new Report(reportInsertUpdateDTO);
        reportRepository.save(report);
    }

    @Override
    public void removeReportById(Long id) {
        reportRepository.deleteById(id);
    }

    @Override
    public void updateReport(ReportInsertUpdateDTO reportInsertUpdateDTO) throws Exception {
        if(!reportRepository.existsById(reportInsertUpdateDTO.getId())) {
            throw new Exception("Report doesn't exist");
        }
        Report report = new Report(reportInsertUpdateDTO);
        reportRepository.save(report);
    }
}
