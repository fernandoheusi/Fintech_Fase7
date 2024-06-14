package br.com.fintech.bean;

import java.time.LocalDate;

public class Conta extends Usuario {
    private int id;
    private long agencia;
    private long conta;
    private double saldo;
    private String titular;
    private String tipo;
    private int usuarioId;

    public Conta() {
        super();
    }

    public Conta(String nome, String tel, String cpf, String email, LocalDate dataNascimento, String senha) {
        super(nome, tel, cpf, email, dataNascimento, senha);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAgencia() {
        return agencia;
    }

    public void setAgencia(long agencia) {
        this.agencia = agencia;
    }

    public long getConta() {
        return conta;
    }

    public void setConta(long conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
