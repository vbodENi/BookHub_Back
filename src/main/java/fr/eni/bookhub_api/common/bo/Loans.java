package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.LoansStatus;
import java.time.LocalDateTime;

public class Loans {

    private Integer id;
    private User user;
    private Book book;
    private LocalDateTime borrowDate;
    private LocalDateTime expectedReturnDate;
    private LocalDateTime actualReturnDate;
    private LoansStatus eLoansStatus;
    private int lateDays;

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
