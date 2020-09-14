package kz.downtown.jar.models;

import kz.downtown.jar.dtos.SuggestionInsertUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "suggestions")
@NoArgsConstructor
@AllArgsConstructor
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "suggestion_text")
    private String suggestionText;

    @Column(name = "block_id")
    private Long blockId;

    @Column(name = "service_name")
    private String serviceName;

    public Suggestion(SuggestionInsertUpdateDTO dto) {
        setId(dto.getId());
        setBlockId(dto.getBlockId());
        setServiceName(dto.getServiceName());
        setSuggestionText(dto.getSuggestionText());
    }

}
