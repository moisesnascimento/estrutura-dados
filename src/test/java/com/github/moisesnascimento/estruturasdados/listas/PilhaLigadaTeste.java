package com.github.moisesnascimento.estruturasdados.listas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PilhaLigadaTeste {
	
	@Test
	public void quandoAdicionarDeveRemoverNaOrdemInversaQueFoiAdicionado() {
		PilhaLigada<String> pilha = new PilhaLigada<>();
		pilha.adicionar("Valor1");
		pilha.adicionar("Valor2");
		Assertions.assertEquals("Valor2", pilha.remover());
		Assertions.assertEquals("Valor1", pilha.remover());
	}
	
	@Test
	public void estaVaziaDeveRetornarTrueQuandoPilhaVazia() {
		PilhaLigada<String> pilha = new PilhaLigada<>();
		Assertions.assertTrue(pilha.estaVazia());
	}
}
