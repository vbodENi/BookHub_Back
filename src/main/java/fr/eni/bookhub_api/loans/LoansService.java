package fr.eni.bookhub_api.loans;

import fr.eni.bookhub_api.common.ServiceResponse;
import fr.eni.bookhub_api.common.bo.Loans;
import fr.eni.bookhub_api.loans.dao.ILoansDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoansService implements ILoansBLL
{
    private final ILoansDAO loansDAO;

    public LoansService(ILoansDAO loansDAO) {
        this.loansDAO = loansDAO;
    }

    public ServiceResponse<Loans> addLoans(LoanRequest request)
    {
        try
        {
            Loans loan = loansDAO.addLoan(request);
            return new ServiceResponse<>("2001", "Emprunt effectué avec succès", loan);
        }
        catch (RuntimeException ex)
        {
            switch (ex.getMessage())
            {
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
