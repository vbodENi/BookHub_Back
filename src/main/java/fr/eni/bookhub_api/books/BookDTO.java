package fr.eni.bookhub_api.books;

import java.time.LocalDateTime;

import fr.eni.bookhub_api.common.bo.Book;
import lombok.Getter;

@Getter
public class BookDTO {
    
      private Integer id;
      private String title;
      private String author;
      private String isbn;
      private String description;
      private String coverUrl;
      private int totalCopies;
      private int availableCopies;
      private LocalDateTime dateAdded;
      private Double averageRating;
      private String categoryLabel;

      public BookDTO(Book book) {
          this.id = book.getId();
          this.title = book.getTitle();
          this.author = book.getAuthor();
          this.isbn = book.getIsbn();
          this.description = book.getDescription();
          this.coverUrl = book.getCoverUrl();
          this.totalCopies = book.getTotalCopies();
          this.availableCopies = book.getAvailableCopies();
          this.dateAdded = book.getDateAdded();
          this.averageRating = book.getAverageRating();
          this.categoryLabel = book.getCategory() != null ? book.getCategory().getLabel() : null;
      }
  
}
