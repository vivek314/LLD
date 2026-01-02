package interview.LoggingFramework.filter;

import interview.LoggingFramework.core.LogLevel;
import interview.LoggingFramework.core.LogMessage;

public class LevelFilter implements LogFilter {

    private LogLevel level;

    public LevelFilter(LogLevel level) {
        this.level = level;
    }

    public LevelFilter() {
        this.level = LogLevel.DEBUG;
    }

    @Override
    public boolean shouldLog(LogMessage logMessage) {
        return logMessage.getLevel().isGreaterOrEqual(level);
    }

    @Override
    public void setLevel(LogLevel logLevel) {
        this.level = logLevel;
    }

    @Override
    public LogLevel getLevel() {
        return level;
    }
}
