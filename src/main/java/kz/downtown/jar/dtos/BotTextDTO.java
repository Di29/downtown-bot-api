package kz.downtown.jar.dtos;

import kz.downtown.jar.models.BotText;
import lombok.Data;

@Data
public class BotTextDTO {
    private Long id;
    private String textName;
    private String text;

    public BotTextDTO(BotText text) {
        this.setId(text.getId());
        this.setTextName(text.getTextName());
        this.setText(text.getText());
    }
}
