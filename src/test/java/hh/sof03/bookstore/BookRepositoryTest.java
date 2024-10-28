package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.repository.BookRepository;
import hh.sof03.bookstore.repository.CategoryRepository;

import java.util.Optional;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository cRepository;

    @Test
    public void findByTitleShouldReturnBook() {
        Optional<Book> book = repository.findByTitle("Dyyni (Dune)");
        assertThat(book).isNotNull();
    }

    @Test
    public void findByAuthorShouldReturnBook() {
        Optional<Book> book = repository.findByAuthor("Drank Herbert");
        assertThat(book).isNotNull();
    }

    @Test
    public void findByPublicationYearShouldReturnBook() {
        Optional<Book> book = repository.findByPublicationYear(1965);
        assertThat(book).isNotNull();
    }

    @Test
    public void createNewBook() {
        Book book = new Book("Paul Trembley", "A Head Full of Ghosts", 2015, "ISBN434345621394",
        16.30, cRepository.findByName("Horror").get());
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook(){
        Optional<Book> book = repository.findByTitle("Dyyni (Dune)");
        assertThat(book).isNotNull();

        repository.delete(book.get());
        Optional<Book> deletedBook = repository.findById(book.get().getId());
        assertThat(deletedBook).isEmpty();
    }

}