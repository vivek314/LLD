package concertBookingSystem;

public class Seat {
	private final int id;
	private Boolean isOccupied;
	private  String userId;
	private final int cost;
	public Seat(int id) {
		this.id = id;
		this.isOccupied = false;
		this.cost = 100;
	}

	public Boolean getOccupied() {
		return isOccupied;
	}

	public void setOccupied(Boolean occupied) {
		isOccupied = occupied;
	}

	public int getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCost() {
		return cost;
	}
}
