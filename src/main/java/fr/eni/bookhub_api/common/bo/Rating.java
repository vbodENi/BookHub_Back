package fr.eni.bookhub_api.common.bo;

import java.time.LocalDateTime;

public class Rating {

    private Integer id;
    private User user;
    private Book book;
    private int value;
    private LocalDateTime ratingDate;

    // Empty constructor
    public Rating() {
    }

    // Full constructor
    public Rating(Integer id, User user, Book book, int value, LocalDateTime ratingDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.value = value;
        this.ratingDate = ratingDate;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDateTime getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(LocalDateTime ratingDate) {
        this.ratingDate = ratingDate;
    }
}

