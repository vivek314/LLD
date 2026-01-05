package interview.TrafficSignalSystem.service;

import interview.TrafficSignalSystem.domain.Direction;
import interview.TrafficSignalSystem.domain.Intersection;
import interview.TrafficSignalSystem.domain.IntersectionCycle;
import interview.TrafficSignalSystem.exception.TrafficStateException;
import interview.TrafficSignalSystem.repository.IntersectionRepository;
import interview.TrafficSignalSystem.repository.SignalTimingRepository;

public class IntersectionService {
    private IntersectionRepository intersectionRepository;
    private SignalTimingRepository signalTimingRepository;

    public IntersectionService(IntersectionRepository intersectionRepository) {
        this.intersectionRepository = intersectionRepository;
    }

    public void createIntersection(int id, String name) {
        Intersection intersection = new Intersection(id, name);
        intersectionRepository.saveIntersection(intersection);
        System.out.println("Creating Intersection with name: "+ name);
    }

    public void createIntersectionCycle(int id) {
        IntersectionCycle intersectionCycle = new IntersectionCycle(id);
        intersectionRepository.saveIntersectionCycle(intersectionCycle);
        System.out.println("Creating IntersectionCycle with id: "+ id);
    }

    public Intersection getIntersection(int id){
        return intersectionRepository.getIntersectionById(id);
    }

    public IntersectionCycle getIntersectionCycle(int id){
        return intersectionRepository.getIntersectionCycleById(id);
    }

    public void pauseCycle(int intersectionId){
        Intersection intersection = getIntersection(intersectionId);
        IntersectionCycle intersectionCycle = intersectionRepository.getIntersectionCycleById(intersectionId);
        if(intersectionCycle != null){
            intersection.setCyclePaused(true);
            intersectionCycle.setPaused(true);
            intersectionCycle.setPausedAtPhase(intersectionCycle.getPausedAtPhase());
            intersectionCycle.setPauseStartTime(System.currentTimeMillis());
            System.out.println("Cycle paused for intersection: "+ intersectionId);
        }
    }

    public void resumeCycle(int intersectionId){
        Intersection intersection = getIntersection(intersectionId);
        if(intersection == null){
            System.out.println("No intersection with id: "+ intersectionId);
            return;
        }
        IntersectionCycle intersectionCycle = intersectionRepository.getIntersectionCycleById(intersectionId);
        if(intersectionCycle != null){
            intersection.setCyclePaused(false);
            intersectionCycle.setPaused(false);
            System.out.println("Cycle resumed for intersection: "+ intersectionId);
        }
    }

    public int getPausedPhase(int intersectionId){
        IntersectionCycle intersectionCycle = getIntersectionCycle(intersectionId);
        if(intersectionCycle == null){
            System.out.println("No intersection with id: "+ intersectionId);
            throw new TrafficStateException("No intersection with id: "+ intersectionId);
        }
        return intersectionCycle.getPausedAtPhase();
    }

    public void startCycle(int intersectionId){
        Intersection intersection = getIntersection(intersectionId);
        if(intersection == null){
            System.out.println("No intersection with id: "+ intersectionId);
            return;
        }
        IntersectionCycle intersectionCycle = getIntersectionCycle(intersectionId);
        if(intersectionCycle == null){
            System.out.println("No intersectionCycle with id: "+ intersectionId);
            return;
        }
        intersectionCycle.setPaused(false);
        intersection.setCyclePaused(false);

        //TODO: Real Implementation goes here
    }

    public void turnAllSignalToRed(int intersectionId){
        Intersection intersection = getIntersection(intersectionId);
        if(intersection == null){
            System.out.println("No intersection with id: "+ intersectionId);
            return;
        }
        intersection.turnAllSignalsToRed();
    }

    public void turnSignalToGreen(int intersectionId, Direction direction){
        Intersection intersection = getIntersection(intersectionId);
        if(intersection == null){
            System.out.println("No intersection with id: "+ intersectionId);
            return;
        }
        intersection.turnSignalToGreen(direction);
    }
}
