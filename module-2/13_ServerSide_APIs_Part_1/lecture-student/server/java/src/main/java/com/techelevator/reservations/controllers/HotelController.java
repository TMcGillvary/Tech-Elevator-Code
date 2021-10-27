package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> listHotels() {
        return hotelDao.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel getHotel(@PathVariable int id) {
        return hotelDao.get(id);
    }

    /**
     * Return all reservations
     */
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservations() {
        return reservationDao.findAll();
    }

    /**
     * Return reservation information
     *
     * @param reservationId the id of the reservation
     * @return all info for a given reservation
     */
    @RequestMapping(path = "/reservations/{reservationId}", method = RequestMethod.GET)
    //@GetMapping(path = "/reservations/{reservationId}")
    public Reservation getReservation(@PathVariable int reservationId) {
        return reservationDao.get(reservationId);
    }

    /**
     * Return all reservations for a given hotel
     *
     * @param hotelId the id for the hotel
     * @return all info on reservation for a given hotel
     */
    @GetMapping(path = "/hotels/{hotelId}/reservations")
    public List<Reservation> getHotelReservation(@PathVariable int hotelId) {
        return reservationDao.findByHotel(hotelId);
    }

    /**
     * Add a new reservation
     */
    @PostMapping(path = "/reservations")
    public Reservation addReservation(@RequestBody Reservation newReservation) {
        return reservationDao.create(newReservation, newReservation.getHotelID());
    }

    /**
     * Filter hotels by state and optionally city
     */
    @GetMapping(path = "/hotels/filter")
    public List<Hotel> filterHotels(@RequestParam(required = false) String city, @RequestParam String state) {
        System.out.println("In filterHotels, city = " + city + " and state = " + state);
        return null;
    }

}
