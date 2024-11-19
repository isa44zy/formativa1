package com.formativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formativa.entitie.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{
	
}


