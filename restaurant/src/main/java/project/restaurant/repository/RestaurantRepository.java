package project.restaurant.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.stereotype.Repository;

import project.restaurant.model.RestaurantDto;




@Repository
public class RestaurantRepository {
	final Logger logger = LoggerFactory.getLogger(RestaurantRepository.class);
	private HashOperations hashOperations;
	
	public RestaurantRepository(RedisTemplate<?, ?> redisTemplate) {
		 RedisSerializer<Object> stringSerializer = new GenericToStringSerializer<Object>(Object.class);
		 redisTemplate.setKeySerializer(stringSerializer);
		 redisTemplate.setKeySerializer(stringSerializer);
		 redisTemplate.setValueSerializer(stringSerializer);
		 redisTemplate.setHashKeySerializer(stringSerializer);
		 redisTemplate.setHashValueSerializer(stringSerializer);
		 this.hashOperations = redisTemplate.opsForHash();
	}
	
	public RestaurantDto create(RestaurantDto restaurant) {
        logger.info(String.format("Restaurant with ID %s saved", restaurant.getId()));
        String lista = String.join("-", restaurant.getAll());
        hashOperations.put(lista, restaurant.getId(), restaurant.getDate());
        return restaurant;
	}
	
	public RestaurantDto get(String restaurantId) {
		logger.info(String.format(restaurantId));
		return (RestaurantDto) hashOperations.get("Restaurant", restaurantId);
	}
	
	public String test() {
		String infos = "TestAgain";
		hashOperations.put(infos, "test","hello");
		return "Hello";
	}
	

}
