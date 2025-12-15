package movieBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
	private final int id;
	private final String name;
	private final String location;
	private List<Screen> screenList;

	public Theatre(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.screenList = new ArrayList<Screen>();
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public List<Screen> getScreenList() {
		return screenList;
	}

	public void addScreen(Screen screen) {
		screenList.add(screen);
	}

}
