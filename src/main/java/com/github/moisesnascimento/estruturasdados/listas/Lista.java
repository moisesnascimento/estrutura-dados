package com.github.moisesnascimento.estruturasdados.listas;

public interface Lista<T> {
   
	public T recuperar(int index);
	
	public void trocar(int index, T valor);
	
	public void adicionar(T valor);
	
	public void remover(T valor);
	
	public void remover(int index);
	
	public boolean contem(T valor);
	
	public int recuperarIndex(T valor);
	
	public int getTamanho();
	
	public void inserirElemento(int index, T valor);
	
	public boolean estaVazia();
	
	public void substituirElemento(int index, T valor);
}
