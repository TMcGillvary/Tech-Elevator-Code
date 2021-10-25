package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {
        String url = API_BASE_URL + "hotels";
        ResponseEntity<Hotel[]> responseEntity = restTemplate.getForEntity(url, Hotel[].class);
        System.out.println(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    public Review[] listReviews() {
        String url = API_BASE_URL + "reviews";
        Review[] reviews = restTemplate.getForObject(url, Review[].class);
        return reviews;
    }

    public Hotel getHotelById(int id) {
        String url = API_BASE_URL + "hotels/" + id;
        Hotel hotel = restTemplate.getForObject(url, Hotel.class);
        return hotel;
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        String url = API_BASE_URL + "hotels/" + hotelID + "/reviews";
        return restTemplate.getForObject(url, Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        String url = API_BASE_URL + "hotels?stars=" + stars;
        return restTemplate.getForObject(url, Hotel[].class);
    }

    public City getWithCustomQuery(){
        String url = "https://api.teleport.org/api/cities/geonameid:4517586/";
        return restTemplate.getForObject(url, City.class);
    }

}
