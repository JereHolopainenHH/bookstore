package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.repository.CategoryRepository;

import java.util.Optional;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByNameShouldReturnCategory() {
        Optional<Category> optionalCategory = repository.findByName("Scifi");
        assertThat(optionalCategory).isNotNull();
    }

    @Test
    public void createNewCategory() {
        Category category = new Category("Classics");
        repository.save(category);
        assertThat(category.getCategoryId()).isNotNull();
    }

    @Test
    public void deleteCategody(){
        Optional<Category> category = repository.findByName("Scifi");
        assertThat(category).isNotNull();

        repository.delete(category.get());

        Optional<Category> deletedCategory = repository.findByCategoryId(category.get().getCategoryId());
        assertThat(deletedCategory).isEmpty();
    }

}