package com.techelevator;

public class Book {

    // variables
    private String title;
    private String author;
    private double price;

    // constructors

    // default
    public Book() {
        // default constructor info is auto filled in by Java
    }

    // book constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }


    // getters & setters

    // getter
    public String getTitle() {
        return this.title;
    }

    // setter
    public void setTitle(String title) {
        this.title = title;
    }

    // getter
    public String getAuthor() {
        return this.author;
    }

    // setter
    public void setAuthor(String author) {
        this.author = author;
    }

    // getter
    public double getPrice() {
        return this.price;
    }

    // setter
    public void setPrice(double price) {
        this.price = price;
    }

    // Methods & Functions
    public String bookInfo() {
        return "Title: " + title + ", Author: " + author +
                ", Price: $" + price;
    }
}
