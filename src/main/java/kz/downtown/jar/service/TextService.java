package kz.downtown.jar.service;

import kz.downtown.jar.dtos.TextInsertUpdateDTO;
import kz.downtown.jar.models.BotText;
import kz.downtown.jar.repository.TextRepository;
import kz.downtown.jar.service.interfaces.TextInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextService implements TextInterface {

    private final TextRepository textRepository;

    public TextService(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    @Override
    public BotText getTextById(Long id) {
        return textRepository.findById(id).orElse(null);
    }

    @Override
    public List<BotText> getAllTexts() {
        return textRepository.findAll();
    }

    @Override
    public BotText getTextByTextName(String textName) {
        return textRepository.findBotTextByText(textName);
    }

    @Override
    public void updateText(TextInsertUpdateDTO textInsertUpdateDTO) throws Exception {
        if (!textRepository.existsById(textInsertUpdateDTO.getId())) {
            throw new Exception("Text doesn't exist");
        }

        BotText text = new BotText(textInsertUpdateDTO);
        textRepository.save(text);
    }
}
