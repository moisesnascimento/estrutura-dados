package com.github.moisesnascimento.estruturasdados.listas;

import java.util.EmptyStackException;

public class PilhaListaArray<T> implements Pilha<T> {

	private ListaArray<T> lista;
	private int tamanho;

	public PilhaListaArray(int tamanho) {
		lista = new ListaArray<>(tamanho);
		this.tamanho = tamanho;
	}

	@Override
	public void adicionar(T valor) {
		if (getTamanho() == tamanho) {
			throw new IllegalStateException("Pilha cheia");
		}
		lista.adicionar(valor);
	}

	@Override
	public T remover() {
		if (estaVazia()) {
			throw new EmptyStackException();
		}
		T valor = lista.recuperar(lista.getTamanho() - 1);
		lista.remover(lista.getTamanho() - 1);
		return valor;
	}

	@Override
	public int getTamanho() {
		return lista.getTamanho();
	}

	@Override
	public boolean estaVazia() {
		return lista.estaVazia();
	}

	@Override
	public T topo() {
		if (estaVazia()) {
			throw new EmptyStackException();
		}
		return lista.recuperar(lista.getTamanho() - 1);
	}
}
