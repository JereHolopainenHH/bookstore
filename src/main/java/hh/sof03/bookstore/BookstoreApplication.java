package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.AppUser;
import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.repository.AppUserRepository;
import hh.sof03.bookstore.repository.BookRepository;
import hh.sof03.bookstore.repository.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bRepository, CategoryRepository cRepository, AppUserRepository userRepository ) {
		return (args) -> {
			Category c1 = new Category("Scifi");
			Category c2 = new Category("Horror");
			Category c3 = new Category("Fantasy");

			cRepository.save(c1);
			cRepository.save(c2);
			cRepository.save(c3);

			Book b2 = new Book("Dyyni (Dune)", "Drank Herbert", 1965, "978-0-441-17271-9", 12.99, c1);
			Book b3 = new Book("Hohto (The Shining)", "Stephen King", 1977, "978-951-31-0640-9", 15.90, c2);
			Book b1 = new Book("Harry Potter ja viisasten kivi", "J.K.Rowling", 1997, "978-0747532699", 20.00, c3);
			bRepository.save(b1);
			bRepository.save(b2);
			bRepository.save(b3);

			// Create users: user/user admin/admin
			AppUser user = new AppUser("user", "$2a$10$OeRtP2Iy62nDtUdeLTzzzu7NNHbZHMGCj3q2MPp7cWOL5yJMnB0SW", "user@email.com", "USER");
			AppUser admin = new AppUser("admin", "$2a$10$WgndAVsik1z9LrMDrA753ORZavW7CTRnF0d7g1ChIA0AMhIJQjb46", "admin@email.com", "ADMIN");

			userRepository.save(user);
			userRepository.save(admin);
		};
	}
}
