package fr.eni.bookhub_api.loans;

public class LoanRequest
{
    private String token;
    private String idBook;

    public LoanRequest() {
    }

    public LoanRequest(String idBook) {
        this.idBook = idBook;
    }

    public LoanRequest(String token, String idBook) {
        this.token = token;
        this.idBook = idBook;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }
}
