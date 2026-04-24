package fr.eni.bookhub_api.loans;

import fr.eni.bookhub_api.common.ServiceResponse;
import fr.eni.bookhub_api.common.bo.Book;
import fr.eni.bookhub_api.common.bo.Loans;
import fr.eni.bookhub_api.common.bo.User;
import fr.eni.bookhub_api.common.dal.BookRepository;
import fr.eni.bookhub_api.common.dal.UserRepository;
import fr.eni.bookhub_api.common.enumeration.LoansStatus;
import fr.eni.bookhub_api.common.dal.LoansRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoansService implements ILoansService
{
    private LoansRepository loansRepository;
    private UserRepository userRepository;
    private BookRepository bookRepository;

    public LoansService(LoansRepository loansRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.loansRepository = loansRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public ServiceResponse <List<LoanResponse>> findLoansByUser(String idUser)
    {
        try
        {
            List<LoanResponse> loansResponse = new ArrayList<>();
            Integer intIdUser = Integer.valueOf(idUser);
            if (intIdUser == null){
                throw new RuntimeException("Fail to cast id");
            }
            List<Loans> loans = loansRepository.findByUserId(intIdUser);
            if (loans.isEmpty()){
                throw new RuntimeException("Not find any loan");
            }
            loans.forEach(loan -> {
                LoanResponse response = new LoanResponse(
                        loan.getId(),
                        loan.getUser().getFirstName() + " " + loan.getUser().getLastName(),
                        loan.getBook().getTitle(),
                        loan.getBorrowDate(),
                        loan.getExpectedReturnDate(),
                        loan.getActualReturnDate(),
                        loan.getStatus(),
                        loan.getLateDays()
                );
                loansResponse.add(response);
            });
            if (loansResponse.isEmpty()){
                throw new RuntimeException("Any loans finds");
            }

            return new ServiceResponse<>("2001", "Success", loansResponse);
        }
        catch(Exception ex)
        {
            switch (ex.getMessage()) {
                case "Fail to cast id":
                    return new ServiceResponse<>("7002", "Fail to cast id");

                case "Not find any loan":
                    return new ServiceResponse<>("7003", "Not find any loan");

                case "Any loans finds":
                    return new ServiceResponse<>("7004", "Any loans finds");

                default:
                    return new ServiceResponse<>("7000", "Fatal error");
            }
        }
    }

    public ServiceResponse<LoanResponse> addLoan(LoanRequest request)
    {
        try
        {
            Integer idBook = Integer.valueOf(request.getIdBook());
            Integer idUser = Integer.valueOf(request.getIdUser());

            // Récupération user
            User user = userRepository.findById(idUser)
                    .orElseThrow(() -> new RuntimeException("USER_NOT_FOUND"));

            // Récupération book
            Book book = bookRepository.findById(idBook)
                    .orElseThrow(() -> new RuntimeException("BOOK_NOT_FOUND"));

            // Déjà emprunté ?
            boolean alreadyBorrowed = loansRepository
                    .existsByUserIdAndBookIdAndLoanStatusNot(idUser, idBook, LoansStatus.RENDU);

            if (alreadyBorrowed) {
                throw new RuntimeException("BOOK_ALREADY_BORROWED");
            }

            // Max 3 emprunts
            long activeLoans = loansRepository
                    .countByUserIdAndLoanStatusNot(idUser, LoansStatus.RENDU);

            if (activeLoans >= 3) {
                throw new RuntimeException("MAX_LOANS_REACHED");
            }

            // Création du loan
            Loans newLoan = new Loans();
            newLoan.setUser(user);
            newLoan.setBook(book);
            newLoan.setBorrowDate(LocalDateTime.now());
            newLoan.setExpectedReturnDate(LocalDateTime.now().plusDays(14));
            newLoan.setActualReturnDate(null);
            newLoan.setStatus(LoansStatus.ENCOURS);
            newLoan.setLateDays(0);

            // Save JPA
            Loans savedLoan = loansRepository.save(newLoan);

            LoanResponse loanResponse = new LoanResponse(
                    savedLoan.getId(),
                    savedLoan.getUser().getFirstName() + " " +savedLoan.getUser().getLastName(),
                    savedLoan.getBook().getTitle(),
                    savedLoan.getBorrowDate(),
                    savedLoan.getExpectedReturnDate(),
                    savedLoan.getActualReturnDate(),
                    savedLoan.getStatus(),
                    savedLoan.getLateDays()

            );

            return new ServiceResponse<>("2001", "Success loan", loanResponse);

        } catch (RuntimeException ex) {

            switch (ex.getMessage()) {
                case "BOOK_ALREADY_BORROWED":
                    return new ServiceResponse<>("7002", "Book already borrowed and not returned");

                case "MAX_LOANS_REACHED":
                    return new ServiceResponse<>("7001", "Maximum 3 loans reached");

                case "USER_NOT_FOUND":
                    return new ServiceResponse<>("7003", "User unknown");

                case "BOOK_NOT_FOUND":
                    return new ServiceResponse<>("7004", "Book unknown");

                default:
                    return new ServiceResponse<>("7000", "Fatal error");
            }
        }
    }
}
