package behavorial.mediator;

public class Main {
	public static void main(String[] args) {
		AuctionMediator mediator = new AuctionHouse();
		Bidder b1 = new Bidder("alice", mediator);
		Bidder b2 = new Bidder("bob", mediator);
		Bidder b3 = new Bidder("charlie", mediator);
		mediator.registerBidder(b1);
		mediator.registerBidder(b2);
		mediator.registerBidder(b3);
		b1.placeBid(100);
		b2.placeBid(200);
		b3.placeBid(300);
	}
}
