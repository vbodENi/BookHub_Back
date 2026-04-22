package fr.eni.bookhub_api.books.dao;

import java.util.List;

import fr.eni.bookhub_api.common.bo.Book;

public interface IBooksDAO {

    List<Book> findAllBooks();
    
} 