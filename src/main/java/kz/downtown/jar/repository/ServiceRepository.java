package kz.downtown.jar.repository;

import kz.downtown.jar.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    Service findServiceByServiceName(String serviceName);
    
}
