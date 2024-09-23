package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.repository.BookRepository;
import hh.sof03.bookstore.repository.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bRepository, CategoryRepository cRepository) {
		return (args) -> {
			Book b1 = new Book("Harry Potter ja viisasten kivi", "J.K.Rowling", 1997, "978-0747532699", 20.00, null);
			Book b2 = new Book("Harry Potter ja salaisuuksien kammio", "J.K.Rowling", 1998, "978-0747538493", 20.00, null);
			Book b3 = new Book("Harry Potter ja Azkabanin vanki", "J.K.Rowling", 1999, "978-0747542155", 20.00, null);

			bRepository.save(b1);
			bRepository.save(b2);
			bRepository.save(b3);

			Category c1 = new Category("Scifi");
			Category c2 = new Category("Horror");
			Category c3 = new Category("Fantasy");

			cRepository.save(c1);
			cRepository.save(c2);
			cRepository.save(c3);

			System.out.println("Categories: " + cRepository.findAll());
		};
	}
}
