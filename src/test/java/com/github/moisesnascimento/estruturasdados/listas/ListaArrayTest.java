package com.github.moisesnascimento.estruturasdados.listas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ListaArrayTest {

	@Test
	public void quandoListaCriadaTamanhoDeveSerZero() {
		ListaArray<String> lista = new ListaArray<>(5);
		assertEquals(0, lista.getTamanho());
	}

	@Test
	public void quandoAdicionaElementoTamanhoDeveIncrementarEmUm() {
		ListaArray<String> lista = new ListaArray<>(5);
		lista.adicionar("teste");
		assertEquals(1, lista.getTamanho());
	}

	@Test
	public void quandoRecuperarPeloIndexDeveTrazerElementoCorreto() {
		ListaArray<String> lista = new ListaArray<>(5);
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar("teste3");
		lista.adicionar("teste4");
		assertEquals("teste1", lista.recuperar(0));
		assertEquals("teste2", lista.recuperar(1));
		assertEquals("teste3", lista.recuperar(2));
		assertEquals("teste4", lista.recuperar(3));
	}

	@Test
	public void quandoRecuperarPeloIndexForaLimitesDeveLancarExecao() {
		ListaArray<String> lista = new ListaArray<>(5);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			lista.recuperar(6);
		});
	}

	@Test
	public void quandoTrocarElementoEleDeveSerTrocado() {
		ListaArray<String> lista = new ListaArray<>(5);
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar("teste3");
		lista.trocar(1, "teste6");
		assertEquals("teste1", lista.recuperar(0));
		assertEquals("teste6", lista.recuperar(1));
		assertEquals("teste3", lista.recuperar(2));
	}

	@Test
	public void quandoTrocarPeloIndexForaLimitesDeveLancarExecao() {
		ListaArray<String> lista = new ListaArray<>(5);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			lista.trocar(1, "teste");
			;
		});
	}

	@Test
	public void quandoAdicionarElementoDeveSerAdicionado() {
		ListaArray<String> lista = new ListaArray<>(5);
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar("teste3");
		lista.adicionar("teste4");
		assertEquals("teste1", lista.recuperar(0));
		assertEquals("teste2", lista.recuperar(1));
		assertEquals("teste3", lista.recuperar(2));
		assertEquals("teste4", lista.recuperar(3));
	}

	@Test
	public void quandoAdicionarListaCheiaLancaExecao() {
		ListaArray<String> lista = new ListaArray<>(4);
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar("teste3");
		lista.adicionar("teste4");
		assertThrows(IllegalStateException.class, () -> {
			lista.adicionar("teste5");
			;
		});

	}

	@Test
	public void quandoRemoverElementoPeloValorDeveSerRemovido() {
		ListaArray<String> lista = new ListaArray<>(4);
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar("teste3");
		lista.adicionar("teste4");
		lista.remover("teste2");
		assertEquals("teste1", lista.recuperar(0));
		assertEquals("teste3", lista.recuperar(1));
		assertEquals("teste4", lista.recuperar(2));
	}

	@Test
	public void quandoRemoverElementoPeloIndexDeveSerRemovido() {
		ListaArray<String> lista = new ListaArray<>(4);
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar("teste3");
		lista.adicionar("teste4");
		lista.remover(1);
		assertEquals("teste1", lista.recuperar(0));
		assertEquals("teste3", lista.recuperar(1));
		assertEquals("teste4", lista.recuperar(2));
	}

	@Test
	public void quandoRemoverPeloIndexForaLimitesDeveLancarExecao() {
		ListaArray<String> lista = new ListaArray<>(5);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			lista.remover(2);
		});
	}

	@Test
	public void contemDeveRetornarTrueSeElementoEstaNaLista() {
		ListaArray<String> lista = new ListaArray<>(4);
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar("teste3");
		lista.adicionar("teste4");
		assertTrue(lista.contem("teste1"));
		assertTrue(lista.contem("teste2"));
		assertTrue(lista.contem("teste3"));
		assertTrue(lista.contem("teste4"));

	}

	@Test
	public void contemDeveRetornarFalsoSeElementoNaoEstaNaLista() {
		ListaArray<String> lista = new ListaArray<>(4);
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar("teste3");
		lista.adicionar("teste4");
		assertFalse(lista.contem("teste6"));
		assertFalse(lista.contem("teste7"));
		assertFalse(lista.contem("teste8"));
		assertFalse(lista.contem("teste9"));

	}

	@Test
	public void recuperarIndexDeveRecuperarIndexDoElemento() {
		ListaArray<String> lista = new ListaArray<>(4);
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar(null);
		lista.adicionar("teste4");
		assertEquals(0, lista.recuperarIndex("teste1"));
		assertEquals(1, lista.recuperarIndex("teste2"));
		assertEquals(2, lista.recuperarIndex(null));
		assertEquals(3, lista.recuperarIndex("teste4"));
	}
	
	@Test
	public void recuperarIndexDeveRetornarMenosUmQuandoElementoNaoEstaNaLista() {
		ListaArray<String> lista = new ListaArray<>(4);
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar("teste3");
		lista.adicionar("teste4");
		assertEquals(-1, lista.recuperarIndex("teste5"));
		assertEquals(-1, lista.recuperarIndex("teste6"));
		assertEquals(-1, lista.recuperarIndex("teste7"));
		assertEquals(-1, lista.recuperarIndex("teste8"));

	}
	
	@Test
	public void verificarSeElementoFoiAdicionadoNoIndexEspecifico() {
		ListaArray<String> lista = new ListaArray<>(4);
		lista.inserirElemento(3,"teste1");
		lista.inserirElemento(2,"teste2");
		lista.inserirElemento(1,"teste3");
		lista.inserirElemento(0,"teste4");
		
		assertEquals("teste4", lista.recuperar(0));
	}
	
	@Test
	public void inserirElementoDeveRetornarIndiceIndisponivelSeIndexDiferenteNull() {
		ListaArray<String> lista = new ListaArray<>(4);
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar("teste3");
		lista.adicionar("teste4");

		assertThrows(IndexOutOfBoundsException.class, () -> {
			lista.inserirElemento(4, "teste5");
			;
		});
	}
	
	@Test
	public void inserirElementoDeveRetornarListaSeIndexDiferenteNull() {
		ListaArray<String> lista = new ListaArray<>(4);
		lista.adicionar("teste1");
		lista.adicionar("teste2");
		lista.adicionar("teste3");
		lista.adicionar("teste4");

		assertThrows(IllegalStateException.class, () -> {
			lista.inserirElemento(0, "teste5");
			;
		});
	}
	
	@Test
	public void EstaVaziaDeveRetornarTrueSeTamanhoIgualZero() {
		ListaArray<String> lista = new ListaArray<>(4);
		assertTrue(lista.estaVazia());
	}
	
	@Test
	public void EstaVaziaDeveRetornarFalseSeTamanhoDiferenteZero() {
		ListaArray<String> lista = new ListaArray<>(4);
		lista.adicionar("teste1");
		assertFalse(lista.estaVazia());
	}
}
