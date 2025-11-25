package behavorial.mediator;

import java.util.ArrayList;
import java.util.List;

public class AuctionHouse implements AuctionMediator {
	private List<Bidder> bidders = new ArrayList<>();

	@Override
	public void registerBidder(Bidder bidder) {
		bidders.add(bidder);
	}

	@Override
	public void placeBid(Bidder bidder, int amount) {
		System.out.println("AuctionHouse - placeBid - " + bidder.getName() + " placed a bid of " + amount);
		for(Bidder b : bidders){
			if(b!=bidder) {
				b.receiveBid(bidder, amount);
			}
		}
	}
}
