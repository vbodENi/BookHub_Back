package fr.eni.bookhub_api.loans;

import fr.eni.bookhub_api.common.ServiceResponse;
import fr.eni.bookhub_api.common.bo.Loans;

import java.util.List;

public interface ILoansService
{
    ServiceResponse<LoanResponse> addLoan(LoanRequest loanRequest);
    ServiceResponse <List<LoanResponse>> findLoansByUser(String token);
    ServiceResponse <List<LoanResponse>> findAllLoansRole(String token);
    ServiceResponse <List<LoanResponse>> updateLoan(String token,String idLoans);
}
