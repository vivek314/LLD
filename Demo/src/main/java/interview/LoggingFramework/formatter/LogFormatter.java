package interview.LoggingFramework.formatter;

import interview.LoggingFramework.core.LogMessage;

public interface LogFormatter {
    String format(LogMessage message);

    void setPattern(String pattern);

    String getPattern();

    void setDateTimeFormat(String dateTimeFormat);
}
