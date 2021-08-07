package br.com.abaloneapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="nome_cliente")
	private String nome_cliente; 
	@Column(name="produtos")
	private String produtos;   
	@Column(name="valor")
	private float valor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	public String getProdutos() {
		return produtos;
	}
	public void setProdutos(String produtos) {
		this.produtos = produtos;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
}
