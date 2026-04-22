package fr.eni.bookhub_api.loans;

public class LoanRequest
{
    private String idUser;
    private String idBook;

    public LoanRequest() {
    }

    public LoanRequest(String idUser, String idBook) {
        this.idUser = idUser;
        this.idBook = idBook;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }
}
