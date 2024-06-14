// OracleUsuarioDAO é a implementação da interface UsuarioDAO que é responsável por realizar as operações de CRUD no banco de dados Oracle.
/* CREATE TABLE TB_USUARIO (
ID INT PRIMARY KEY,
NM VARCHAR (50),
TEL VARCHAR (20),
DT_NASC DATE,
NU_CPF VARCHAR (14),
EMAIL VARCHAR (50)

) */
package br.com.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import br.com.fintech.bean.Usuario;
import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;
import br.com.fintech.utils.CriptografiaUtils;

public class OracleUsuarioDAO implements UsuarioDAO {

	@Override
    public void salvar(Usuario usuario) throws DBException {
        String sql = "INSERT INTO TB_USUARIO (ID, NM, TEL, DT_NASC, NU_CPF, EMAIL, SENHA) VALUES (SQ_TB_USUARIO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getTel());
            stmt.setDate(3, java.sql.Date.valueOf(usuario.getDataNascimento()));
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getSenha());
            System.out.println("Armazenando senha: " + usuario.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao inserir usuário", e);
        }
    }

	 @Override
	    public Usuario validarUsuario(String email, String senha) {
	        Usuario usuario = null;
	        String sql = "SELECT * FROM TB_USUARIO WHERE EMAIL = ? AND SENHA = ?";
	        try (Connection conn = ConnectionManager.getInstance().getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            String senhaCriptografada = CriptografiaUtils.criptografar(senha);
	            System.out.println("Senha criptografada para validação: " + senhaCriptografada);

	            stmt.setString(1, email);
	            stmt.setString(2, senhaCriptografada);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    usuario = new Usuario();
	                    usuario.setId(rs.getInt("ID"));
	                    usuario.setNome(rs.getString("NM"));
	                    usuario.setTel(rs.getString("TEL"));
	                    usuario.setDataNascimento(rs.getDate("DT_NASC").toLocalDate());
	                    usuario.setCpf(rs.getString("NU_CPF"));
	                    usuario.setEmail(rs.getString("EMAIL"));
	                    usuario.setSenha(rs.getString("SENHA"));

	                    System.out.println("Usuário encontrado: " + usuario.getEmail());
	                } else {
	                    System.out.println("Usuário não encontrado com os dados fornecidos.");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return usuario;
	    }


	@Override
	public void atualizar(Usuario usuario) throws DBException {
		String sql = "UPDATE TB_USUARIO SET NM = ?, TEL = ?, DT_NASC = ?, NU_CPF = ?, EMAIL = ? WHERE ID = ?";
		try (Connection conn = ConnectionManager.getInstance().getConnection();
		     PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getTel());
			stmt.setDate(3, Date.valueOf(usuario.getDataNascimento()));
			stmt.setString(4, usuario.getCpf());
			stmt.setString(5, usuario.getEmail());
			stmt.setInt(6, usuario.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar usuário", e);
		}
	}

	@Override
	public void deletar(Usuario usuario) throws DBException {
		String sql = "DELETE FROM TB_USUARIO WHERE ID = ?";
		try (Connection conn = ConnectionManager.getInstance().getConnection();
		     PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, usuario.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao deletar usuário", e);
		}
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<>();
		String sql = "SELECT * FROM TB_USUARIO";
		try (Connection conn = ConnectionManager.getInstance().getConnection();
		     PreparedStatement stmt = conn.prepareStatement(sql);
		     ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("ID");
				String nome = rs.getString("NM");
				String tel = rs.getString("TEL");
				String cpf = rs.getString("NU_CPF");
				String email = rs.getString("EMAIL");
				Date dataNascimento = rs.getDate("DT_NASC");
				String senha = rs.getString("SENHA");
				Usuario usuario = new Usuario(nome, tel, cpf, email, dataNascimento.toLocalDate(), senha);
				usuario.setId(id);
				lista.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Usuario buscar(int id) {
		Usuario usuario = null;
		String sql = "SELECT * FROM TB_USUARIO WHERE ID = ?";
		try (Connection conn = ConnectionManager.getInstance().getConnection();
		     PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					String nome = rs.getString("NM");
					String tel = rs.getString("TEL");
					String cpf = rs.getString("NU_CPF");
					String email = rs.getString("EMAIL");
					Date dataNascimento = rs.getDate("DT_NASC");
					String senha = rs.getString("SENHA");
					usuario = new Usuario(nome, tel, cpf, email, dataNascimento.toLocalDate(), senha);
					usuario.setId(id);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}


}

