package fr.eni.bookhub_api.loans.dao;

import fr.eni.bookhub_api.common.bo.Loans;
import fr.eni.bookhub_api.loans.LoanRequest;

import java.util.List;

public interface ILoansDAO
{
    Loans addLoan(LoanRequest loanRequest);
}
