package fr.eni.bookhub_api.common.dal;

import fr.eni.bookhub_api.common.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
