package movieBookingSystem;

import java.util.*;

public class SeatLockProvider {
	private Map<Show, Map<Seat, SeatLock>> locks;
	private Integer lockTimeout;

	public SeatLockProvider(Integer timeoutInSeconds) {
		locks = new HashMap<Show, Map<Seat, SeatLock>>();
		lockTimeout = timeoutInSeconds;
	}

	public void lockSeats(Show show, List<Seat> seats, User user) throws Exception {
		Map<Seat, SeatLock> seatLocks = locks.computeIfAbsent(show, s -> new HashMap<>());
		synchronized (seatLocks) {
			for(Seat seat : seats){
				if(seatLocks.containsKey(seat)){
					SeatLock seatLock = seatLocks.get(seat);
					if(!seatLock.isLockExpired()){
						throw new Exception("seat: " + seat.getSeatId() + "is locked.");
					}
				}
			}

			for(Seat seat : seats){
				SeatLock seatLock = new SeatLock(seat, show, lockTimeout, user);
				seatLocks.put(seat, seatLock);
			}
		}
	}

	public void unlockSeats(Show show, List<Seat> seats, User user) throws Exception {
		Map<Seat, SeatLock> seatLocks = locks.get(show);
		if(seatLocks == null) return;
		synchronized (seatLocks) {
			for(Seat seat : seats){
				SeatLock seatLock = seatLocks.get(seat);
				if(seatLock != null && seatLock.getLockedBy().equals(user)){
					seatLocks.remove(seat);
				}
			}
		}
	}

	public boolean validateLock(Show show, Seat seat, User user) throws Exception {
		Map<Seat, SeatLock> seatLocks = locks.get(show);
		if(seatLocks == null) return false;
		synchronized (seatLocks) {
			SeatLock seatLock = seatLocks.get(seat);
			return seatLock!=null && seatLock.getLockedBy().equals(user) && !seatLock.isLockExpired();
		}
	}

	public List<Seat> getLockedSeats(Show show){
		Map<Seat, SeatLock> seatLocks = locks.get(show);
		if(seatLocks == null) return Collections.emptyList();
		synchronized (seatLocks) {
			List<Seat> seats = new ArrayList<Seat>();
			for (SeatLock seatLock : seatLocks.values()) {
				if (seatLock.isLockExpired()) {
					seats.add(seatLock.getSeat());
				}
			}
			return seats;
		}
	}
}
