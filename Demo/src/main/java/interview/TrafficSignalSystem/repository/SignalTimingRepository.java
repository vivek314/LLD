package interview.TrafficSignalSystem.repository;

import interview.TrafficSignalSystem.domain.Direction;
import interview.TrafficSignalSystem.domain.SignalTiming;
import interview.TrafficSignalSystem.exception.TrafficStateException;

import java.util.HashMap;
import java.util.Map;

public class SignalTimingRepository {
    private Map<String, SignalTiming> timingMap;

    public SignalTimingRepository() {
        timingMap = new HashMap<String, SignalTiming>();
    }

    public void save(SignalTiming signalTiming) {
        String key = getKey(signalTiming.getIntersectionId(), signalTiming.getDirection().toString());
        timingMap.put(key, signalTiming);
    }

    private String getKey(int intersectionId, String direction) {
        return intersectionId + "-" + direction;
    }

    public void update(SignalTiming signalTiming) {
        if(!timingMap.containsKey(signalTiming.getIntersectionId())) {
            System.err.println("No timing for intersection " + signalTiming.getIntersectionId());
            return;
        }
        String key =  getKey(signalTiming.getIntersectionId(), signalTiming.getDirection().toString());
        timingMap.put(key, signalTiming);
    }

    public SignalTiming getById(int intersectionId, String direction) {
        String key = getKey(intersectionId, direction);
        return timingMap.get(key);
    }

    public SignalTiming getById(String id) {
        if(!timingMap.containsKey(id)) {
            System.err.println("No timing for id " + id);
            throw new TrafficStateException("No timing for id " + id);
        }
        return timingMap.get(id);
    }
}
