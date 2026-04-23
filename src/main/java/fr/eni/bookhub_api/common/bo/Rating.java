package fr.eni.bookhub_api.common.bo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name  = "RATING")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "VALUE",nullable = false)
    private int value;

    @Column(name = "DATE",nullable = false)
    private LocalDateTime ratingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BOOK")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private User user;

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

