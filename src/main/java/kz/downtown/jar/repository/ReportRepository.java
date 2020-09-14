package kz.downtown.jar.repository;

import kz.downtown.jar.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findReportsByBlockId(Long blockId);

    List<Report> findReportsByServiceName(String name);

}
