package behavorial.command;

public class TV {
	private int volume;
	public TV(int volume) {
		this.volume = volume;
	}
	public void turnOn(){
		System.out.println("TV turned on");
	}
	public void turnOff(){
		System.out.println("TV turned off");
	}
	public void adjustVolume(int volume){
		this.volume = volume;
		System.out.println("TV adjusted volume: " + volume);
	}
}
