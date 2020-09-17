package kz.downtown.jar.dtos;

import kz.downtown.jar.models.Suggestion;
import lombok.Data;

@Data
public class SuggestionDTO {
    private Long id;
    private String suggestionText;
    private String blockId;
    private String serviceName;

    public SuggestionDTO(Suggestion suggestion) {
        this.setId(suggestion.getId());
        this.setSuggestionText(suggestion.getSuggestionText());
        this.setBlockId(suggestion.getBlockId());
        this.setServiceName(suggestion.getServiceName());
    }
}
