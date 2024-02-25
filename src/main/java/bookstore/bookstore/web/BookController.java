package bookstore.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookstore.bookstore.model.BookRepository;


@Controller
public class BookController {

    @Autowired
	private BookRepository repository; 

    @GetMapping("/booklist")
    public String listBooks(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/index", method=RequestMethod.GET)
    public String showIndex(Model model) {
        System.out.println("Index endpoint");
        return "index";
    }
    

}
