package interview.LoggingFramework.appender;

import interview.LoggingFramework.core.LogMessage;
import interview.LoggingFramework.formatter.LogFormatter;

import java.util.logging.SimpleFormatter;

public interface LogAppender {
    void append(LogMessage message);
    void setFormatter(LogFormatter formatter);
    LogFormatter getFormatter();

}
