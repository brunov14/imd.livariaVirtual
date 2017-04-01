package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarrinhoCompras {
	
	private Map<String, ItemCompra> itens;

	public CarrinhoCompras() {
		this.itens = new HashMap<String, ItemCompra>();
	}
	
	public synchronized void adicionar(Livro livro){
		if(itens.containsKey(livro.getIdLivro())){
			ItemCompra item = itens.get(livro.getIdLivro());
			item.incrementaQuantidade();
		}else{
			ItemCompra novoItem = new ItemCompra(livro);
			itens.put(livro.getIdLivro(),novoItem);
		}
	}
	
	public synchronized void remover(String idLivro){
		if(itens.containsKey(idLivro)){
			ItemCompra item = itens.get(idLivro);
			item.decrementaQuantidade();
			
			//Verifica se a quantidade de itens chegou a 0 
			if(item.getQuantidade() <= 0)
				itens.remove(idLivro);
		}
	}
	
	public synchronized List<ItemCompra> getItens(){
		ArrayList<ItemCompra> resultado = new ArrayList<ItemCompra>();
		resultado.addAll(this.itens.values());
		
		return resultado;
		
	}
	
	protected void finalize() throws Throwable{
		itens.clear();
	}
	
	public synchronized int getNumeroItens(){
		
		int numeroItens = 0;
		
		for (ItemCompra item : getItens()) {
			numeroItens += item.getQuantidade();
		}
		
		return numeroItens;
	}
	
	public synchronized double getTotal(){
		
		double total = 0.0;
		
		for (ItemCompra item : getItens()) {
			Livro livro = item.getItem();
			total += livro.getPreco() * item.getQuantidade();
		}
		
		return total;
	}
	
	public void limpar(){
		itens.clear();
	}
	
}
