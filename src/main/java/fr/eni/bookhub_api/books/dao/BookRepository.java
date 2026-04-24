package fr.eni.bookhub_api.books.dao;

import fr.eni.bookhub_api.common.bo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

    
} 