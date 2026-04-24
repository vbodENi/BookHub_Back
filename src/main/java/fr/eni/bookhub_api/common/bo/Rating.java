package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.bo.compositeKey.RatingId;
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
@Table(name = "RATING")
@IdClass(RatingId.class)
public class Rating {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BOOK")
    private Book book;

    @Column(name = "VALUE", nullable = false)
    private int value;

    @Column(name = "DATE", nullable = false)
    private LocalDateTime ratingDate;
}