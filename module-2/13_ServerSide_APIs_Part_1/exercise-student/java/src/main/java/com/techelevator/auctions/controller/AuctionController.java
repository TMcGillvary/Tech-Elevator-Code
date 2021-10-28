package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    /**
     * Return a list of Auctions
     * Adding a parameter to search by title
     */

    @GetMapping(path = "")
    public List<Auction> list(@RequestParam(defaultValue = "") String title_like, @RequestParam(defaultValue = "0.0") Double currentBid_lte) {

        if (!title_like.equals("") && currentBid_lte > 0.0) {
            return dao.searchByTitleAndPrice(title_like, currentBid_lte);
        } else if (currentBid_lte > 0.0) {
            return dao.searchByPrice(currentBid_lte);
        } else if (!title_like.equals("")) {
            return dao.searchByTitle(title_like);
        } else {
            return dao.list();
        }

    }

    /**
     * Return a specific auction based on the auctionID
     */

    @GetMapping(path = "/{auctionID}")
    public Auction get(@PathVariable int auctionID) {
        return dao.get(auctionID);
    }

    /**
     * Add an auction
     */
    @PostMapping(path = "")
    public Auction create(@RequestBody Auction newAuction) {
        return dao.create(newAuction);
    }

}
