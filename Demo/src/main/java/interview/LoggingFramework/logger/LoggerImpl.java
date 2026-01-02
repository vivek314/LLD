package interview.LoggingFramework.logger;

import interview.LoggingFramework.appender.ConsoleAppender;
import interview.LoggingFramework.appender.LogAppender;
import interview.LoggingFramework.core.LogLevel;
import interview.LoggingFramework.core.LogMessage;
import interview.LoggingFramework.filter.LogFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoggerImpl implements Logger{
    private String name;
    private LogLevel level;
    private List<LogAppender> appenders;
    private List<LogFilter> filters;

    public LoggerImpl(){
        this("Default logger");
    }


    public LoggerImpl(String name){
        this(name, true);
    }

    public LoggerImpl(String name, boolean addDefaultAppender){
        this.name = name;
        this.level = LogLevel.DEBUG;
        this.appenders = Collections.synchronizedList(new ArrayList<>());
        this.filters = Collections.synchronizedList(new ArrayList<>());
        if(addDefaultAppender){
            addAppender(new ConsoleAppender());
        }
    }
    @Override
    public synchronized void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    @Override
    public synchronized void info(String message) {
        log(LogLevel.INFO, message);
    }

    @Override
    public synchronized void warn(String message) {
        log(LogLevel.WARNING, message);
    }

    @Override
    public synchronized void error(String message) {
        log(LogLevel.ERROR, message);
    }

    @Override
    public synchronized void fatal(String message) {
        log(LogLevel.FATAL, message);
    }

    @Override
    public synchronized void log(LogLevel level, String message) {
        if(!level.isGreaterOrEqual(this.level)){ return; }
        LogMessage.LogBuilder builder = new LogMessage.LogBuilder();
        LogMessage logMessage = builder
                .addLevel(level)
                .addMessage(message)
                .addSource(getCallingClass())
                .build();

        for(LogFilter filter : filters) {
            if(!filter.shouldLog(logMessage)){
                return;
            }
        }

        for(LogAppender appender : appenders) {
            appender.append(logMessage);
        }
    }

    @Override
    public void setLevel(LogLevel level) {
        this.level = level;
    }

    @Override
    public void addAppender(LogAppender logAppender) {
        appenders.add(logAppender);
    }

    @Override
    public void addFilter(LogFilter logFilter) {
        filters.add(logFilter);
    }

    @Override
    public void removeFilter(LogFilter logFilter) {
        filters.remove(logFilter);
    }

    @Override
    public List<LogAppender> getAllAppenders() {
        return appenders;
    }

    @Override
    public List<LogFilter> getAllFilters() {
        return filters;
    }

    public String getCallingClass(){
        try{
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            if(stackTraceElements.length > 3){
                String className = stackTraceElements[3].getClassName();
                String methodName = stackTraceElements[3].getMethodName();
                return className+"."+methodName;
            }
        } catch(Exception ignored){

        }
        return "Unknown";
    }
}
