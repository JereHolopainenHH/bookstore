package hh.sof03.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @Autowired
    private BookRepository repository;

    // http://localhost:8080/booklist
    @GetMapping("/booklist")
    public String getBooklist(Model model) {

        model.addAttribute("booklist", repository.findAll());

        return "booklist";
    }

}
