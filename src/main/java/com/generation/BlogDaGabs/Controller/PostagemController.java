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

import com.generation.BlogDaGabs.Model.Postagem;
import com.generation.BlogDaGabs.Repository.PostagemRepository;


@RequestMapping("/postagens")
@CrossOrigin ("*")
@RestController
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;

	
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll()	{
		return ResponseEntity.ok(repository.findAll());	
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id) {
			return repository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	
	@PostMapping
	public ResponseEntity<Postagem> CriarUmPost(@RequestBody Postagem conteudo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(conteudo));	
	}
	
	@PutMapping	
	public ResponseEntity<Postagem> EditarUmPost(@RequestBody Postagem conteudo) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(conteudo));	
	}
	
	
	@DeleteMapping("/{id}")
	public void DeletarUmPost(@PathVariable long id) {
		repository.deleteById(id);
		
	}
		
}
