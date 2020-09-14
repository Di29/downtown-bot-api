package kz.downtown.jar.service;

import kz.downtown.jar.dtos.CallInsertUpdateDTO;
import kz.downtown.jar.models.Call;
import kz.downtown.jar.repository.CallRepository;
import kz.downtown.jar.service.interfaces.CallInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallService implements CallInterface {

    private final CallRepository callRepository;

    public CallService(CallRepository callRepository) {
        this.callRepository = callRepository;
    }

    @Override
    public Call getCallById(Long id) {
        return callRepository.findById(id).orElse(null);
    }

    @Override
    public List<Call> getAllCalls() {
        return callRepository.findAll();
    }

    @Override
    public List<Call> getCallsByBlockName(String blockName) {
        return callRepository.findCallsByBlockName(blockName);
    }

    @Override
    public List<Call> getCallsByBlockNameAndServiceName(String blockName, String serviceName) {
        return callRepository.findCallsByBlockNameAndServiceName(blockName, serviceName);
    }

    @Override
    public List<Call> getCallsSorted() {
        return callRepository.findCallsByOrderById();
    }

    @Override
    public void addCall(CallInsertUpdateDTO callInsertUpdateDTO) {
        Call call = new Call(callInsertUpdateDTO);
        callRepository.save(call);
    }

    @Override
    public void removeCallById(Long id) {
        callRepository.deleteById(id);
    }

    @Override
    public void updateCall(CallInsertUpdateDTO callInsertUpdateDTO) throws Exception {
        if(!callRepository.existsById(callInsertUpdateDTO.getId())) {
            throw new Exception("Call doesn't exist");
        }

        Call call = new Call(callInsertUpdateDTO);
        callRepository.save(call);
    }
}
