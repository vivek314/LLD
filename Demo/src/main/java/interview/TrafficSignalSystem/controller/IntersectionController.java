package interview.TrafficSignalSystem.controller;

import interview.TrafficSignalSystem.domain.Direction;
import interview.TrafficSignalSystem.domain.Intersection;
import interview.TrafficSignalSystem.domain.IntersectionCycle;
import interview.TrafficSignalSystem.domain.TrafficLight;
import interview.TrafficSignalSystem.service.IntersectionService;
import interview.TrafficSignalSystem.service.SignalTimingService;

public class IntersectionController {
    private IntersectionService intersectionService;
    private SignalTimingService signalTimingService;

    public IntersectionController(IntersectionService intersectionService,  SignalTimingService signalTimingService) {
        this.intersectionService = intersectionService;
        this.signalTimingService = signalTimingService;
    }

    public void createIntersection(int id, String name) {
        System.out.println("Creating Intersection with name: "+ name);
        //created intersection
        intersectionService.createIntersection(id, name);

        //Creating IntersectionCycle
        intersectionService.createIntersectionCycle(id);

        //initialize default timings
        signalTimingService.initializeDefaultTimings(id);

        //start the cycle
        intersectionService.startCycle(id);
        System.out.println("Intersection created successfully with id: "+ id);
    }

    public void displayStatus(int intersectionId) {
        System.out.println("Displaying status for intersection: " + intersectionId);
        Intersection intersection = intersectionService.getIntersection(intersectionId);
        if (intersection != null) {
            System.out.println("=== Intersection Status ===");
            System.out.println("ID: " + intersection.getId());
            System.out.println("Name: " + intersection.getName());
            System.out.println("Emergency Mode: " + intersection.isEmergencyMode());
            System.out.println("Cycle Paused: " + intersection.isCyclePaused());
            System.out.println("Paused Phase: " + intersectionService.getPausedPhase(intersectionId));

            System.out.println("Traffic Light States:");
            for (Direction direction : Direction.values()) {
                TrafficLight light = intersection.getTrafficLight(direction);
                System.out.println("  " + direction + ": " + light.getTrafficLightState().getState());
            }

            IntersectionCycle cycle = intersectionService.getIntersectionCycle(intersectionId);
            if (cycle != null) {
                System.out.println("Current Phase: " + cycle.getCurrentPhase());
                System.out.println("Phase Start Time: " + cycle.getPhaseStartTime());
            }
            System.out.println("========================");
        } else {
            System.out.println("Intersection not found: " + intersectionId);
        }
    }
}
