package kz.downtown.jar.repository;

import kz.downtown.jar.models.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

    List<Suggestion> findSuggestionsByBlockId(Long blockId);

    List<Suggestion> findSuggestionsByServiceName(String serviceName);
}
