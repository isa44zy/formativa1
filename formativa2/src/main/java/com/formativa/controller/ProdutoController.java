package com.formativa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formativa.entitie.Produto;
import com.formativa.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	public ResponseEntity<Produto> salvarproduto(@RequestBody Produto produto) {
		Produto novoproduto = produtoService.salvarproduto(produto);
		return new ResponseEntity<>(novoproduto, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Produto>> listarTodos(){
		List<Produto> produtos = produtoService.listarTodos();
		return new ResponseEntity<>(produtos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
		Optional<Produto> produto = produtoService.buscarPorId(id);
		return produto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizarproduto(@PathVariable Long id,
			@RequestBody Produto produto){
		if (!produtoService.buscarPorId(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		produto.setId(id);
		Produto produtoAtualizado = produtoService.atualizarproduto(produto);
		return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarproduto(@PathVariable Long id){
		if (!produtoService.buscarPorId(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		produtoService.deletarproduto(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}


