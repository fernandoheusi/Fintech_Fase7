package br.com.fintech.dao;

import br.com.fintech.exception.DBException;
import br.com.fintech.bean.Conta;

public interface ContaDAO {
    void criar(Conta conta) throws DBException;
    void atualizar(Conta conta) throws DBException;
    void remover(int id) throws DBException;
    Conta buscar(int id);
}
