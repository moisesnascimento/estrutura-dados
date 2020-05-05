package com.github.moisesnascimento.estruturasdados.listas;

public class ListaDuplamenteLigada<T> implements Lista<T> {

	private No<T> primeiro;
	private int tamanho = 0;

	@Override
	public T recuperar(int index) {
		if (index < 0 || index >= getTamanho()) {
			throw new IndexOutOfBoundsException(index);
		}
		No<T> atual = primeiro;
		while (index > 0) {
			atual = atual.proximo;
			index--;
		}
		return atual.valor;
	}

	@Override
	public void trocar(int index, T valor) {

	}

	@Override
	public void adicionar(T valor) {
		if (primeiro == null) {
			No<T> no = new No<>();
			no.valor = valor;
			primeiro = no;
		} else {
			No<T> atual = primeiro;
			while (atual.proximo != null) {
				atual = atual.proximo;
			}
			No<T> no = new No<>();
			no.valor = valor;
			atual.proximo = no;
			no.anterior = atual;
		}
		tamanho++;
	}

	@Override
	public void remover(T valor) {
		if (estaVazia()) {
			return;
		}
		No<T> atual = primeiro;
		while (atual != null && !atual.valor.equals(valor)) {
			atual = atual.proximo;
		}
		if (atual == null) {
			return;
		}
		if (atual.proximo == null && atual.anterior == null) {
			// remover se tiver um elemento
			primeiro = null;
		} else if (atual.proximo == null) {
			// remover no final
			atual.anterior.proximo = null;
		} else if (atual.anterior == null) {
			// remover no inicio
			primeiro = atual.proximo;
			atual.anterior = null;
		} else {
			// remover no meio
			atual.anterior.proximo = atual.proximo;
			atual.proximo.anterior = atual.anterior;
		}
		tamanho--;
	}

	@Override
	public void remover(int index) {
		if (index < 0 || index >= getTamanho()) {
			throw new IndexOutOfBoundsException(index);
		}
		No<T> atual = primeiro;
		while (index > 0) {
			atual = atual.proximo;
			index--;
		}
		if (atual.proximo == null && atual.anterior == null) {
			primeiro = null;
		} else if (atual.proximo == null) {
			atual.anterior.proximo = null;
		} else if (atual.anterior == null) {
			primeiro = atual.proximo;
			atual.anterior = null;
		} else {
			atual.anterior.proximo = atual.proximo;
			atual.proximo.anterior = atual.anterior;
		}
		tamanho--;
	}

	@Override
	public boolean contem(T valor) {
		No<T> atual = primeiro;
		while (atual != null && !atual.valor.equals(valor)) {
			atual = atual.proximo;
		}
		return atual != null;
	}

	@Override
	public int recuperarIndex(T valor) {
		int indexAtual = 0;
		No<T> atual = primeiro;
		while (atual != null && !atual.valor.equals(valor)) {
			atual = atual.proximo;
			indexAtual++;
		}
		if (atual == null) {
			return -1;
		}
		return indexAtual;
	}

	@Override
	public int getTamanho() {
		return this.tamanho;
	}

	@Override
	public void adicionar(int index, T valor) {
		if (index < 0 || index > getTamanho()) {
			throw new IndexOutOfBoundsException(index);
		}
		No<T> atual = primeiro;
		No<T> anterior = null;
		while (index > 0) {
			anterior = atual;
			atual = atual.proximo;
			index--;
		}
		No<T> no = new No<>();
		no.valor = valor;
		if (atual == null) {
			anterior.proximo = no;
			no.anterior = anterior;
		} else if (atual.anterior == null) {
			primeiro = no;
			no.proximo = atual;
			atual.anterior = no;
		} else {
			atual.anterior.proximo = no;
			no.anterior = atual.anterior;
			no.proximo = atual;
			atual.anterior = no;
		}
		tamanho++;
	}

	@Override
	public boolean estaVazia() {
		return tamanho == 0;
	}

	private class No<E> {
		E valor;
		No<E> proximo;
		No<E> anterior;
	}
}
