package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.ReservationStatus;
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
@Table(
        name = "RESERVATION"
)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DATE",nullable = false)
    private LocalDateTime reservationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS",length = 255, nullable = false)
    private ReservationStatus eReservationstatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BOOK")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private User user;
}

