package interview.TrafficSignalSystem.domain;

import interview.LoggingFramework.logger.Logger;
import interview.LoggingFramework.logger.LoggerImpl;

public class VehicleCounter {
    private Direction direction;
    private int count;
    private long lastUpdate;

    Logger logger = new LoggerImpl("VehicleCounter");

    public VehicleCounter(Direction direction) {
        this.direction = direction;
        this.count = 0;
        this.lastUpdate = System.currentTimeMillis();

        logger.info("Created VehicleCounter");
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
        setLastUpdate(System.currentTimeMillis());
    }
    public long getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void incrementCount(){
        count++;
        setLastUpdate(System.currentTimeMillis());
    }

    public void resetCount() {
        count = 0;
        setLastUpdate(System.currentTimeMillis());
    }
}
