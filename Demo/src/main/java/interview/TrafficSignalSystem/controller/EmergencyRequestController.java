package interview.TrafficSignalSystem.controller;

import interview.TrafficSignalSystem.domain.Direction;
import interview.TrafficSignalSystem.service.EmergencyRequestService;

public class EmergencyRequestController {
    private EmergencyRequestService emergencyRequestService;
    public EmergencyRequestController(EmergencyRequestService emergencyRequestService) {
        this.emergencyRequestService = emergencyRequestService;
    }

    public void requestEmergency(int intersectionId, Direction direction, int duration){
        System.out.println("Emergency requested for intersectionId: "+
                intersectionId + "Direction: "+ direction + "Duration: "+ duration);
        emergencyRequestService.requestEmergency(intersectionId, direction, duration);
    }

    public void endEmergency(int intersectionId){
        System.out.println("Emergency end requested for intersectionId: " + intersectionId);
        emergencyRequestService.endEmergency(intersectionId);
    }
}
