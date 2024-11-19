package com.formativa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formativa.entitie.Produto;
import com.formativa.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtorepository;
	
	public Produto salvarproduto (Produto produto) {
		return produtorepository.save(produto);
	}
	public List<Produto> listarTodos(){
		return produtorepository.findAll();
	}
	public Optional<Produto> buscarPorId(Long id){
		return produtorepository.findById(id);
	}
	public Produto atualizarproduto (Produto produto) {
		if (produtorepository.existsById(produto.getId())) {
			return produtorepository.save(produto);
		}else{
			throw new RuntimeException("Hóspede não encontrado");
		}
	}
	public void deletarproduto(Long id) {
		produtorepository.deleteById(id);
	}
}
