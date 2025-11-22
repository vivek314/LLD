package creational.strategyPattern;

class Logger {
	private static Logger instance = null;
	static int count = 0;
	private Logger() {}
	public static Logger getInstance() {
		if(instance == null) {
			instance = new Logger();
			count++;
		}
		return instance;
	}
}
public class MainClass {
	public static void main(String[] args) {
	Logger logger = Logger.getInstance();
	Logger logger1 = Logger.getInstance();
	System.out.println(Logger.count); //1 since only once the logger instance gets created
	}
}
