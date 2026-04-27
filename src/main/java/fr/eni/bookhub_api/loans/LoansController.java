package fr.eni.bookhub_api.loans;

import fr.eni.bookhub_api.common.ServiceResponse;
import fr.eni.bookhub_api.common.bo.Loans;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoansController {

    private final ILoansService loansBLL;

    public LoansController(ILoansService loansBLL) {
        this.loansBLL = loansBLL;
    }

    @PostMapping("/loans")
    public ServiceResponse<LoanResponse> addLoans(@RequestBody LoanRequest loanRequest) {
        return loansBLL.addLoan(loanRequest);
    }

    @GetMapping("/loans/{idUser}")
    public ServiceResponse<?> findLoansByUser(@PathVariable("idUser") String idUser)
    {
        return loansBLL.findLoansByUser(idUser);
    }

    @GetMapping("/loans")
    public ServiceResponse<?> findAllLoans(@RequestHeader("Authorization") String token)
    {
        return loansBLL.findAllLoansRole(token);
    }

    @PutMapping("/loans/{idLoans}")
    public ServiceResponse<?> returnLoansById(@PathVariable("idLoans") String idLoans,@RequestHeader("Authorization") String token)
    {
        return loansBLL.updateLoan(token,idLoans);
    }
}
