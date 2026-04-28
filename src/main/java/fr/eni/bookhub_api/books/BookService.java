package fr.eni.bookhub_api.books;

import fr.eni.bookhub_api.common.dal.BookRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class BookService implements IBookBLL {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

  @Override
  public List<BookDTO> getAllBooks() {

      return bookRepository.findAll().stream().map(BookDTO::new).toList();
  }
    @Override
  public BookDTO getBookById(int id) {

      return bookRepository.findById(id)
                .map(BookDTO::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livre introuvable : " + id));
  }

    
}
