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

    public ServiceResponse<List<Loans>> addLoans(Loans loan)
    {
        List<Loans> loans = loansDAO.addLoan(loan);
        if(loans.size() == 3)
        {
            return new ServiceResponse<>("7001", "Fail add loan");
        }

        return new ServiceResponse<>("2002", "Success", loans);
    }

}
