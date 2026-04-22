package fr.eni.bookhub_api.books;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.bookhub_api.books.dao.IBooksDAO;
import fr.eni.bookhub_api.common.bo.Book;

@Service
public class BooksService implements IBooksBLL {
    private IBooksDAO ibooksDAO;

    public BooksService(IBooksDAO ibooksDAO) {
        this.ibooksDAO = ibooksDAO;
    }

  @Override
  public List<Book> getAllBooks() {

      return ibooksDAO.findAllBooks();
  }
    
}
