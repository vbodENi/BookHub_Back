package fr.eni.bookhub_api.books;

import java.util.List;

public interface IBookBLL {

    List<BookDTO> getAllBooks();
    BookDTO getBookById(int id);

}