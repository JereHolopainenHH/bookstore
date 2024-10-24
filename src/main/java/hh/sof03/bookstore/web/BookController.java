package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.repository.BookRepository;
import hh.sof03.bookstore.repository.CategoryRepository;

@Controller
public class BookController {

    // inject BookRepository
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository cRepository;

    // http://localhost:8080/index
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    // http://localhost:8080/login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // http://localhost:8080/booklist
    @GetMapping("/booklist")
    public String getBooklist(Model model) {
        model.addAttribute("booklist", repository.findAll());
        return "booklist";
    }

    // http://localhost:8080/booklist/add
    @GetMapping("/booklist/add")
    public String getAddForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", cRepository.findAll());
        return "addbook";
    }

    // save book
    @PostMapping("/booklist/save")
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    // delete book by id
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/booklist/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/booklist";
    }

    // show editing page
    @GetMapping("/booklist/edit/{id}")
    public String getEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", repository.findById(id));
        model.addAttribute("categories", cRepository.findAll());
        return "editbook";
    }

    // edit book
    @PostMapping("/booklist/edit")
    public String editBook(Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }
}
