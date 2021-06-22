package br.com.abaloneapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="nome")
	private String nome;
    
    @Column(name="categoria")
	private String categoria;
    
    @Column(name="valor")
	private float valor;
    
    public Produto() {
    	
    }
	
    public Produto(int id, String nome, float valor, String categoria){
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.valor = valor;
    }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", valor=" + valor +"]";
	}	
}
