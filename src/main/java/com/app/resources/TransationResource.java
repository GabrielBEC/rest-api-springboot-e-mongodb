package com.app.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.dto.TransationDTO;
import com.app.models.Transation;
import com.app.services.TransationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/starstore")
public class TransationResource {

	@Autowired
	private TransationService service;
	
	//@PostMapping("/buy")
	@ApiOperation(value = "Insere dados de uma compra, junto com os dados do cliente")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Dados inseridos com sucesso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
	@RequestMapping(value = "/buy", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<Transation> insert(@RequestBody Transation obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	//@GetMapping("/history")
	@ApiOperation(value = "Retorna o historico de todas as compras efetuadas")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de compras"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
	@RequestMapping(value = "/history", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<TransationDTO>>  findAll(){
		List<Transation> list = service.findAll();
		List<TransationDTO> listDTO = list.stream().map(x -> new TransationDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	//@GetMapping("/history/{clientId}")
	@ApiOperation(value = "Retorna uma lista de compras de um cliente especifico")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de compras"),
			@ApiResponse(code = 404, message = "O cliente especificado não existe"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
	@RequestMapping(value = "/history/{clientId}", method = RequestMethod.GET, produces="application/json")
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
