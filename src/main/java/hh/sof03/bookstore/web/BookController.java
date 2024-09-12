package hh.sof03.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof03.bookstore.domain.Book;

@Controller
public class BookController {

    // http://localhost:8080/index

    // handle GET-request for /index
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    // http://localhost:8080/booklist
    @GetMapping("/booklist")
    public String getBooklist(Book book, Model model) {

        List<Book> booklist = new ArrayList<>();

        Book b1 = new Book("Harry Potter ja viisasten kivi", "J.K.Rowling", 1997, "978-0747532699", 20.00);
        Book b2 = new Book("Harry Potter ja salaisuuksien kammio", "J.K.Rowling", 1998, "978-0747538493", 20.00);
        Book b3 = new Book("Harry Potter ja Azkabanin vanki", "J.K.Rowling", 1999, "978-0747542155", 20.00);
        Book b4 = new Book("Harry Potter ja liekehtivä pikari", "J.K.Rowling", 2000, "978-0747546245", 25.00);
        Book b5 = new Book("Harry Potter ja Feeniksin kilta", "J.K.Rowling", 2003, "978-0747551003", 25.00);
        Book b6 = new Book("Harry Potter ja puoliverinen prinssi", "J.K.Rowling", 2005, "978-0747581086", 25.00);
        Book b7 = new Book("Harry Potter ja kuoleman varjelukset", "J.K.Rowling", 2007, "978-0545139700", 30.00);

        booklist.add(b1);
        booklist.add(b2);
        booklist.add(b3);
        booklist.add(b4);
        booklist.add(b5);
        booklist.add(b6);
        booklist.add(b7);

        model.addAttribute("booklist", booklist);

        return "booklist";
    }

}
