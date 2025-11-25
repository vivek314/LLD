package behavorial.command;

public class TurnOnCommand implements Command {
	private TV tv;
	private int volume;
	public TurnOnCommand(TV tv, int volume) {
		this.tv = tv;
		this.volume = volume;
	}

	@Override
	public void execute() {
		tv.turnOn();
	}
}
