package kz.downtown.jar.dtos;

import lombok.Data;

@Data
public class ServiceChatInsertUpdateDTO {
    private Long id;
    private Long chatId;
    private Long blockId;
    private Long serviceId;
}
