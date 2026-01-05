package interview.TrafficSignalSystem.repository;

import interview.TrafficSignalSystem.domain.EmergencyRequest;

import java.util.HashMap;
import java.util.Map;

public class EmergencyRequestRepository {
    int counter = 0;
    private Map<Integer, EmergencyRequest> emergencyRequestMap;
    public EmergencyRequestRepository(){
        emergencyRequestMap = new HashMap<Integer, EmergencyRequest>();
    }

    public void saveEmergencyRequest(EmergencyRequest emergencyRequest){
        emergencyRequestMap.put(emergencyRequest.getId(), emergencyRequest);
    }

    public EmergencyRequest getEmergencyRequest(int emergencyRequestId){
        if(emergencyRequestMap.containsKey(emergencyRequestId)){
            return emergencyRequestMap.get(emergencyRequestId);
        } else{
            System.out.println("Emergency Request Not Found with id: "+emergencyRequestId);
            return null;
        }
    }
    public void updateEmergencyRequest(EmergencyRequest emergencyRequest){
        if(emergencyRequestMap.containsKey(emergencyRequest.getId())){
            emergencyRequestMap.put(emergencyRequest.getId(), emergencyRequest);
        } else{
            System.out.println("Emergency Request Not Found with id: "+emergencyRequest.getId());
        }
    }

    public int getNextId(){
        return counter++;
    }
}
