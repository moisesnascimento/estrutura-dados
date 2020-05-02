package com.github.moisesnascimento.estruturasdados.listas;

public class ListaLigada<T> implements Lista<T> {

	private No<T> primeiro;
	private int tamanho = 0;

	@Override
	public T recuperar(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException(index);
		}
		int indexAtual = 0;
		No<T> atual = primeiro;
		while (indexAtual < index && atual != null) {
			atual = atual.proximo;
			indexAtual++;
		}
		if (atual == null) {
			throw new IndexOutOfBoundsException(index);
		}
		return atual.valor;
	}

	@Override
	public void trocar(int index, T valor) {
		if (index < 0) {
			throw new IndexOutOfBoundsException(index);
		}
		int indexAtual = 0;
		No<T> atual = primeiro;
		while (indexAtual < index && atual != null) {
			atual = atual.proximo;
			indexAtual++;
		}
		if (atual == null) {
			throw new IndexOutOfBoundsException(index);
		}
		atual.valor = valor;
	}

	@Override
	public void adicionar(T valor) {
		if (primeiro == null) {
			primeiro = new No<>();
			primeiro.valor = valor;
		} else {
			No<T> atual = primeiro;
			while (atual.proximo != null) {
				atual = atual.proximo;
			}
			No<T> novo = new No<>();
			novo.valor = valor;
			atual.proximo = novo;
		}
		this.tamanho++;
	}

	@Override
	//**
	//erro remover primeiro elemento
	public void remover(T valor) {
		No<T> anterior = primeiro;
		No<T> atual = primeiro;
		if (primeiro.valor.equals(valor)) {
			atual = atual.proximo;
		}
		while (atual != null && !atual.valor.equals(valor)) {
			anterior = atual;
			atual = atual.proximo;
		}
		if (atual != null &&atual.valor.equals(valor)) {
			anterior.proximo = atual.proximo;
		}
		tamanho--;
	}

	@Override
	//**
	//erro remover posicao na posicao 0;
	public void remover(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException(index);
		}
		No<T> anterior = primeiro;
		No<T> atual = primeiro;
		int indexAtual = 0;
		while (indexAtual < index && atual != null) {
			anterior = atual;
			atual = atual.proximo;
			indexAtual++;
		}
		if(index == indexAtual) {
			anterior.proximo = atual.proximo;
		}
		this.tamanho--;
	}

	@Override
	public boolean contem(T valor) {
		No<T> atual = primeiro;
		while (atual != null) {
			if (atual.valor.equals(valor)) {
				return true;
			}
			atual = atual.proximo;
		}
		return false;
	}

	@Override
	//**
	//somente valores diferentes
	public int recuperarIndex(T valor) {
		int indexAtual = 0;
		No<T> atual = primeiro;
		while (atual != null && !atual.valor.equals(valor)) {
			atual = atual.proximo;
			indexAtual++;
		}
		return indexAtual;
	}

	@Override
	//**
	public int getTamanho() {
		return this.tamanho;
	}

	@Override
	public void adicionar(int index, T valor) {

	}

	@Override
	//**
	public boolean estaVazia() {
		if (tamanho == 0) {
			return true;
		}
		return false;
	}

	private class No<E> {
		E valor;
		No<E> proximo;
	}
}
