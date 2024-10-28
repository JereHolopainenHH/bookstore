package hh.sof03.bookstore.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.sof03.bookstore.domain.AppUser;
import hh.sof03.bookstore.repository.AppUserRepository;

import java.util.Optional;

/**
 * This class is used by spring security to authenticate and authorize user
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final AppUserRepository repository;

	public UserDetailServiceImpl(AppUserRepository userRepository) {
		this.repository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> curruser = repository.findByUsername(username);
		UserDetails user = new User(username, curruser.get().getPasswordHash(),
				AuthorityUtils.createAuthorityList(curruser.get().getRole()));

		/*
		 * UserDetails user = new
		 * org.springframework.security.core.userdetails.User(username,
		 * curruser.getPasswordHash(),
		 * AuthorityUtils.createAuthorityList(curruser.getRole()));
		 */
		return user;
	}
}
