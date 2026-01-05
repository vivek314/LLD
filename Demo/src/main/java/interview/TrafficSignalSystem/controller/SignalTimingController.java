package interview.TrafficSignalSystem.controller;

import interview.TrafficSignalSystem.service.SignalTimingService;

public class SignalTimingController {
    private SignalTimingService  signalTimingService;

    public SignalTimingController(SignalTimingService signalTimingService) {
        this.signalTimingService = signalTimingService;
    }

    public void initializeDefaultTimings(int intersectionId){
        System.out.println("Initializing default timings for intersectionId: " + intersectionId);
        signalTimingService.initializeDefaultTimings(intersectionId);
    }


}
