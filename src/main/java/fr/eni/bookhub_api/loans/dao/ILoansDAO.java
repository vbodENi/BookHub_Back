package fr.eni.bookhub_api.loans.dao;

import fr.eni.bookhub_api.common.bo.Loans;

import java.util.List;

public interface ILoansDAO
{
    List<Loans> addLoan(Loans loan);
}
