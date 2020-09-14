package kz.downtown.jar.repository;

import kz.downtown.jar.models.BotText;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<BotText, Long> {

    BotText findBotTextByText(String text);

}
