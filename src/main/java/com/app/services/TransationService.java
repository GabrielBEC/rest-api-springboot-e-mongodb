package com.app.services;

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
	
}
