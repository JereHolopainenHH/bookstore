package hh.sof03.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import hh.sof03.bookstore.domain.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);
    AppUser findByEmail(String email);
}
