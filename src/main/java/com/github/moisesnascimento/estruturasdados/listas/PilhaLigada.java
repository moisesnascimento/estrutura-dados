package com.github.moisesnascimento.estruturasdados.listas;

import java.util.EmptyStackException;

public class PilhaLigada<T> implements Pilha<T> {

	private No primeiro;
	private int tamanho = 0;

	@Override
	public void adicionar(T valor) {
		No n = new No();
		n.valor = valor;
		if (primeiro == null) {
			primeiro = n;
		} else {
			n.proximo = primeiro;
			primeiro = n;
		}
		tamanho++;
	}

	@Override
	public T topo() {
		if (primeiro == null) {
			throw new EmptyStackException();
		}
		return primeiro.valor;
	}

	@Override
	public T remover() {
		if (primeiro == null) {
			throw new EmptyStackException();
		}
		T valor = primeiro.valor;
		primeiro = primeiro.proximo;
		tamanho--;
		return valor;
	}

	@Override
	public int getTamanho() {
		return tamanho;
	}

	@Override
	public boolean estaVazia() {    
		return primeiro == null;
	}

	private class No {
		T valor;
		No proximo;
	}
}
