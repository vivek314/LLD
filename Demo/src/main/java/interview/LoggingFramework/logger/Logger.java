package interview.LoggingFramework.logger;

import interview.LoggingFramework.appender.LogAppender;
import interview.LoggingFramework.core.LogLevel;
import interview.LoggingFramework.filter.LogFilter;

import java.util.List;

public interface Logger {
    void debug(String message);
    void info(String message);
    void warn(String message);
    void error(String message);
    void fatal(String message);

    void log(LogLevel level, String message);

    void setLevel(LogLevel level);

    void addAppender(LogAppender logAppender);

    void addFilter(LogFilter logFilter);
    void removeFilter(LogFilter logFilter);

    List<LogAppender> getAllAppenders();
    List<LogFilter> getAllFilters();
}
