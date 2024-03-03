package bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.model.BookRepository;
import bookstore.bookstore.model.Category;
import bookstore.bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository) {
		return (args) -> {
			log.info("Tallennetaan pari esimerkki Book-oliota");
			brepository.save(new Book(null, "Dracula", "Bram Stoker", 1897, "1447002", 0.0));
			brepository.save(new Book(null, "The Return of the King", "J. R. R. Tolkien", 1955, "933993", 0.0));
			brepository.save(new Book(null, "Sapiens", "Yuval Noah Harari", 2016, "978-952-279-470-3", 0.0));
			log.info("Haetaan kaikki kirjat");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

	@Bean
	public CommandLineRunner categoryDemo(CategoryRepository crepository) {
		return (args) -> {
			log.info("Tallennetaan pari esimerkki Category-oliota");
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Historical"));
			crepository.save(new Category("Horror"));
			log.info("Haetaan kaikki kategoriat");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}

		};
	}

}
