package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.repository.BookRepository;

@RestController
@RequestMapping("/api")
public class BookRestController {

    @Autowired
    private BookRepository repo;

    @GetMapping("/booklist")
    public List<Book> getBooklistRest(){
        System.out.println("Getting books");
        return (List<Book>) repo.findAll();
    }

}
