package kz.downtown.jar.models;

import kz.downtown.jar.dtos.ServiceChatInsertUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "service_chats")
@NoArgsConstructor
@AllArgsConstructor
public class ServiceChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "block_id")
    private Long blockId;

    @Column(name = "service_id")
    private Long serviceId;

    public ServiceChat(ServiceChatInsertUpdateDTO dto) {
        setId(dto.getId());
        setBlockId(dto.getBlockId());
        setChatId(dto.getChatId());
        setServiceId(dto.getServiceId());
    }
}
