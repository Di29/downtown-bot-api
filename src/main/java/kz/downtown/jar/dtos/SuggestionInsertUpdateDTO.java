package kz.downtown.jar.dtos;

import lombok.Data;

@Data
public class SuggestionInsertUpdateDTO {
    private Long id;
    private String suggestionText;
    private String blockId;
    private String serviceName;
}
