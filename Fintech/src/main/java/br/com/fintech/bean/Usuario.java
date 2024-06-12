// A classe Usuario é uma classe que representa um usuário do sistema. 
// ela é bean pois contém apenas atributos e métodos de acesso a esses atributos.
package br.com.fintech.bean;

import java.time.LocalDate;

public class Usuario {
	private int id;
	protected String nome;
	private String tel;
	private LocalDate dataNascimento;
	private String cpf;
	private String email;

	public Usuario(String nome, String tel, String cpf, String email, LocalDate dataNascimento) {
		this.nome = nome;
		this.tel = tel;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
