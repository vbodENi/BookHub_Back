package fr.eni.bookhub_api.books.dao.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.eni.bookhub_api.books.dao.IBooksDAO;
import fr.eni.bookhub_api.common.bo.Book;

@Component
public class DAOBooksMock implements IBooksDAO {
     private List<Book> books = new ArrayList<>();

     public DAOBooksMock() {
        books.add(new Book("Le Petit Prince", "Antoine de Saint-Exupéry"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("Harry Potter", "J.K. Rowling"));
        books.add(new Book("j'ai pas d'inspi", "Celui qui veut"));

     }

     @Override
     public List<Book> findAllBooks() {
        return books;
     }
    
}
