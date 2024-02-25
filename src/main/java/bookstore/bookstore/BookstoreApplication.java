package bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
			log.info("Tallennetaan pari esimerkki Book-oliota");
			repository.save(new Book(null, "Sword of Destiny", "Andrzej Sapkowski", 1992, "978-1-4732-1153-7", 0.0));
			repository.save(new Book(null, "The Return of the King", "J. R. R. Tolkien", 1955, "933993", 0.0));	
			log.info("Haetaan kaikki kirjat");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
