package fr.eni.bookhub_api.books;

import java.util.List;

import fr.eni.bookhub_api.common.bo.Book;

public interface IBooksBLL {

    List<Book> getAllBooks();

}