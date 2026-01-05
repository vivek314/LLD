package interview.TrafficSignalSystem.domain;

import interview.LoggingFramework.logger.Logger;
import interview.LoggingFramework.logger.LoggerImpl;

import java.time.Duration;

public class EmergencyRequest {
    Logger logger = new LoggerImpl("EmergencyRequest");

    private final int id;
    private final int intersectionId;
    private Direction direction;
    private boolean isActive;
    private long requestTime;
    private int duration;

    public EmergencyRequest(int id, int intersectionId, Direction direction, int duration) {
        this.intersectionId = intersectionId;
        this.direction = direction;
        this.duration = duration;
        this.requestTime = System.currentTimeMillis();
        this.isActive = true;
        this.id = id;

        logger.info("Created EmergencyRequest for intersectionId: " + intersectionId);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getId() {
        return id;
    }

    public int getIntersectionId() {
        return intersectionId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
