package fr.eni.bookhub_api.common.dal;

import fr.eni.bookhub_api.common.bo.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
