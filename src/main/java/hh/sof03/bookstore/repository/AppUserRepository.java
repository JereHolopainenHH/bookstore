package hh.sof03.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import hh.sof03.bookstore.domain.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);
}
