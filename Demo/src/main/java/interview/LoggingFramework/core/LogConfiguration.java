package interview.LoggingFramework.core;

public class LogConfiguration {
    private LogLevel level;

    public LogConfiguration(){
        this.level = LogLevel.INFO;
    }

    public LogConfiguration(LogLevel level){
        this.level = level;
    }

    public LogLevel getLevel(){
        return this.level;
    }
    public void setLevel(LogLevel level){
        this.level = level;
    }
}
