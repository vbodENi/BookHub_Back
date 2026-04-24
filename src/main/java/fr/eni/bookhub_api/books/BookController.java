package fr.eni.bookhub_api.books;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class BookController {

    private IBookBLL ibooksBLL;

    public BookController(IBookBLL ibooksBLL) {
        this.ibooksBLL = ibooksBLL;
    }

    @GetMapping("/books") 
        public List<BookDTO> getAllBooks(){
            return ibooksBLL.getAllBooks();
        }

    @GetMapping("/books/{id}") 
        public BookDTO getBookById(@PathVariable int id){
            return ibooksBLL.getBookById(id);
        }
}
    
