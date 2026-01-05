package interview.TrafficSignalSystem.domain;

import interview.LoggingFramework.logger.Logger;
import interview.LoggingFramework.logger.LoggerImpl;
import interview.TrafficSignalSystem.Constants;

public class SignalTiming {

    Logger logger = new LoggerImpl("SignalTiming");
    private final int intersectionId;
    private Direction direction;
    private int greenDuration;
    private boolean isDynamic;

    public SignalTiming(int intersectionId, Direction direction) {
        this.intersectionId = intersectionId;
        this.direction = direction;
        this.greenDuration = Constants.GREEN_DURATION;
        this.isDynamic = false;

        logger.info("Created SignalTiming for intersectionId: " + intersectionId);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public void setGreenDuration(int greenDuration) {
        this.greenDuration = greenDuration;
    }

    public boolean isDynamic() {
        return isDynamic;
    }

    public void setDynamic(boolean dynamic) {
        isDynamic = dynamic;
    }

    public int getIntersectionId() {
        return intersectionId;
    }
}
