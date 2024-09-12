package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.repository.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Harry Potter ja viisasten kivi", "J.K.Rowling", 1997, "978-0747532699", 20.00);
			Book b2 = new Book("Harry Potter ja salaisuuksien kammio", "J.K.Rowling", 1998, "978-0747538493", 20.00);
			Book b3 = new Book("Harry Potter ja Azkabanin vanki", "J.K.Rowling", 1999, "978-0747542155", 20.00);
			Book b4 = new Book("Harry Potter ja viisasten kivi", "J.K.Rowling", 2000, "978-0747546245", 25.00);
			Book b5 = new Book("Harry Potter ja viisasten kivi", "J.K.Rowling", 2003, "978-0747551003", 25.00);
			Book b6 = new Book("Harry Potter ja viisasten kivi", "J.K.Rowling", 2005, "978-0747581086", 25.00);
			Book b7 = new Book("Harry Potter ja viisasten kivi", "J.K.Rowling", 2007, "978-0545139700", 30.00);
		};
	}
}
