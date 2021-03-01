package com.richdatacorp.cachemicroservice.repository;

import org.springframework.stereotype.Repository;

import com.richdatacorp.cachemicroservice.entity.Cache;

import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository was used for its built-in locking mechanism.
 * However, it is infamous for its resource-extensive nature.
 * An alternative would be to use JDBC, but given the timeframe I chose to not use it.
 * 
 * @author - Craig Russell Tiu
 */
@Repository
public interface CacheRepository extends CrudRepository<Cache, Long> {
    Cache findByKey(String key);
}
