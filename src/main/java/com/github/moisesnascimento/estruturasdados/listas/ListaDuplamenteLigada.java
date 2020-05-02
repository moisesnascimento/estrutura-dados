package com.github.moisesnascimento.estruturasdados.listas;

import com.github.moisesnascimento.estruturasdados.listas.ListaLigada.No;

public class ListaDuplamenteLigada<T> implements Lista<T> {

	@Override
	public T recuperar(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void trocar(int index, T valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void adicionar(T valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(T valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contem(T valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int recuperarIndex(T valor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTamanho() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void adicionar(int index, T valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean estaVazia() {
		// TODO Auto-generated method stub
		return false;
	}

	private class No<E> {
		E valor;
		No<E> proximo;
		No<E> anterior;
	}
}
