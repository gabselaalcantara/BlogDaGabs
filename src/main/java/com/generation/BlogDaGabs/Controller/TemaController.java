package com.generation.BlogDaGabs.Controller;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.BlogDaGabs.Model.Tema;
import com.generation.BlogDaGabs.Repository.TemaRepository;


@RequestMapping("/tema")
@CrossOrigin (origins = "*", allowedHeaders = "*")
@RestController
public class TemaController {

	@Autowired
	private TemaRepository repository;
	
	@GetMapping
		public ResponseEntity<List<Tema>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
		
	}
	
	@GetMapping ("/id/{id}")
		public ResponseEntity<Tema> GetById (@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
		public ResponseEntity<List<Tema>> GetByDescricao (@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));		
	}
	
	@PostMapping
		public ResponseEntity<Tema> PostarUmTema(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(tema));
	}
	
	@PutMapping
		public ResponseEntity<Tema> EditarUmTema(@RequestBody Tema tema) {
		return ResponseEntity.ok(repository.save(tema));
	}
	
	
	@DeleteMapping("/{id}")
		public void delete (@PathVariable long id) {
		repository.deleteById(id);		
	}
	
}