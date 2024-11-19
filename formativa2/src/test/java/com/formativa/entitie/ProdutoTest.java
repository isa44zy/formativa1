package com.formativa.entitie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ProdutoTest {
	private Produto produto;
	@BeforeEach
	void setUp() {
		//Arrange
		produto = new Produto(1L, "Julia Maria", "julia maria", 12.0);
	}

	@Test
	@DisplayName ("Testando o getter e setter do campo id")
	void testId() {
		//Act
		produto.setId(2L);
		//Assert
		assertEquals(2L,produto.getId());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void TestNome() {
		//Act
		produto.setNome("Joao Paulo");
		//Assert
		assertEquals("Joao Paulo", produto.getNome());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo email")
	void TestEmail() {
		//Act
		produto.setDescricao("joao paulo fei");
		//Assert
		assertEquals("joao paulo fei", produto.getDescricao());

	}
	@Test
	@DisplayName("Testando o getter e setter do campo email")
	void Testpreco() {
		//Act
		produto.setPreco(13.0);
		//Assert
		assertEquals(13.0, produto.getPreco());

	}
}