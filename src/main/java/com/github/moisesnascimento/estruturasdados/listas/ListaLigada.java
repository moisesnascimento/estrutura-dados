package com.github.moisesnascimento.estruturasdados.listas;

public class ListaLigada<T> implements Lista<T> {

	private No<T> primeiro;

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
	}

	@Override
	public void remover(T valor) {
		No<T> anterior = primeiro;
		No<T> atual = primeiro;
		while (atual != null && !atual.valor.equals(valor)) {
			anterior = atual;
			atual = atual.proximo;
		}
		if (atual != null && atual.valor.equals(valor)) {
			anterior.proximo = atual.proximo;
		}
	}

	@Override
	public void remover(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contem(T valor) {
		No<T> atual = primeiro;
		while(atual != null) {
			if(atual.valor.equals(valor)) {
				return true;
			}
			atual = atual.proximo;
		}
		return false;
	}

	@Override
	public int recuperarIndex(T valor) {

		return 0;
	}

	@Override
	public int getTamanho() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void adicionar(int index, T valor) {
		

	}

	@Override
	public boolean estaVazia() {
		
		return false;
	}

	private class No<E> {
		E valor;
		No<E> proximo;
	}

}
