package kz.downtown.jar.service.interfaces;

import kz.downtown.jar.dtos.ServiceChatInsertUpdateDTO;
import kz.downtown.jar.models.ServiceChat;

import java.util.List;

public interface ServiceChatInterface {

    ServiceChat getServiceChatById(Long id);

    ServiceChat getServiceChatByChatId(Long chatId);

    List<ServiceChat> getAllServiceChats();

    List<ServiceChat> getServiceChatsByServiceId(Long serviceId);

    List<ServiceChat> getServiceChatsByBlockId(Long blockId);

    void addServiceChat(ServiceChatInsertUpdateDTO serviceChatInsertUpdateDTO);

    void removeServiceChatById(Long id);

    void updateServiceChat(ServiceChatInsertUpdateDTO serviceChatInsertUpdateDTO) throws Exception;
}
