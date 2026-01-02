package interview.LoggingFramework.formatter;

import interview.LoggingFramework.core.LogMessage;

import java.time.format.DateTimeFormatter;

public class SimpleFormatting implements LogFormatter{
    private String pattern;
    private String dateFormat;
    private DateTimeFormatter dateTimeFormatter;

    public SimpleFormatting(String pattern) {
        this(pattern, "yyyy-MM-dd HH:mm:ss");
    }

    public SimpleFormatting() {
        this("[%LEVEL] %TIMESTAMP - %MESSAGE", "yyyy-MM-dd HH:mm:ss");
    }

    public SimpleFormatting(String pattern, String dateTimeFormat) {
        this.pattern = pattern;
        this.dateFormat = dateTimeFormat;
    }

    @Override
    public String format(LogMessage message) {
        if (pattern == null || pattern.isEmpty()) {
            return String.format("[%s] %s - %s",
                    message.getLevel(),
                    message.getTimestamp().toString(),
                    message.getMessage());
        }

        String formatted = pattern
                .replace("%LEVEL", message.getLevel().toString())
                .replace("%TIMESTAMP", message.getTimestamp().toString())
                .replace("%MESSAGE", message.getMessage())
                .replace("%SOURCE", message.getSource() != null ? message.getSource() : "");

        return formatted;
    }

    @Override
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return pattern;
    }

    @Override
    public void setDateTimeFormat(String dateTimeFormat) {
        this.dateFormat = dateTimeFormat;
    }
}
