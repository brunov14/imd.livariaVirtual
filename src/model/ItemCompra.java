package model;

public class ItemCompra {
	
	private Livro item;
	private int quantidade;
	
	public ItemCompra(Livro item) {
		super();
		this.item = item;
		this.quantidade = 1;
	}
	
	public void incrementaQuantidade(){
		this.quantidade++;
	}
	
	public void decrementaQuantidade(){
		this.quantidade--;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Livro getItem() {
		return item;
	}
	
	
	
	
}
