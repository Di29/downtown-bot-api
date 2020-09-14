package kz.downtown.jar.dtos;

import kz.downtown.jar.models.ServiceChat;
import lombok.Data;

@Data
public class ServiceChatDTO {
    private Long id;
    private Long chatId;
    private Long blockId;
    private Long serviceId;

    public ServiceChatDTO(ServiceChat serviceChat) {
        this.setId(serviceChat.getId());
        this.setChatId(serviceChat.getChatId());
        this.setBlockId(serviceChat.getBlockId());
        this.setServiceId(serviceChat.getServiceId());
    }
}
