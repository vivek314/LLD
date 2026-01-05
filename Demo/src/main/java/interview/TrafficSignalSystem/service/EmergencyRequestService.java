package interview.TrafficSignalSystem.service;

import interview.TrafficSignalSystem.domain.Direction;
import interview.TrafficSignalSystem.domain.EmergencyRequest;
import interview.TrafficSignalSystem.domain.Intersection;
import interview.TrafficSignalSystem.domain.IntersectionCycle;
import interview.TrafficSignalSystem.repository.EmergencyRequestRepository;

public class EmergencyRequestService {
    private EmergencyRequestRepository  emergencyRequestRepository;
    private IntersectionService intersectionService;

    public EmergencyRequestService(EmergencyRequestRepository emergencyRequestRepository,  IntersectionService intersectionService) {
        this.emergencyRequestRepository = emergencyRequestRepository;
        this.intersectionService = intersectionService;
    }

    public void requestEmergency(int intersectionId, Direction direction, int duration) {
        //Create ER
        int id = emergencyRequestRepository.getNextId();
        EmergencyRequest emergencyRequest = new EmergencyRequest(id, intersectionId, direction, duration);
        emergencyRequestRepository.saveEmergencyRequest(emergencyRequest);

        //pause the cycle
        intersectionService.pauseCycle(intersectionId);

        //turn all signals to red in the intersection
        intersectionService.turnAllSignalToRed(intersectionId);

        //turn the signal which is responsible for the emergency to green
        intersectionService.turnSignalToGreen(intersectionId, direction);

        intersectionService.getIntersection(intersectionId).setEmergencyMode(true);
        intersectionService.getIntersection(intersectionId).setEmergencyDirection(direction);

        System.out.println("Emergency request has been processed with request id: " + id +
                " intersection id: " + intersectionId +
                " Direction: " + direction +
                "Duration: " + duration);
    }

    public void endEmergency(int intersectionId) {
        EmergencyRequest emergencyRequest =  emergencyRequestRepository.getEmergencyRequest(intersectionId);
        if (emergencyRequest == null) {
            System.out.println("No Emergency request has found with request id: " + intersectionId);
            return;
        }
        emergencyRequest.setActive(false);
        intersectionService.turnAllSignalToRed(intersectionId);

        Intersection intersection = intersectionService.getIntersection(intersectionId);
        if(intersection == null){
            System.out.println("No intersection has been found with request id: " + intersectionId);
            return;
        }
        intersection.setEmergencyMode(false);
        intersection.setEmergencyDirection(null);

        intersectionService.resumeCycle(intersectionId);
        System.out.println("Emergency request has been processed with request id: " + intersectionId);
    }
}
