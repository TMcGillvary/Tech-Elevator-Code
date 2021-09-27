package com.techelevator;

public class ReserveAuction extends Auction {

    // instance variables
    private int reservePrice;

    public ReserveAuction(String itemOnSale, int reservePrice) {
        super(itemOnSale); // passing variable up the chain
        this.reservePrice = reservePrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        if (offeredBid.getBidAmount() >= reservePrice) {
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }

    public int getReservePrice() {
        return reservePrice;
    }
}
