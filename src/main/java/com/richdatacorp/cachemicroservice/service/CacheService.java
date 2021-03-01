package com.richdatacorp.cachemicroservice.service;

import com.richdatacorp.cachemicroservice.entity.Cache;
import com.richdatacorp.cachemicroservice.repository.CacheRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Service layer for the Cache, handling business logic of the microservice.
 * 
 * @author - Craig Russell Tiu
 */
@Service
public class CacheService {
    
    @Autowired
    private CacheRepository cacheRepository;

	/**
	 * Saves a Cache through interacting with the Cache repository.
	 * 
	 * @param cache - Cache to be saved
	 * @return - Cache that is saved to the repository
	 */
	public Cache saveCache(Cache cache) {
		return cacheRepository.save(cache);
	}

	/**
	 * Finds data with provided key from the repository and returns its value.
	 * 
	 * @param key - Key of the wanted value
	 * @return - Value of the provided key
	 */
	public Cache findByKey(String key) {
		return cacheRepository.findByKey(key);
	}

	/**
	 * The main expire logic for the key-value pairs.
	 * Multithreading was used to ensure that the microservice can handle requests after data is saved.
	 * The thread sleeps for some time specified by the 'valid' property of the Cache.
	 * 
	 * @param cache - Cache to expire
	 */
	@Async
	public void expireCache(Cache cache) {
		try {
			Thread.sleep(cache.getValid() * 1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		cacheRepository.delete(cache);
	}
}
