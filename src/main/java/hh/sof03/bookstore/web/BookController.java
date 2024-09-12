package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.repository.BookRepository;

@Controller
public class BookController {

    // http://localhost:8080/index

    // handle GET-request for /index
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    // http://localhost:8080/booklist
    @Autowired
    private BookRepository repository;

    @GetMapping("/booklist")
    public String getBooklist(Model model) {
        model.addAttribute("booklist", repository.findAll());
        return "booklist";
    }

    @GetMapping("/booklist/add")
    public String getBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/booklist/save")
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/booklist/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/booklist";
    }
}
