package user.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import user.example.test.model.User;
import user.example.test.repository.UserRepository;

@RestController
public class Controller {
	
	@Autowired
	UserRepository repository;
	
	@PostMapping("/post")
	void post(@RequestBody User user) {
		repository.create(user);
	}
	@GetMapping("/get")
	void get() {
		repository.getAll();
	}
	@GetMapping("/test/{id}")
	void getuser(@PathVariable String id) {
		repository.get(id);
	}
	
	@GetMapping("/hello")
	String hello() {
		return "hello";
	}
}
