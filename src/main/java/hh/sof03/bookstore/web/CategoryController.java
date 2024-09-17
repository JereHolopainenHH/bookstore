package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.repository.CategoryRepository;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    // http://localhost:8080/categorylist
    @GetMapping("/categorylist")
    public String getCategoryList() {
        return "categorylist";
    }

    // http://localhost:8080/categorylist/add
    @GetMapping("/categorylist/add")
    public String getAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    // save new category
    @PostMapping("/category/save")
    public String saveCategory(Category category) {
        repository.save(category);
        return "redirect:/categorylist";
    }

}
