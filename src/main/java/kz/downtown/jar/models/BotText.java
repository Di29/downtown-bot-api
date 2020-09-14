package kz.downtown.jar.models;

import kz.downtown.jar.dtos.TextInsertUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "texts")
@NoArgsConstructor
@AllArgsConstructor
public class BotText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text_name")
    private String textName;

    @Column(name = "text")
    private String text;

    public BotText(TextInsertUpdateDTO botTextDTO) {
        setId(botTextDTO.getId());
        setTextName(botTextDTO.getTextName());
        setText(botTextDTO.getText());
    }
}
