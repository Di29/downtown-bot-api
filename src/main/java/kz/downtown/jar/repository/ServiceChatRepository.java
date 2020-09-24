package kz.downtown.jar.repository;

import kz.downtown.jar.models.ServiceChat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceChatRepository extends JpaRepository<ServiceChat, Long> {

    ServiceChat findServiceChatByChatId(Long chatId);

    ServiceChat findServiceChatsByServiceId(Long serviceId);

    List<ServiceChat> findServiceChatsByBlockId(Long blockId);

}
