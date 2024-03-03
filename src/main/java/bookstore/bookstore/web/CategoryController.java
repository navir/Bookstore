package bookstore.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import bookstore.bookstore.model.Category;
import bookstore.bookstore.model.CategoryRepository;

@Controller
public class CategoryController {

  @Autowired
    private CategoryRepository repository;

  @GetMapping("/categorylist")
    public String listCategories(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "categorylist";
    }

    @GetMapping("/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @SuppressWarnings("null")
    @PostMapping("/savecategory")
    public String save(Category category) {
        repository.save(category);
        return "redirect:categorylist";
    }
  
}
