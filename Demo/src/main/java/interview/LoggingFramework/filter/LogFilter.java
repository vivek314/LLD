package interview.LoggingFramework.filter;

import interview.LoggingFramework.core.LogLevel;
import interview.LoggingFramework.core.LogMessage;

public interface LogFilter {
    boolean shouldLog(LogMessage logMessage);
    void setLevel(LogLevel logLevel);

    LogLevel getLevel();
}
