package com.app.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.dto.ProductDTO;
import com.app.models.Product;
import com.app.services.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/starstore")
public class ProuductResource {

	@Autowired
	private ProductService service;
	
	//@GetMapping("/products")
	@ApiOperation(value = "Retorna uma lista de Produtos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de produtos"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
	@RequestMapping(value = "/products", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<ProductDTO>> findAll(){
		List<Product> list = service.findAll();
		List<ProductDTO> listDTO = list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	//@PostMapping("/product")
	@ApiOperation(value = "Insere um produto ao banco de dados")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Produto foi adicionado ao banco de dados"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
	@RequestMapping(value = "/product", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<Product> insert(@RequestBody Product obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
