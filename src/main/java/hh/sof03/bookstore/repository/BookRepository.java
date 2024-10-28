package hh.sof03.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import hh.sof03.bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
    Optional<Book> findByAuthor(String author);
    Optional<Book> findByPublicationYear(Integer publicationYear);
}
