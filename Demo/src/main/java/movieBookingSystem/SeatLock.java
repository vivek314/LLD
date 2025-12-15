package movieBookingSystem;

import java.util.Date;

public class SeatLock {
	private Seat seat;
	private Show show;
	private int timeoutInSeconds;
	private Date startTime;
	private User lockedBy;

	public SeatLock(Seat seat, Show show, int timeoutInSeconds, User lockedBy) {
		this.seat = seat;
		this.show = show;
		this.timeoutInSeconds = timeoutInSeconds;
		this.lockedBy = lockedBy;
		this.startTime = new Date();
	}

	public Seat getSeat() {
		return seat;
	}
	public Show getShow() {
		return show;
	}
	public int getTimeoutInSeconds() {
		return timeoutInSeconds;
	}
	public Date getStartTime() {
		return startTime;
	}
	public User getLockedBy() {
		return lockedBy;
	}
	public Boolean isLockExpired(){
		Date now = new Date();
		long  diff = now.getTime() - startTime.getTime();
		return diff / 1000 > timeoutInSeconds;
	}
}
