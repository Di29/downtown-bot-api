package kz.downtown.jar.repository;

import kz.downtown.jar.models.Call;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CallRepository extends JpaRepository<Call, Long> {

    List<Call> findCallsByBlockName(String blockName);

    List<Call> findCallsByBlockNameAndServiceName(String blockName, String serviceName);

    List<Call> findCallsByOrderById();

}
