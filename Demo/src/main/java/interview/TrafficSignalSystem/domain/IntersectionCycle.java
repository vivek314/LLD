package interview.TrafficSignalSystem.domain;

import interview.LoggingFramework.logger.Logger;
import interview.LoggingFramework.logger.LoggerImpl;

public class IntersectionCycle {

    Logger logger = new LoggerImpl("IntersectionCycle");

    private final int intersectionId;
    private int currentPhase;
    private boolean isPaused;
    private int pausedAtPhase;
    private long phaseStartTime;
    private long pauseStartTime;
    private long totalPauseTime;

    public IntersectionCycle(int intersectionId) {
        this.intersectionId = intersectionId;
        this.currentPhase = 0;
        this.isPaused = false;
        this.pausedAtPhase = 0;
        this.phaseStartTime = System.currentTimeMillis();
        this.pauseStartTime = 0;
        this.totalPauseTime = 0;

        logger.info("IntersectionCycle created for intersection: " + intersectionId);
    }

    public int getIntersectionId() {
        return intersectionId;
    }

    public int getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(int currentPhase) {
        this.currentPhase = currentPhase;
        logger.info("Setting current phase to: " + currentPhase);
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public int getPausedAtPhase() {
        return pausedAtPhase;
    }

    public void setPausedAtPhase(int pausedAtPhase) {
        this.pausedAtPhase = pausedAtPhase;
    }

    public long getPhaseStartTime() {
        return phaseStartTime;
    }

    public void setPhaseStartTime(long phaseStartTime) {
        this.phaseStartTime = phaseStartTime;
    }

    public long getPauseStartTime() {
        return pauseStartTime;
    }

    public void setPauseStartTime(long pauseStartTime) {
        this.pauseStartTime = pauseStartTime;
    }

    public long getTotalPauseTime() {
        return totalPauseTime;
    }

    public void setTotalPauseTime(long totalPauseTime) {
        this.totalPauseTime = totalPauseTime;
    }
}
