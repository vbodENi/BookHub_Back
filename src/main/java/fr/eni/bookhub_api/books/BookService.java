package fr.eni.bookhub_api.books;

import java.util.List;


import org.springframework.stereotype.Service;

import fr.eni.bookhub_api.common.dal.BookRepository;


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
                .orElseThrow(() -> new RuntimeException("Livre introuvable : " + id));
  }

    
}
