package br.com.fintech.testes;


import br.com.fintech.bean.Usuario;
import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.factory.DAOFactory;

import java.time.LocalDate;
// import java.util.List;

public class UsuarioDAOTeste {
    public static void main(String[] args) {
        UsuarioDAO dao = DAOFactory.getUsuarioDAO();

        // Criar um usuário para teste
        Usuario usuario = new Usuario("Kaique", "12345576", "123.456.789-00", "kaique@kaique.com", LocalDate.of(1999, 9, 16), "123456");

        // Testar salvar usuário
        try {
            dao.salvar(usuario);
            Usuario usuarioValidado = dao.validarUsuario(usuario.getEmail(), usuario.getSenha());
            if (usuarioValidado != null) {
                System.out.println("Usuário validado: " + usuarioValidado.getNome() + ", " + usuarioValidado.getEmail() + ", " + usuarioValidado.getSenha());
            } else {
                System.out.println("Usuário não validado.");
            }
            System.out.println("Usuário salvo com sucesso.");
        } catch (DBException e) {
            e.printStackTrace();
        } 

        // Testar buscar usuário

        /* try {
            Usuario usuarioBuscado = dao.buscar(20);
            if (usuarioBuscado != null) {
                System.out.println("Usuário encontrado: " + usuarioBuscado.getId());
                System.out.println("Usuário encontrado: " + usuarioBuscado.getNome());
            } else {
                System.out.println("Usuário não encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } */

        // Testar listar usuários

        /* try {
            List<Usuario> usuarios = dao.listar();
            for (Usuario u : usuarios) {
                System.out.println("Usuário: " + u.getNome() + ", Email: " + u.getEmail());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } */

        // Testar atualizar usuário

        /* usuario.setNome("John Updated Doe");
        try {
            dao.atualizar(usuario);
            System.out.println("Usuário atualizado com sucesso.");
        } catch (DBException e) {
            e.printStackTrace();
        } */

        // Testar deletar usuário

        /* try {
            dao.deletar(usuario);
            System.out.println("Usuário deletado com sucesso.");
        } catch (DBException e) {
            e.printStackTrace();
        }  */

        // Testar validar usuário
         
    }
}

