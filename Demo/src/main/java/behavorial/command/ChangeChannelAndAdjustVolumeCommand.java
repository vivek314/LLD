package behavorial.command;

public class ChangeChannelAndAdjustVolumeCommand implements Command {
	private TV tv;
	private int volume;

	public ChangeChannelAndAdjustVolumeCommand(TV tv, int volume){
		this.tv = tv;
		this.volume = volume;
	}

	@Override
	public void execute() {
		tv.turnOn();
		tv.adjustVolume(volume);
	}
}
