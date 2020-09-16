package kz.downtown.jar.service.interfaces;

import kz.downtown.jar.dtos.CallInsertUpdateDTO;
import kz.downtown.jar.models.Call;

import java.util.List;

public interface CallInterface {

    Call getCallById(Long id);

    List<Call> getAllCalls();

    List<Call> getCallsByBlockName(String blockName);

    List<Call> getCallsByBlockNameAndServiceName(String blockName, String serviceName);

    List<Call> getCallsSorted();

    void addCall(CallInsertUpdateDTO callInsertUpdateDTO);

    void removeCallById(Long id);

    void updateCall(CallInsertUpdateDTO callInsertUpdateDTO) throws Exception;

    List<String> detRecords();
}
