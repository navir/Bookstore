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
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Tallennetaan muutama esimerkkikirja sekä kategorioita");

			Category category1 = new Category("Horror");
			Category category2 = new Category("Fantasy");
			Category category3 = new Category("Historical");

			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);

			brepository.save(new Book("Dracula", "Bram Stoker", 1897, "1447002", 0.0, category1));
			brepository.save(new Book("The Return of the King", "J. R. R. Tolkien", 1955, "933993", 0.0, category2));
			brepository.save(new Book("Sapiens", "Yuval Noah Harari", 2016, "978-952-279-470-3", 0.0, category3));
			
			log.info("Haetaan kaikki kirjat");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}

