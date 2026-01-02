package interview.LoggingFramework.appender;

import interview.LoggingFramework.core.LogLevel;
import interview.LoggingFramework.core.LogMessage;
import interview.LoggingFramework.filter.LevelFilter;
import interview.LoggingFramework.filter.LogFilter;
import interview.LoggingFramework.formatter.LogFormatter;
import interview.LoggingFramework.formatter.SimpleFormatting;

import java.io.PrintStream;

public class ConsoleAppender implements LogAppender {
    private LogFormatter formatter;
    private PrintStream out;

    public ConsoleAppender(LogFormatter logFormatter, PrintStream out) {
        this.formatter = logFormatter;
        this.out = out;
    }

    public ConsoleAppender() {
        this(new SimpleFormatting(),  System.out);
    }


    @Override
    public void append(LogMessage message) {
        String formattedText = formatter.format(message);
        if(message.getLevel() == LogLevel.ERROR || message.getLevel() == LogLevel.FATAL){
            System.err.println(formattedText);
        }
        else{
            System.out.println(formattedText);
        }
    }

    @Override
    public void setFormatter(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public LogFormatter getFormatter() {
        return formatter;
    }
}
