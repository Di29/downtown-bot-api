package kz.downtown.jar.repository;

import kz.downtown.jar.models.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CallRepository extends JpaRepository<Call, Long> {

    List<Call> findCallsByBlockName(String blockName);

    List<Call> findCallsByBlockNameAndServiceName(String blockName, String serviceName);

    List<Call> findCallsByOrderById();

    @Query(value = "select block_name, service_name,  count(*) from calls where created_at > current_date - interval '30' day group by block_name, service_name", nativeQuery = true)
    List<String> findCallRecords();

    @Query(value = "delete from calls where created_at < CURRENT_DATE - interval '30 days'", nativeQuery = true)
    void deleteCallByDate();

}
