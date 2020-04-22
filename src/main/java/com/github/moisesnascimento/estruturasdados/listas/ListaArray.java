package com.github.moisesnascimento.estruturasdados.listas;

public class ListaArray<T> implements Lista<T> {

	private Object valores[];
	private int tamanho;

	public ListaArray(int tamanho) {
		valores = new Object[tamanho];
		this.tamanho = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T recuperar(int index) {
		if (index < 0 || index >= tamanho) {
			throw new IndexOutOfBoundsException(index);
		}
		return (T) valores[index];
	}

	@Override
	public void trocar(int index, T valor) {
		if (index < 0 || index >= tamanho) {
			throw new IndexOutOfBoundsException(index);
		}
		valores[index] = valor;
	}

	@Override
	public void adicionar(T valor) {
		if (tamanho >= valores.length) {
			throw new IllegalStateException("Lista cheia");
		}
		valores[tamanho] = valor;
		tamanho++;
	}

	@Override
	public void remover(T valor) {
		int index = recuperarIndex(valor);
		if (index >= 0) {
			remover(index);
		}
	}

	@Override
	public void remover(int index) {
		// fazer no papel
		if (index < 0 || index >= tamanho) {
			throw new IndexOutOfBoundsException(index);
		}
		tamanho--;
		for (int i = index; i < tamanho; i++) {
			valores[i] = valores[i + 1];
		}
		valores[tamanho] = null;
	}

	@Override
	public boolean contem(T valor) {
		return recuperarIndex(valor) != -1;
	}

	@Override
	public int getTamanho() {
		return this.tamanho;
	}

	@Override
	public int recuperarIndex(T valor) {
		for (int i = 0; i < tamanho; i++) {
			if (valores[i] == null && valor == null) {
				return i;
			}
			if (valores[i] != null && valores[i].equals(valor)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void adicionar(int index, T valor) {
		if (index < 0 || index > tamanho) {
			throw new IndexOutOfBoundsException(index);
		}
		for (int i = tamanho - 1; i >= index; i--) {
			valores[i + 1] = valores[i];
		}
		valores[index] = valor;
		tamanho++;
	}

	@Override
	public boolean estaVazia() {
		
		if(tamanho == 0) {
			return true;
		}
		return false;
	}
}
