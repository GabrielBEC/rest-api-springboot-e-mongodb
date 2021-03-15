package com.app.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.dto.TransationDTO;
import com.app.models.Transation;
import com.app.services.TransationService;

@RestController
@RequestMapping("/starstore")
public class TransationResource {

	@Autowired
	private TransationService service;
	
	@PostMapping("/buy")
	public ResponseEntity<Transation> insert(@RequestBody Transation obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/history")
	public ResponseEntity<List<TransationDTO>>  findAll(){
		List<Transation> list = service.findAll();
		List<TransationDTO> listDTO = list.stream().map(x -> new TransationDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/history/{clientId}")
	public ResponseEntity<List<TransationDTO>> findByClientId(@PathVariable String clientId){
		List<Transation> list = service.findByClientId(clientId);
		if(list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			List<TransationDTO> listDTO = list.stream().map(x -> new TransationDTO(x)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDTO);
		}
	}
	
}
