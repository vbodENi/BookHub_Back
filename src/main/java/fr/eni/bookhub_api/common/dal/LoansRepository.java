package fr.eni.bookhub_api.common.dal;

import fr.eni.bookhub_api.common.bo.Loans;
import fr.eni.bookhub_api.common.enumeration.LoansStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoansRepository  extends JpaRepository<Loans, Integer>
{
    boolean existsByUserIdAndBookIdAndLoanStatusNot(Integer userId, Integer bookId, LoansStatus status);

    Integer countByUserIdAndLoanStatusNot(Integer userId, LoansStatus status);

    List<Loans> findByUserId(Integer userId);
}
