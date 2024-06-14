package br.com.fintech.bean;

import java.time.LocalDate;

public class Usuario {
    private int id;
    private String nome;
    private String tel;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private String senha;
    private int idConta; // Adicionando ID da conta ao usuário

    // Construtores, getters e setters
    public Usuario() {}

    public Usuario(String nome, String tel, String cpf, String email, LocalDate dataNascimento, String senha) {
        this.nome = nome;
        this.tel = tel;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    // Getters e setters para todos os campos, incluindo idConta
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
}
