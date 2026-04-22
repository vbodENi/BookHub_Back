package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.ReservationStatus;

import java.awt.print.Book;
import java.time.LocalDateTime;

public class Reservation {

    private Integer id;
    private User user;
    private Book book;
    private LocalDateTime reservationDate;
    private ReservationStatus eReservationstatus;

    // Empty constructor
    public Reservation() {
    }

    // Full constructor
    public Reservation(int id, User user, Book book,
                       LocalDateTime reservationDate, ReservationStatus eReservationstatus) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.reservationDate = reservationDate;
        this.eReservationstatus = eReservationstatus;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public ReservationStatus getStatus() {
        return eReservationstatus;
    }

    public void setStatus(ReservationStatus eReservationstatus) {
        this.eReservationstatus = eReservationstatus;
    }
}

