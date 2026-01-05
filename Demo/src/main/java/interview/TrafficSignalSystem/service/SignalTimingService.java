package interview.TrafficSignalSystem.service;

import interview.TrafficSignalSystem.domain.Direction;
import interview.TrafficSignalSystem.domain.SignalTiming;
import interview.TrafficSignalSystem.repository.SignalTimingRepository;

public class SignalTimingService {
    private SignalTimingRepository signalTimingRepository;

    public SignalTimingService(SignalTimingRepository signalTimingRepository) {
        this.signalTimingRepository = signalTimingRepository;
    }

    public void initializeDefaultTimings(int intersectionId) {
        SignalTiming northSignal = new SignalTiming(intersectionId, Direction.NORTH);
        SignalTiming eastSignal = new SignalTiming(intersectionId, Direction.EAST);
        SignalTiming westSignal = new SignalTiming(intersectionId, Direction.WEST);
        SignalTiming southSignal = new SignalTiming(intersectionId, Direction.SOUTH);

        //save all of them
        signalTimingRepository.save(northSignal);
        signalTimingRepository.save(eastSignal);
        signalTimingRepository.save(westSignal);
        signalTimingRepository.save(southSignal);
    }
}
