package bookstore.bookstore.web;

import java.util.List;
import java.util.Optional;

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
import bookstore.bookstore.model.CategoryRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;


    //REST hae kaikki kirjat
    @GetMapping("/books")
    public @ResponseBody List<Book> getAllBooksREST() {
        return (List<Book>) repository.findAll();
    }
    
    //REST hae kirja ID:n perusteella
    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> getBookByIdREST(@PathVariable("id") Long id) {
        return repository.findById(id);
    }
    
    @GetMapping("/booklist")
    public String listBooks(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/addbook")
    public String addStudent(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
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
