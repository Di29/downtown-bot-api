package kz.downtown.jar.service.interfaces;

import kz.downtown.jar.dtos.SuggestionInsertUpdateDTO;
import kz.downtown.jar.models.Suggestion;

import java.util.List;

public interface SuggestionInterface {

    Suggestion getSuggestionById(Long id);

    List<Suggestion> getAllSuggestions();

    List<Suggestion> getAllSuggestionsByBlockId(Long blockId);

    List<Suggestion> getAllSuggestionsByServiceName(String serviceName);

    void addSuggestion(SuggestionInsertUpdateDTO suggestionInsertUpdateDTO);

    void removeSuggestionById(Long id);

    void updateSuggestion(SuggestionInsertUpdateDTO suggestionInsertUpdateDTO) throws Exception;
}
