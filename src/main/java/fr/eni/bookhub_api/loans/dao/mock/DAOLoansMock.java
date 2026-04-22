package fr.eni.bookhub_api.loans.dao.mock;

import fr.eni.bookhub_api.common.bo.Book;
import fr.eni.bookhub_api.common.bo.Loans;
import fr.eni.bookhub_api.common.bo.User;
import fr.eni.bookhub_api.common.enumeration.LoansStatus;
import fr.eni.bookhub_api.loans.LoanRequest;
import fr.eni.bookhub_api.loans.dao.ILoansDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DAOLoansMock implements ILoansDAO
{
    private List<Loans> loans = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();

    public DAOLoansMock()
    {

        // Users
        users.add(new User(1,"loginMock@email.com", "123456Test"));
        users.add(new User(2,"user1@email.com", "password1"));
        users.add(new User(3,"user2@email.com", "password2"));
        users.add(new User(4,"admin@email.com", "admin123"));

        // Books
        books.add(new Book(1,"Le Petit Prince", "Antoine de Saint-Exupéry"));
        books.add(new Book(2,"1984", "George Orwell"));
        books.add(new Book(3,"L'Étranger", "Albert Camus"));

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

    public Loans addLoan(LoanRequest loanRequest)
    {
        Integer idBook = Integer.valueOf(loanRequest.getIdBook());
        Integer idUser = Integer.valueOf(loanRequest.getIdUser());

        User user = users.stream()
                .filter(u -> u.getId().equals(idUser))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("USER_NOT_FOUND"));

        Book book = books.stream()
                .filter(b -> b.getId().equals(idBook))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("BOOK_NOT_FOUND"));

        // 🔒 1. Vérifier si déjà emprunté et NON rendu
        boolean alreadyBorrowed = loans.stream()
                .anyMatch(loan ->
                        loan.getUser().getId().equals(idUser) &&
                                loan.getBook().getId().equals(idBook) &&
                                loan.getStatus() != LoansStatus.RENDU
                );

        if (alreadyBorrowed)
        {
            throw new RuntimeException("BOOK_ALREADY_BORROWED");
        }

        // 🔒 2. Vérifier max 3 emprunts actifs
        long activeLoans = loans.stream()
                .filter(loan ->
                        loan.getUser().getId().equals(idUser) &&
                                loan.getStatus() != LoansStatus.RENDU
                )
                .count();

        if (activeLoans >= 3)
        {
            throw new RuntimeException("MAX_LOANS_REACHED");
        }

        // ✅ 3. Création du loan
        Loans newLoan = new Loans(
                loans.size() + 1,
                user,
                book,
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(14),
                null,
                LoansStatus.ENCOURS,
                0
        );

        loans.add(newLoan);

        return newLoan;
    }
}
