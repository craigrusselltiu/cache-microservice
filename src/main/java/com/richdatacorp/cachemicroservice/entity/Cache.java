package com.richdatacorp.cachemicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Defines the Cache class, containing properties and functions for the entity.
 * 
 * @author Craig Russell Tiu
 */
@Entity
public class Cache {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String key;
    private String value;

    // How long the Cache will be valid for
    private Long valid;

    // Version of entity handled by CrudRepository
    @Version
    private Long version;

    // Default constructor
    public Cache() {}

    // Key value constructor
    public Cache(String key, String value) {
        this.key = key;
        this.value = value;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Long getValid() {
        return valid;
    }

}
