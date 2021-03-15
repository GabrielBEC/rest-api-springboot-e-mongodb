package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.Transation;
import com.app.repositories.TransationRepository;

@Service
public class TransationService {

	@Autowired
	private TransationRepository repository;
	
	public Transation insert(Transation obj) {
		return repository.insert(obj);
	}
	
	public List<Transation> findAll(){
		return repository.findAll();
	}
	
	public List<Transation> findByClientId(String clientId){
		return repository.findByClientId(clientId);
	}
	
}
