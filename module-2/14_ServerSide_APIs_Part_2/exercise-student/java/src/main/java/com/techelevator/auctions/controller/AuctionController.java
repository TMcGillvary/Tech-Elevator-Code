package com.techelevator.auctions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.exception.AuctionNotFoundException;
import com.techelevator.auctions.model.Auction;

import javax.validation.Valid;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

	@Autowired
    private AuctionDao dao;

    public AuctionController(AuctionDao dao) {
        this.dao = dao;
    }

    @RequestMapping( path = "", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(defaultValue = "") String title_like, @RequestParam(defaultValue = "0") double currentBid_lte) {

        if( !title_like.equals("") ) {
            return dao.searchByTitle(title_like);
        }
        if(currentBid_lte > 0) {
            return dao.searchByPrice(currentBid_lte);
        }

        return dao.list();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) throws AuctionNotFoundException {
        return dao.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "", method = RequestMethod.POST)
    public Auction create(@Valid @RequestBody Auction auction) {
        return dao.create(auction);
    }

    @PutMapping(path = "/{auctionID}")
    public Auction update(@Valid @RequestBody Auction updatedAuction, @PathVariable int auctionID) throws AuctionNotFoundException {
        return dao.update(updatedAuction, auctionID);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{auctionID}")
    public void delete(@PathVariable int auctionID) throws AuctionNotFoundException {
        dao.delete(auctionID);
    }


}
