package hh.sof03.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    // http://localhost:8080/index

    // handle GET-request for /index
    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
