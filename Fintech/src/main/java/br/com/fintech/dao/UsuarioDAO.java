package br.com.fintech.dao;

import br.com.fintech.exception.DBException;
import br.com.fintech.bean.Usuario;

public interface UsuarioDAO {
    void salvar(Usuario usuario) throws DBException;
    void atualizar(Usuario usuario) throws DBException;
    void deletar(int id) throws DBException;
    Usuario buscar(int id) throws DBException;
    Usuario validarUsuario(String email, String senha) throws DBException;
    Usuario buscarPorEmail(String email) throws DBException; // Novo método
}
