package interview.LoggingFramework;

import interview.LoggingFramework.appender.ConsoleAppender;
import interview.LoggingFramework.appender.FileAppender;
import interview.LoggingFramework.appender.LogAppender;
import interview.LoggingFramework.core.LogLevel;
import interview.LoggingFramework.formatter.LogFormatter;
import interview.LoggingFramework.formatter.SimpleFormatting;
import interview.LoggingFramework.logger.Logger;
import interview.LoggingFramework.logger.LoggerImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        demoThreadSafety();
    }

    private static void demoBasicLogging() {
        System.out.println("1. Basic Logging Demo:");
        System.out.println("----------------------");

        Logger logger = new LoggerImpl("BasicLogger");
        logger.setLevel(LogLevel.INFO);
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");

        System.out.println();
    }

    private static void demoCustomFormatters() {
        System.out.println("3. Custom Formatters Demo:");
        System.out.println("--------------------------");

        Logger logger = new LoggerImpl("FormatterLogger");

        // Create custom formatter
        LogFormatter customFormatter = new SimpleFormatting("[%LEVEL] hi %TIMESTAMP - %MESSAGE");
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setFormatter(customFormatter);

        // Replace default console appender
        logger.addAppender(consoleAppender);

        logger.info("This message uses custom formatting");
        logger.error("This error also uses custom formatting");

        System.out.println();
    }

    private static void demoMultipleAppenders() {
        System.out.println("2. Multiple Appenders Demo:");
        System.out.println("---------------------------");

        Logger logger = new LoggerImpl("MultiAppenderLogger");

        // Add file appender
        FileAppender fileAppender = new FileAppender("demo.log");
        logger.addAppender(fileAppender);

        logger.info("This message goes to both console and file");
        logger.error("This error also goes to both destinations");

        System.out.println("Check 'demo.log' file for the logged messages");
        System.out.println();
    }

    private static void demoThreadSafety() {
        System.out.println("5. Thread Safety Demo:");
        System.out.println("----------------------");

        Logger logger = new LoggerImpl("ThreadSafeLogger");
        LogAppender fileAppender = new FileAppender("demo.log");
        logger.addAppender(fileAppender);
        logger.info("This below message goes to both console and file");
        // Create multiple threads logging simultaneously

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                for(int j=0;j<3;j++){
                    logger.info("Thread " + Thread.currentThread().getName() + " is running message: " + j);
                    try{
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        executorService.shutdown();

//        Thread[] threads = new Thread[5];
//        for (int i = 0; i < 5; i++) {
//            final int threadId = i;
//            threads[i] = new Thread(() -> {
//                for (int j = 0; j < 3; j++) {
//                    logger.info("Thread " + threadId + " - Message " + j);
//                    try {
//                        Thread.sleep(10); // Small delay to increase concurrency
//                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt();
//                    }
//                }
//            });
//        }
//
//        // Start all threads
//        for (Thread thread : threads) {
//            thread.start();
//        }
//
//        // Wait for all threads to complete
//        for (Thread thread : threads) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }

        System.out.println("All threads completed - check for any mixed-up messages above");
        System.out.println();
    }
}
