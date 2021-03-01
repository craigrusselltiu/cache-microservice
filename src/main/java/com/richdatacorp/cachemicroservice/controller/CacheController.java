package com.richdatacorp.cachemicroservice.controller;

import com.richdatacorp.cachemicroservice.entity.Cache;
import com.richdatacorp.cachemicroservice.service.CacheService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Cache controller, mapping requests sent to the URL and calling service layer functionalities.
 * 
 * @author Craig Russell Tiu
 */
@RestController
@RequestMapping("/cache")
public class CacheController {
    
    @Autowired
    private CacheService cacheService;

    /**
     * Handles POST request by saving data via the Cache service.
     * 
     * @param cache - Cache data provided
     * @return - Data saved to the repository
     */
    @PostMapping("/")
    public Cache saveCache(@RequestBody Cache cache) {
        cacheService.expireCache(cache);
        return cacheService.saveCache(cache);
    }

    /**
     * Handles GET requests by returning the value of the provided key via the Cache service.
     * 
     * @param key - Key used to lookup
     * @return - Value of the provided key
     */
    @GetMapping("/{key}")
    public String getValue(@PathVariable("key") String key) {
        Cache cache = cacheService.findByKey(key);
        return cache.getValue();
    }
}
