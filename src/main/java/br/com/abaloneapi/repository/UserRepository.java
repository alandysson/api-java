package br.com.abaloneapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.abaloneapi.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	Optional<User> findByEmail(String email);
	Optional<User> findByPassword(String password);
}
