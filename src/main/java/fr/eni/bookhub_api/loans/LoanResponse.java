package fr.eni.bookhub_api.loans;

import fr.eni.bookhub_api.common.enumeration.LoansStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class LoanResponse
{
    private Integer id;

    private String userName;

    private String bookName;

    private LocalDateTime borrowDate;

    private LocalDateTime expectedReturnDate;

    private LocalDateTime actualReturnDate;

    private LoansStatus loanStatus;

    private int lateDays;

    public LoanResponse() {
    }

    public LoanResponse(Integer id, String userName, String bookName, LocalDateTime borrowDate, LocalDateTime expectedReturnDate, LocalDateTime actualReturnDate, LoansStatus loanStatus, int lateDays) {
        this.id = id;
        this.userName = userName;
        this.bookName = bookName;
        this.borrowDate = borrowDate;
        this.expectedReturnDate = expectedReturnDate;
        this.actualReturnDate = actualReturnDate;
        this.loanStatus = loanStatus;
        this.lateDays = lateDays;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public LoansStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoansStatus loanStatus) {
        this.loanStatus = loanStatus;
    }

    public int getLateDays() {
        return lateDays;
    }

    public void setLateDays(int lateDays) {
        this.lateDays = lateDays;
    }
}
