package kz.downtown.jar.rest;

import kz.downtown.jar.dtos.ReportInsertUpdateDTO;
import kz.downtown.jar.models.Report;
import kz.downtown.jar.service.ReportService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reports")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllReports(){
        List<Report> reports = service.getAllReports();
        if (reports.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @RequestMapping(value = "id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getReportById(@PathVariable("id") Long id) {
        Report report = service.getReportById(id);
        if(report == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @RequestMapping(value = "block/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getReportsByBlockId(@PathVariable("id") Long id) {
        List<Report> reports = service.getReportsByBlockId(id);
        if (reports.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @RequestMapping(value = "service/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getReportsByServiceName(@PathVariable("name") String name) {
        List<Report> reports = service.getReportsByServiceName(name);
        if (reports.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<?> addReport(@RequestBody ReportInsertUpdateDTO dto) {
        try {
            service.addReport(dto);
        } catch (Exception e ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An exception occurred");
        }
        return ResponseEntity.ok().body("Report added");
    }

    @RequestMapping(value = "admin/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeReportById(@PathVariable("id") Long id) {
        try {
            service.removeReportById(id);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An exception occurred");
        }

        return ResponseEntity.ok().body("Report deleted");
    }
}
