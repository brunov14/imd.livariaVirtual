package model;

public class Livro {
	
	private String idLivro;
	private String titulo;
	private String autores;
	private int ano;
	private double preco;
	private int quantidade;
	private String descricao;
	
		
	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Livro(String idLivro, String titulo, String autores, int ano, double preco, int quantidade,
			String descricao) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.autores = autores;
		this.ano = ano;
		this.preco = preco;
		this.quantidade = quantidade;
		this.descricao = descricao;
	}

	public String getIdLivro() {
		return idLivro;
	}
	
	public void setIdLivro(String idLivro) {
		this.idLivro = idLivro;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutores() {
		return autores;
	}
	
	public void setAutores(String autores) {
		this.autores = autores;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
