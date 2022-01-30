package br.com.abaloneapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.abaloneapi.model.Produto;
import br.com.abaloneapi.model.User;
import br.com.abaloneapi.repository.UserRepository;

@RestController
@RequestMapping(path="/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody(required=true) User user){
		Optional<User> userEmail = userRepository.findByEmail(user.getEmail());
		Optional<User> userPassword = userRepository.findByPassword(user.getPassword());
		
		if(userPassword.isPresent() && userEmail.isPresent()) {
			  return ResponseEntity.status(HttpStatus.OK).body(user.getEmail());
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
