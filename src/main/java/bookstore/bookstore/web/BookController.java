package bookstore.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookstore.bookstore.model.Book;
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

    @RequestMapping(value = "/addbook")
    public String addStudent(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @SuppressWarnings("null")
    @PostMapping("/savebook")
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @SuppressWarnings("null")
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        repository.deleteById(id);
        return "redirect:../booklist";
    }

    @SuppressWarnings("null")
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", repository.findById(id));
        return "editbook";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showIndex(Model model) {
        System.out.println("Index endpoint");
        return "index";
    }

}
