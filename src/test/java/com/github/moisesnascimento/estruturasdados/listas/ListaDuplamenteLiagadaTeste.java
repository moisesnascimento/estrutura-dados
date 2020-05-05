package com.github.moisesnascimento.estruturasdados.listas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ListaDuplamenteLiagadaTeste {

	@Test
	public void adicionarNaPosicaoEspecificaDeveAdicionar() {
		ListaDuplamenteLigada<String> lista = new ListaDuplamenteLigada<>();
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar("teste3");
		lista.adicionar(1, "teste4");
		assertEquals("teste1", lista.recuperar(0));
		assertEquals("teste4", lista.recuperar(1));
		assertEquals("teste2", lista.recuperar(2));
		assertEquals("teste3", lista.recuperar(3));
	}
	@Test
	public void adicionarNaPosicaoIncialEspecificaDeveAdicionar() {
		ListaDuplamenteLigada<String> lista = new ListaDuplamenteLigada<>();
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar("teste3");
		lista.adicionar(0, "teste4");
		assertEquals("teste4", lista.recuperar(0));
		assertEquals("teste1", lista.recuperar(1));
		assertEquals("teste2", lista.recuperar(2));
		assertEquals("teste3", lista.recuperar(3));
	}
	@Test
	public void adicionarAposUltimoElemento() {
		ListaDuplamenteLigada<String> lista = new ListaDuplamenteLigada<>();
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar("teste3");
		lista.adicionar(3, "teste4");
		assertEquals("teste1", lista.recuperar(0));
		assertEquals("teste2", lista.recuperar(1));
		assertEquals("teste3", lista.recuperar(2));
		assertEquals("teste4", lista.recuperar(3));
	}
}
