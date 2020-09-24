package kz.downtown.jar.service;

import kz.downtown.jar.dtos.ServiceChatInsertUpdateDTO;
import kz.downtown.jar.models.ServiceChat;
import kz.downtown.jar.repository.ServiceChatRepository;
import kz.downtown.jar.service.interfaces.ServiceChatInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceChatService implements ServiceChatInterface {

    private final ServiceChatRepository repository;

    public ServiceChatService(ServiceChatRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceChat getServiceChatById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ServiceChat getServiceChatByChatId(Long chatId) {
        return repository.findServiceChatByChatId(chatId);
    }

    @Override
    public List<ServiceChat> getAllServiceChats() {
        return repository.findAll();
    }

    @Override
    public List<ServiceChat> getServiceChatsByServiceId(Long serviceId) {
        return repository.findServiceChatsByServiceId(serviceId);
    }

    @Override
    public List<ServiceChat> getServiceChatsByBlockId(Long blockId) {
        return repository.findServiceChatsByBlockId(blockId);
    }

    @Override
    public void addServiceChat(ServiceChatInsertUpdateDTO serviceChatInsertUpdateDTO) {
        ServiceChat serviceChat = new ServiceChat(serviceChatInsertUpdateDTO);
        repository.save(serviceChat);
    }

    @Override
    public void removeServiceChatById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateServiceChat(ServiceChatInsertUpdateDTO serviceChatInsertUpdateDTO) throws Exception {
        if(!repository.existsById(serviceChatInsertUpdateDTO.getId())) {
            throw new Exception("Service chat doesnt exist");
        }
        ServiceChat serviceChat = new ServiceChat(serviceChatInsertUpdateDTO);
        repository.save(serviceChat);
    }
}
