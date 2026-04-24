package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.bo.compositeKey.ReservationId;
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
@Table(name  = "RESERVATION")
@IdClass(ReservationId.class)
public class Reservation {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BOOK")
    private Book book;

    @Column(name = "DATE", nullable = false)
    private LocalDateTime reservationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 50, nullable = false)
    private ReservationStatus eReservationstatus;
}

