package br.com.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fintech.bean.Usuario;
import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;

public class OracleUsuarioDAO implements UsuarioDAO {

    @Override
    public void salvar(Usuario usuario) throws DBException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO TB_USUARIO (ID, NM, TEL, DT_NASC, NU_CPF, EMAIL, SENHA) VALUES (SEQ_USUARIO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getTel());
            stmt.setDate(3, java.sql.Date.valueOf(usuario.getDataNascimento()));
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar usuário.");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void atualizar(Usuario usuario) throws DBException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE TB_USUARIO SET NM = ?, TEL = ?, DT_NASC = ?, NU_CPF = ?, EMAIL = ?, SENHA = ?, ID_CONTA = ? WHERE ID = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getTel());
            stmt.setDate(3, java.sql.Date.valueOf(usuario.getDataNascimento()));
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getSenha());
            stmt.setInt(7, usuario.getIdConta());
            stmt.setInt(8, usuario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar usuário.");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deletar(int id) throws DBException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM TB_USUARIO WHERE ID = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao deletar usuário.");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Usuario buscar(int id) throws DBException {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_USUARIO WHERE ID = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setNome(rs.getString("NM"));
                usuario.setTel(rs.getString("TEL"));
                usuario.setDataNascimento(rs.getDate("DT_NASC").toLocalDate());
                usuario.setCpf(rs.getString("NU_CPF"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setIdConta(rs.getInt("ID_CONTA"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao buscar usuário.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usuario;
    }

    @Override
    public Usuario validarUsuario(String email, String senha) throws DBException {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_USUARIO WHERE EMAIL = ? AND SENHA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setNome(rs.getString("NM"));
                usuario.setTel(rs.getString("TEL"));
                usuario.setDataNascimento(rs.getDate("DT_NASC").toLocalDate());
                usuario.setCpf(rs.getString("NU_CPF"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setIdConta(rs.getInt("ID_CONTA"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao validar usuário.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usuario;
    }

    @Override
    public Usuario buscarPorEmail(String email) throws DBException {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_USUARIO WHERE EMAIL = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setNome(rs.getString("NM"));
                usuario.setTel(rs.getString("TEL"));
                usuario.setDataNascimento(rs.getDate("DT_NASC").toLocalDate());
                usuario.setCpf(rs.getString("NU_CPF"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setIdConta(rs.getInt("ID_CONTA"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao buscar usuário.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usuario;
    }
}
