package hh.sof03.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

// REMOVE THIS LATER, ONLY HERE SO THAT THE GET-method works properly without template
@ResponseBody
public class BookController {

    // http://localhost:8080/index

    // handle GET-request for /index
    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
