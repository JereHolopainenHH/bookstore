package hh.sof03.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import hh.sof03.bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
