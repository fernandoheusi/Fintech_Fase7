// UsuarioDAO é uma interface que define os métodos que devem ser implementados por uma classe que deseja ser um DAO de usuário.


package br.com.fintech.dao;

import br.com.fintech.bean.Movimentacao;
import java.util.List;
import br.com.fintech.exception.DBException;

public interface MovimentacaoDAO {
        
        public void salvar(Movimentacao movimentacao) throws DBException;
        
        public void atualizar(Movimentacao movimentacao) throws DBException;
        
        public void deletar(Movimentacao movimentacao) throws DBException;

        public List<Movimentacao> listar();
        
        Movimentacao buscar(int id);
        
        
}
