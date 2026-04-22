package fr.eni.bookhub_api.loans;

import fr.eni.bookhub_api.common.ServiceResponse;
import fr.eni.bookhub_api.common.bo.Loans;

import java.util.List;

public interface ILoansBLL
{
    ServiceResponse<Loans> addLoans(LoanRequest loanRequest);
}
