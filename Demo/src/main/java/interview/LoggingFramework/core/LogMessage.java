package interview.LoggingFramework.core;

import java.time.Instant;
import java.time.LocalDateTime;

public class LogMessage {
    private Instant timeStamp;
    private LogLevel level;
    private String message;
    private String source;

    private LogMessage(LogBuilder builder) {
        this.timeStamp = builder.timeStamp;
        this.level = builder.level;
        this.message = builder.message;
        this.source = builder.source;
    }

    public Instant getTimestamp() {
        return timeStamp;
    }
    public LogLevel getLevel() {
        return level;
    }
    public String getMessage() {
        return message;
    }
    public String getSource() {
        return source;
    }

    public static class LogBuilder {
        private Instant timeStamp;
        private LogLevel level;
        private String message;
        private String source;

        public LogBuilder(){
            timeStamp = Instant.now();
            level = LogLevel.INFO;
            message = " ";
            source = "";
        }
        public LogBuilder addTimeStamp(Instant timeStamp){
            this.timeStamp = timeStamp;
            return this;
        }

        public LogBuilder addLevel(LogLevel level){
            this.level = level;
            return this;
        }
        public LogBuilder addMessage(String message){
            this.message = message;
            return this;
        }
        public LogBuilder addSource(String source){
            this.source = source;
            return this;
        }

        public LogMessage build(){
            return new LogMessage(this);
        }
    }
}
