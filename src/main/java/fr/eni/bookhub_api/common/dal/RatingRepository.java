package fr.eni.bookhub_api.common.dal;

import fr.eni.bookhub_api.common.bo.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Reservation, Integer> {
}
