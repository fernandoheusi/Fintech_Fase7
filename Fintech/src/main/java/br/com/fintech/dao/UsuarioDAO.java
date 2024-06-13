// UsuarioDAO é uma interface que define os métodos que devem ser implementados por uma classe que deseja ser um DAO de usuário.


package br.com.fintech.dao;

import br.com.fintech.bean.Usuario;
import java.util.List;
import br.com.fintech.exception.DBException;

public interface UsuarioDAO {
        
        public void salvar(Usuario usuario) throws DBException;
        
        public void atualizar(Usuario usuario) throws DBException;
        
        public void deletar(Usuario usuario) throws DBException;

        public List<Usuario> listar();
        
        Usuario buscar(int id);

        public Usuario validarUsuario(String email, String senha) throws DBException;
        
        
}
