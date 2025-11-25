package behavorial.command;

public class Main {
	public static void main(String[] args) {
		TV tv = new TV(100);
		Command turnOn = new TurnOnCommand(tv, 4);
		Command customCommand  = new ChangeChannelAndAdjustVolumeCommand(tv, 40);
		turnOn.execute();
		customCommand.execute();
		tv.turnOff();
	}
}
