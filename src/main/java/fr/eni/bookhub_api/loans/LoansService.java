package fr.eni.bookhub_api.loans;

import fr.eni.bookhub_api.common.ServiceResponse;
import fr.eni.bookhub_api.common.bo.Book;
import fr.eni.bookhub_api.common.bo.Loans;
import fr.eni.bookhub_api.common.bo.User;
import fr.eni.bookhub_api.common.dal.BookRepository;
import fr.eni.bookhub_api.common.dal.UserRepository;
import fr.eni.bookhub_api.common.enumeration.LoansStatus;
import fr.eni.bookhub_api.common.dal.LoansRepository;
import fr.eni.bookhub_api.security.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoansService implements ILoansService
{
    private LoansRepository loansRepository;
    private UserRepository userRepository;
    private BookRepository bookRepository;
    private final JwtService jwtService;

    public LoansService(LoansRepository loansRepository, UserRepository userRepository, BookRepository bookRepository, JwtService jwtService) {
        this.loansRepository = loansRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.jwtService = jwtService;
    }

    public boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public ServiceResponse <List<LoanResponse>> updateLoan(String token,String idLoans)
    {
        try
        {
            boolean isNumeric = isNumeric(idLoans);
            if (isNumeric == false) {
                throw new RuntimeException("Invalid user ID");
            }
            Integer idLoansParse = Integer.parseInt(idLoans);

            if (token.isEmpty()) {
                throw new RuntimeException("Invalidate token");
            }
            String tokenClean = token.substring(7); // enlève "Bearer "

            List<LoanResponse> loansResponse = new ArrayList<>();
            String role = jwtService.extractRole(tokenClean);
            Integer idUser = jwtService.extractIdUser(tokenClean);

            Optional<User> optionalUser = userRepository.findById(idUser);

            if (optionalUser.isEmpty()) {
                throw new RuntimeException("User not found");
            }

            User user = optionalUser.get();

            if(role == null|| !(role.equals("LIBRARIAN")))
            {
                throw new RuntimeException("Access denied");
            }

            Optional<Loans> optionalLoans = loansRepository.findById(idLoansParse);
            if(optionalLoans.isEmpty())
            {
                throw new RuntimeException("Not find any loan");
            }
            Loans loan = optionalLoans.get();
            loan.setLoanStatus(LoansStatus.RENDU);
            loansRepository.save(loan);

            return new ServiceResponse<>("2001", "Success");
        }
        catch (Exception ex)
        {
            switch (ex.getMessage()) {
                case "User not found":
                    return new ServiceResponse<>("7002", "User not found");

                case "Access denied":
                    return new ServiceResponse<>("7003", "Access denied");

                case "Not find any loan":
                    return new ServiceResponse<>("7004", "Not find any loan");

                case "Invalid user ID":
                    return new ServiceResponse<>("7005", "Invalid user ID");

                case "Invalidate token":
                    return new ServiceResponse<>("7006", "Invalidate token");

                default:
                    return new ServiceResponse<>("7000", "Fatal error");
            }
        }
    }

    public ServiceResponse <List<LoanResponse>> findAllLoansRole(String token)
    {
        try
        {
            if (token.isEmpty()) {
                throw new RuntimeException("Invalidate token");
            }
            String tokenClean = token.substring(7); // enlève "Bearer "

            List<LoanResponse> loansResponse = new ArrayList<>();
            String role = jwtService.extractRole(tokenClean);
            String email = jwtService.extractEmail(tokenClean);

            Optional<User> optionalUser = userRepository.findByEmail(email);

            if (optionalUser.isEmpty()) {
                throw new RuntimeException("User not found");
            }

            User user = optionalUser.get();

            if(role == null || !(role.equals("LIBRARIAN")))
            {
                throw new RuntimeException("Access denied");
            }

            List<Loans> loans = loansRepository.findAll();
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
                        loan.getLoanStatus(),
                        loan.getLateDays()
                );
                loansResponse.add(response);
            });

            return new ServiceResponse<>("2001", "Success",loansResponse);
        }
        catch (Exception ex)
        {
            switch (ex.getMessage()) {
                case "User not found":
                    return new ServiceResponse<>("7002", "User not found");

                case "Access denied":
                    return new ServiceResponse<>("7003", "Access denied");

                case "Not find any loan":
                    return new ServiceResponse<>("7003", "Not find any loan");

                default:
                    return new ServiceResponse<>("7000", "Fatal error");
            }
        }
    }

    public ServiceResponse <List<LoanResponse>> findLoansByUser(String token)
    {
        try
        {
            List<LoanResponse> loansResponse = new ArrayList<>();
            if (token.isEmpty()) {
                throw new RuntimeException("Invalidate token");
            }

            String tokenClean = token.substring(7); // enlève "Bearer "

            // Vérification expiration
            if (jwtService.isTokenExpired(tokenClean)) {
                throw new RuntimeException("Token expired");
            }
            Integer idUser = jwtService.extractIdUser(tokenClean);

            if (idUser == null){
                throw new RuntimeException("Fail to extract id");
            }
            List<Loans> loans = loansRepository.findByUserId(idUser);
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
                        loan.getLoanStatus(),
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
                case "Fail to extract id":
                    return new ServiceResponse<>("7002", "Fail to extract id");

                case "Invalid user ID":
                    return new ServiceResponse<>("7003", "Invalid user ID");

                case "Not find any loan":
                    return new ServiceResponse<>("7004", "Not find any loan");

                case "Token expired":
                    return new ServiceResponse<>("7005", "Token expired");

                case "Any loans finds":
                    return new ServiceResponse<>("7006", "Any loans finds");

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
            newLoan.setLoanStatus(LoansStatus.ENCOURS);
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
                    savedLoan.getLoanStatus(),
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
