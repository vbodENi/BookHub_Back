package fr.eni.bookhub_api.loans.dao.mock;

import fr.eni.bookhub_api.common.bo.Book;
import fr.eni.bookhub_api.common.bo.Loans;
import fr.eni.bookhub_api.common.bo.User;
import fr.eni.bookhub_api.common.enumeration.LoansStatus;
import fr.eni.bookhub_api.loans.dao.ILoansDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DAOEmpruntsMock implements ILoansDAO
{
    private List<Loans> loans = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();

    public void DAOLoansMock()
    {

        // Users
        users.add(new User("loginMock@email.com", "123456Test"));
        users.add(new User("user1@email.com", "password1"));
        users.add(new User("user2@email.com", "password2"));
        users.add(new User("admin@email.com", "admin123"));

        // Books
        books.add(new Book("Le Petit Prince", "Antoine de Saint-Exupéry"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("L'Étranger", "Albert Camus"));

        // Loans
        loans.add(new Loans(
                1,
                users.get(0),
                books.get(0),
                LocalDateTime.of(2026, 4, 1, 10, 0),
                LocalDateTime.of(2026, 4, 15, 10, 0),
                null,
                LoansStatus.RENDU,
                0
        ));

        loans.add(new Loans(
                2,
                users.get(1),
                books.get(1),
                LocalDateTime.of(2026, 3, 10, 14, 0),
                LocalDateTime.of(2026, 3, 24, 14, 0),
                LocalDateTime.of(2026, 3, 26, 16, 0),
                LoansStatus.RENDU,
                2
        ));

        loans.add(new Loans(
                3,
                users.get(2),
                books.get(2),
                LocalDateTime.of(2026, 3, 20, 9, 30),
                LocalDateTime.of(2026, 4, 3, 9, 30),
                null,
                LoansStatus.RETARD,
                5
        ));
    }

    public List<Loans> addLoan(Loans loan)
    {
        try
        {
            loans.add(loan);
            return loans;
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }

//        String message = "";
//        int loansSize  = loans.size();
//
//        if(loansSize == 3)
//        {
//
//        }
//        else
//        {
//
//        }
    }
}
