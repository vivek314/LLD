package interview.TrafficSignalSystem.repository;

import interview.TrafficSignalSystem.domain.Intersection;
import interview.TrafficSignalSystem.domain.IntersectionCycle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IntersectionRepository {
    private Map<Integer, Intersection> intersectionMap;
    private Map<Integer, IntersectionCycle> intersectionCycleMap;

    public IntersectionRepository() {
        intersectionMap = new ConcurrentHashMap<>();
        intersectionCycleMap = new ConcurrentHashMap<>();
    }

    public Map<Integer, Intersection> getIntersectionMap() {
        return intersectionMap;
    }

    public void saveIntersection(Intersection intersection){
        intersectionMap.put(intersection.getId(), intersection);
    }

    public void saveIntersectionCycle(IntersectionCycle intersectionCycle){
        intersectionCycleMap.put(intersectionCycle.getIntersectionId(), intersectionCycle);
    }

    public void updateIntersection(Intersection intersection){
        if(intersectionMap.containsKey(intersection.getId())){
            intersectionMap.put(intersection.getId(), intersection);
        } else{
            System.out.println("No intersection found with id: " + intersection.getId());
        }
    }

    public void updateIntersectionCycle(IntersectionCycle intersectionCycle){
        if(intersectionCycleMap.containsKey(intersectionCycle.getIntersectionId())){
            intersectionCycleMap.put(intersectionCycle.getIntersectionId(), intersectionCycle);
        }  else{
            System.out.println("No intersection cycle found with id: " + intersectionCycle.getIntersectionId());
        }
    }

    public Intersection getIntersectionById(int intersectionId){
        Intersection intersection = intersectionMap.get(intersectionId);
        if(intersection == null){
            System.out.println("No intersection with id " + intersectionId);
        } else{
            System.out.println("Intersection with id " + intersectionId + " found");
        }
        return intersection;
    }

    public IntersectionCycle getIntersectionCycleById(int intersectionCycleId){
        IntersectionCycle intersectionCycle = intersectionCycleMap.get(intersectionCycleId);
        if(intersectionCycle == null){
            System.out.println("No intersection cycle with id " + intersectionCycleId);
        } else{
            System.out.println("Intersection cycle with id " + intersectionCycleId + " found");
        }
        return intersectionCycle;
    }
}
