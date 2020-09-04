package project.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.restaurant.model.RestaurantDto;
import project.restaurant.repository.RestaurantRepository;

@RestController
public class RestaurantController {
	
	@Autowired
	RestaurantRepository repository;
	
	@PostMapping("/hello")
	String hello() {
		return repository.test();
	}
	
	@PostMapping("/post")
	RestaurantDto post(@RequestBody RestaurantDto restaurant) {
		return repository.create(restaurant);
	}
	
	@GetMapping("/get/{restaurantId}")
	RestaurantDto get(@PathVariable String restaurantId) {
		return repository.get(restaurantId);
	}
	
}
