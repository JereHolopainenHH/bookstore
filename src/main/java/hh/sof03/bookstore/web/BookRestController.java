package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.repository.BookRepository;

@RestController
@RequestMapping("/api")
public class BookRestController {

    @Autowired
    private BookRepository repo;

    // http://localhost:8080/api/booklist
    @GetMapping("/booklist")
    public Iterable<Book> getBooklistRest() {
        return repo.findAll();
    }

    // http://localhost:8080/api/booklist/1
    @GetMapping("/booklist/{id}")
    public Optional<Book> getBookByIdRest(@PathVariable(value = "id") Long id) {
        return repo.findById(id);
    }

}
