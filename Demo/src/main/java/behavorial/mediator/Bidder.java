package behavorial.mediator;

public class Bidder {
	private String name;
	private AuctionMediator mediator;

	public Bidder(String name, AuctionMediator mediator) {
		this.name = name;
		this.mediator = mediator;
	}

	public void placeBid(int amount){
		mediator.placeBid(this, amount);
	}

	public void receiveBid(Bidder bidder, int amount){
		System.out.println("AuctionHouse - receiveBid - " + name + " received a bid of " + amount + " from " + bidder.getName());
	}

	public String getName(){
		return name;
	}
}
