package hh.sof03.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import hh.sof03.bookstore.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByName(String name);
    Optional<Category> findByCategoryId(Long categoryId);
}
