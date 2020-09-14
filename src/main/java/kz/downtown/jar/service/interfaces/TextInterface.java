package kz.downtown.jar.service.interfaces;

import kz.downtown.jar.dtos.TextInsertUpdateDTO;
import kz.downtown.jar.models.BotText;

import java.util.List;

public interface TextInterface {

    BotText getTextById(Long id);

    List<BotText> getAllTexts();

    BotText getTextByTextName(String textName);

    void updateText(TextInsertUpdateDTO textInsertUpdateDTO) throws Exception;

}
