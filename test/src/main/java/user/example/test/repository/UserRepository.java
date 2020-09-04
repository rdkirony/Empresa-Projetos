package user.example.test.repository;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import user.example.test.model.User;

@Repository
public class UserRepository {
	 final Logger logger = LoggerFactory.getLogger(UserRepository.class);
		private HashOperations hashOperations;
		
		@Autowired
		public UserRepository(RedisTemplate<?, ?> redisTemplate) {
			 RedisSerializer stringSerializer = new StringRedisSerializer();
			 redisTemplate.setKeySerializer(stringSerializer);
			 redisTemplate.setKeySerializer(stringSerializer);
			 redisTemplate.setValueSerializer(stringSerializer);
			 redisTemplate.setHashKeySerializer(stringSerializer);
			 redisTemplate.setHashValueSerializer(stringSerializer);
			 this.hashOperations = redisTemplate.opsForHash();
		}
		
		public void create(User user) {
			hashOperations.put("User", user.getUserId(), user);
	        logger.info(String.format("User with ID %s saved", user.getUserId()));
		}
		
		public User get(String userId) {
			logger.info(String.format(userId));
			return (User) hashOperations.get("User", userId);
		}

		public Map<String, User> getAll(){
			return hashOperations.entries("User");
		}
		
		public void update(User user) {
			hashOperations.put("User", user.getUserId(), user);
	        logger.info(String.format("User with ID %s updated", user.getUserId()));
		}
		
		public void delete(String userId) {
			hashOperations.delete("User", userId);
	        logger.info(String.format("User with ID %s deleted", userId));
		}
}
