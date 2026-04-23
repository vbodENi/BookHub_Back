package fr.eni.bookhub_api.loans;

import fr.eni.bookhub_api.common.ServiceResponse;
import fr.eni.bookhub_api.common.bo.Loans;
import fr.eni.bookhub_api.common.bo.User;
import fr.eni.bookhub_api.loans.dao.ILoansDAO;
import fr.eni.bookhub_api.login.LoginResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoansController {

    private final ILoansBLL loansBLL;

    public LoansController(ILoansBLL loansBLL) {
        this.loansBLL = loansBLL;
    }

    @PostMapping("/loans")
    public ServiceResponse<Loans> addLoans(@RequestBody LoanRequest loanRequest) {
        return loansBLL.addLoans(loanRequest);
    }
}
