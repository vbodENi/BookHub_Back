package fr.eni.bookhub_api.common.dal;

import fr.eni.bookhub_api.common.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);
    //Optional contient soit un User soit rien, évite les NullPointerException
    Optional<User> findByEmail(String email);
}
