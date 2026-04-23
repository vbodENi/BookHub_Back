package fr.eni.bookhub_api.common.dal;

import fr.eni.bookhub_api.common.bo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
