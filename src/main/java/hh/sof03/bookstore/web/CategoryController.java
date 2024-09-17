package hh.sof03.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    // http://localhost:8080/categorylist
    @GetMapping("/categorylist")
    public String getCategoryList() {
        return "categorylist";
    }

}
