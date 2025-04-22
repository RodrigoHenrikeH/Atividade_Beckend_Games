package com.projetogames.rhgames.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projetogames.rhgames.model.Produtos;
import com.projetogames.rhgames.repository.CategoriaRepository;
import com.projetogames.rhgames.repository.ProdutosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ProdutosController {

	@Autowired
	private ProdutosRepository produtosRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<Produtos>> getAll() {
		return ResponseEntity.ok(produtosRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produtos> getById(@PathVariable Long id) {
		return produtosRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Produtos>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(produtosRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping
	public ResponseEntity<Produtos> post(@Valid @RequestBody Produtos produtos) {
		if (produtos.getCategoria() == null || produtos.getCategoria().getId() == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id da Categoria é Obrigatório");

		if (!categoriaRepository.existsById(produtos.getCategoria().getId()))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não existe!", null);

		return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produtos));
	}

	@PutMapping
	public ResponseEntity<Produtos> put(@Valid @RequestBody Produtos produtos) {
		return produtosRepository.findById(produtos.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produtos)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Produtos> produtos = produtosRepository.findById(id);
		if (produtos.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		produtosRepository.deleteById(id);
	}

}
