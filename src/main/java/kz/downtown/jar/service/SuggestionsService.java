package kz.downtown.jar.service;

import kz.downtown.jar.dtos.SuggestionInsertUpdateDTO;
import kz.downtown.jar.models.Suggestion;
import kz.downtown.jar.repository.SuggestionRepository;
import kz.downtown.jar.service.interfaces.SuggestionInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionsService implements SuggestionInterface {

    private final SuggestionRepository repository;

    public SuggestionsService(SuggestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Suggestion getSuggestionById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Suggestion> getAllSuggestions() {
        return repository.findAll();
    }

    @Override
    public List<Suggestion> getAllSuggestionsByBlockId(Long blockId) {
        return repository.findSuggestionsByBlockId(blockId);
    }

    @Override
    public List<Suggestion> getAllSuggestionsByServiceName(String serviceName) {
        return repository.findSuggestionsByServiceName(serviceName);
    }

    @Override
    public void addSuggestion(SuggestionInsertUpdateDTO suggestionInsertUpdateDTO) {
        Suggestion suggestion = new Suggestion(suggestionInsertUpdateDTO);
        repository.save(suggestion);
    }

    @Override
    public void removeSuggestionById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateSuggestion(SuggestionInsertUpdateDTO suggestionInsertUpdateDTO) throws Exception {
        if(!repository.existsById(suggestionInsertUpdateDTO.getId())) {
            throw new Exception("Suggestion doesn't exist");
        }
        Suggestion suggestion = new Suggestion(suggestionInsertUpdateDTO);
        repository.save(suggestion);
    }
}
