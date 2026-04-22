package fr.eni.bookhub_api.books;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.bookhub_api.common.bo.Book;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BooksController {

    private IBooksBLL ibooksBLL;

    public BooksController(IBooksBLL ibooksBLL) {
        this.ibooksBLL = ibooksBLL;
    }

    @GetMapping("/books") 
        public List<Book> getAllBooks(){
            return ibooksBLL.getAllBooks();
        }
}
    
