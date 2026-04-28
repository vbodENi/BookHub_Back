package fr.eni.bookhub_api.books;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.server.ResponseStatusException;

import fr.eni.bookhub_api.common.bo.Book;
import fr.eni.bookhub_api.common.bo.Category;
import fr.eni.bookhub_api.common.dal.BookRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Transactional
@Slf4j
 class TestBookService {

    @Autowired
    private BookService bookService;

      @Autowired
      @MockitoBean
      private BookRepository bookRepository;


   private Book buildBook() {                                                                                                                                                                                                   
      Category category = Category.builder()                                                                                                                                                                                   
              .id(1)                                                                                                                                                                                                           
              .label("Roman")                                                                                                                                                                                                  
              .build();

          return Book.builder()
                  .id(1)
                  .title("Le Petit Prince")
                  .author("Antoine de Saint-Exupéry")
                  .isbn("1111111111")
                  .description("Conte philosophique")
                  .coverUrl("/assets/covers/petit-prince.webp")
                  .totalCopies(5)
                  .availableCopies(3)
                  .averageRating(4.5)
                  .dateAdded(LocalDateTime.now())
                  .category(category)
                  .build();
      }

       @Test
      void getAllBooks() {
          Mockito.when(bookRepository.findAll()).thenReturn(List.of(buildBook()));

          List<BookDTO> result = bookService.getAllBooks();

          log.info("Livres récupérés : {}", result.size());

          Assertions.assertThat(result).hasSize(1);
          Assertions.assertThat(result.get(0).getTitle()).isEqualTo("Le Petit Prince");
          Assertions.assertThat(result.get(0).getAuthor()).isEqualTo("Antoine de Saint-Exupéry");
      }

      @Test
      void getBookById() {
          Mockito.when(bookRepository.findById(1)).thenReturn(Optional.of(buildBook()));

          BookDTO result = bookService.getBookById(1);

          log.info("Livre trouvé : {}", result.getTitle());

          Assertions.assertThat(result.getTitle()).isEqualTo("Le Petit Prince");
          Assertions.assertThat(result.getIsbn()).isEqualTo("1111111111");
          Assertions.assertThat(result.getCategory().getLabel()).isEqualTo("Roman");
      }

      @Test
      void getBookById_throwsNotFoundException() {
          Mockito.when(bookRepository.findById(999)).thenReturn(Optional.empty());

          log.info("Tentative de récupération du livre avec id : 999");

          ResponseStatusException exception = org.junit.jupiter.api.Assertions.assertThrows(
                  ResponseStatusException.class,
                  () -> bookService.getBookById(999)
          );

          Assertions.assertThat(exception.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
      }

    
}
