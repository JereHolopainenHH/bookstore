package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.bookstore.domain.AppUser;
import hh.sof03.bookstore.repository.AppUserRepository;

import java.util.Optional;

@DataJpaTest
public class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository repository;

    @Test
    public void findByUsernameShouldReturnUser() {
        Optional<AppUser> user = repository.findByUsername("user");
        assertThat(user).isNotNull();
    }

    @Test
    public void findByEmailShouldReturnUser() {
        Optional<AppUser> user = repository.findByEmail("user@email.com");
        assertThat(user).isNotNull();
        assertThat(user.get().getUsername()).isEqualTo("user");
    }

    @Test
    public void createUser(){
        AppUser user = new AppUser("test", "$2a$12$QHDmeN06.vde3AyRqTkX4.b77jJ.RZe6xutIt63Lksk6ywsIgt17m", "test@email.com", "USER");
        repository.save(user);
        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void deleteUser(){
        Optional<AppUser> user = repository.findByUsername("user");
        assertThat(user).isNotNull();

        repository.delete(user.get());
        Optional<AppUser> deletedUser = repository.findById(user.get().getId());
        assertThat(deletedUser).isEmpty();
    }
}
