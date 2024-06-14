// A classe Movimentacao é uma classe que representa uma movimentacao do sistema. 
// ela é bean pois contém apenas atributos e métodos de acesso a esses atributos.
package br.com.fintech.bean;

import java.time.LocalDate;

public class Movimentacao {
	private int id;
	protected String nome;
	protected String categoria;
	private LocalDate data;
	private int valor;
	private String tipoTransacao;
	private int conta;

	public Movimentacao(String nome, String categoria, LocalDate data, int valor, String tipoTransacao, int conta) {
		this.nome = nome;
		this.categoria = categoria;
		this.data = data;
		this.valor = valor;
		this.tipoTransacao = tipoTransacao;
		this.conta = conta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipoMovimentacao) {
		this.tipoTransacao = tipoMovimentacao;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}
}

