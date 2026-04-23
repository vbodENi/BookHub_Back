package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.LoansStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name  = "LOANS")
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "BORROW_DATE",nullable = false)
    private LocalDateTime borrowDate;

    @Column(name = "EXCEPTED_RETURN_DATE",nullable = false)
    private LocalDateTime expectedReturnDate;

    @Column(name = "ACTUAL_RETURN_DATE")
    private LocalDateTime actualReturnDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "LOAN_STATUS",length = 50,nullable = false)
    private LoansStatus eLoansStatus;

    @Column(name = "LATE_DAYS")
    private int lateDays;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BOOK")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private User user;

    // Empty constructor
    public Loans() {
    }

    // Full constructor
    public Loans(Integer id, User user, Book book, LocalDateTime borrowDate,
                 LocalDateTime expectedReturnDate, LocalDateTime actualReturnDate,
                 LoansStatus eLoansStatus, int lateDays) {

        this.id = id;
        this.user = user;
        this.book = book;
        this.borrowDate = borrowDate;
        this.expectedReturnDate = expectedReturnDate;
        this.actualReturnDate = actualReturnDate;
        this.eLoansStatus = eLoansStatus;
        this.lateDays = lateDays;
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

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDateTime expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public LocalDateTime getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDateTime actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public LoansStatus getStatus() {
        return eLoansStatus;
    }

    public void setStatus(LoansStatus status) {
        this.eLoansStatus = status;
    }

    public int getLateDays() {
        return lateDays;
    }

    public void setLateDays(int lateDays) {
        this.lateDays = lateDays;
    }
}
