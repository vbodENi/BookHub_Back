package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.ReservationStatus;
import jakarta.persistence.*;

import java.awt.print.Book;
import java.time.LocalDateTime;

@Entity
@Table(name  = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DATE",nullable = false)
    private LocalDateTime reservationDate;

    @Column(name = "STATUS",length = 255, nullable = false)
    private ReservationStatus eReservationstatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BOOK")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private User user;

    // Empty constructor
    public Reservation() {
    }

    // Full constructor
    public Reservation(Integer id, User user, Book book,
                       LocalDateTime reservationDate, ReservationStatus eReservationstatus) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.reservationDate = reservationDate;
        this.eReservationstatus = eReservationstatus;
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

