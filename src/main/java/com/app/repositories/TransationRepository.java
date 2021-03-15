package com.app.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.models.Transation;

@Repository
public interface TransationRepository extends MongoRepository<Transation, String> {

	List<Transation> findByClientId(String clientId);
	
}
