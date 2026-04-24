package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.LoansStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

@Entity
@Table(name  = "LOANS")
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "BORROW_DATE",nullable = false)
    private LocalDateTime borrowDate;

    @Column(name = "EXCEPTED_RETURN_DATE",nullable = false)
    private LocalDateTime expectedReturnDate;

    @Column(name = "ACTUAL_RETURN_DATE")
    private LocalDateTime actualReturnDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "LOAN_STATUS",length = 50,nullable = false)
    private LoansStatus loanStatus;

    @Column(name = "LATE_DAYS")
    private int lateDays;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BOOK")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private User user;
}
