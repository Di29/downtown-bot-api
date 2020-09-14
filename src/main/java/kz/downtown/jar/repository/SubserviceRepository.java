package kz.downtown.jar.repository;

import kz.downtown.jar.models.Subservice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubserviceRepository extends JpaRepository<Subservice, Long> {

    Subservice findSubserviceBySubserviceName(String subserviceName);

    List<Subservice> findSubservicesByServiceId(Long serviceId);

}
