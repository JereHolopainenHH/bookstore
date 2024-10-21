package hh.sof03.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import hh.sof03.bookstore.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
