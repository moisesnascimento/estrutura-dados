package com.github.moisesnascimento.estruturasdados.listas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PilhaListaArrayTeste {

	@Test
	public void quandoAdicionarDeveRemoverNaOrdemInversaQueFoiAdicionado() {
		PilhaListaArray<String> pilha = new PilhaListaArray<>(5);
		pilha.adicionar("Valor1");
		pilha.adicionar("Valor2");
		Assertions.assertEquals("Valor2", pilha.remover());
		Assertions.assertEquals("Valor1", pilha.remover());
	}
}
