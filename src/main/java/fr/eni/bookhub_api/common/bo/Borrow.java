package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.User;
import fr.eni.bookhub_api.common.enumeration.BorowsStatus;
import java.time.LocalDateTime;

public class Borrow {

    private Long id;
    private User user;
    private Book book;
    private LocalDateTime borrowDate;
    private LocalDateTime expectedReturnDate;
    private LocalDateTime actualReturnDate;
    private BorowsStatus eBorowsStatus;
    private int lateDays;

    // Empty constructor
    public Borrow() {
    }

    // Full constructor
    public Borrow(Long id, User user, Book book, LocalDateTime borrowDate,
                  LocalDateTime expectedReturnDate, LocalDateTime actualReturnDate,
                  BorowsStatus eBorowsStatus, int lateDays) {

        this.id = id;
        this.user = user;
        this.book = book;
        this.borrowDate = borrowDate;
        this.expectedReturnDate = expectedReturnDate;
        this.actualReturnDate = actualReturnDate;
        this.eBorowsStatus = eBorowsStatus;
        this.lateDays = lateDays;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public BorowsStatus getStatus() {
        return eBorowsStatus;
    }

    public void setStatus(BorowsStatus status) {
        this.eBorowsStatus = status;
    }

    public int getLateDays() {
        return lateDays;
    }

    public void setLateDays(int lateDays) {
        this.lateDays = lateDays;
    }
}
