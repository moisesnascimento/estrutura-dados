package com.github.moisesnascimento.estruturasdados.listas;

public interface Pilha<T> {

	public void adicionar(T valor);
	
	public T topo();

	public T remover();

	public int getTamanho();

	public boolean estaVazia();

}
