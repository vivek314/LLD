package concertBookingSystem;

import java.util.*;
import java.util.stream.Collectors;

public class ConcertTBSManager {
	private Map<String, List<Seat>> seatManager;
	private Map<String, User> userManager;
	private Map<String, Stack<User>> waitingListManager;
	Map<String, Concert> concertMap;

	public ConcertTBSManager() {
		seatManager = new HashMap<String, List<Seat>>();
		userManager = new HashMap<>();
		waitingListManager = new HashMap<>();
		concertMap = new HashMap<>();
	}

	public void addConcert(Concert concert) {
		concertMap.put(concert.getId(), concert);
		int capacity = concert.getCapacity();
		List<Seat> seats = new ArrayList<>();
		for(int i = 0; i < capacity; i++) {
			Seat seat = new Seat(i);
			seats.add(seat);
		}
		seatManager.put(concert.getId(), seats);
	}

	public void removeConcert(Concert concert) {
		if(concertMap.containsKey(concert.getId())) {
			concertMap.remove(concert.getId());
			seatManager.remove(concert.getId());
		}
	}

	public List<Concert> getConcertList() {
		return new ArrayList<>(concertMap.values());
	}

	public void bookConcert(String concertId, String userId){
		List<Seat> avaialbleSeats = new ArrayList<>();
		for(Seat seat : seatManager.get(concertId)){
			if(!seat.getOccupied()){
				avaialbleSeats.add(seat);
			}
		}
		if(!avaialbleSeats.isEmpty()){
			for(Seat seat : avaialbleSeats){
				System.out.print(seat.getId() + " ");
			}
			System.out.println("Select seat you want to book!");
			Scanner sc = new Scanner(System.in);
			int selectedSeat =  sc.nextInt();
			//Booking seat

		} else{
			System.out.println("Concert " + concertId + " not booked because seats are filled," +
					"Adding to the waiting list!");
		}

	}

}
