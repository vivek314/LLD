package interview.LoggingFramework.appender;

import interview.LoggingFramework.core.LogMessage;
import interview.LoggingFramework.formatter.LogFormatter;
import interview.LoggingFramework.formatter.SimpleFormatting;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileAppender implements LogAppender{

    private String filePath;
    private LogFormatter logFormatter;
    private PrintWriter writer;

    public FileAppender(String filePath){
        this.filePath = filePath;
        logFormatter = new SimpleFormatting();
        initializeWriter();
    }

    private void initializeWriter() {
        try {
            this.writer = new PrintWriter(new FileWriter(filePath, true), true);
        } catch (IOException e) {
            System.err.println("Failed to initialize FileAppender for " + filePath + ": " + e.getMessage());
        }
    }

    @Override
    public void append(LogMessage message) {
        String formattedText =  logFormatter.format(message);
        writer.println(formattedText);
        writer.flush();
    }

    @Override
    public void setFormatter(LogFormatter formatter) {
        this.logFormatter = formatter;
    }

    @Override
    public LogFormatter getFormatter() {
        return logFormatter;
    }

    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
