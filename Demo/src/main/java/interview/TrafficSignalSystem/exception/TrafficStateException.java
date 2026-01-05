package interview.TrafficSignalSystem.exception;

public class TrafficStateException extends RuntimeException{
    public TrafficStateException(String message){
        super(message);
    }

    public TrafficStateException(String currentState, String attemptedState){
        super("Cannot transition from: " + currentState + " to " + attemptedState);
    }
}
