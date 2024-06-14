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
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import br.com.fintech.bean.Movimentacao;
import br.com.fintech.dao.MovimentacaoDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;

public class OracleMovimentacaoDAO implements MovimentacaoDAO {

	@Override
	public void salvar(Movimentacao movimentacao) throws DBException {
		String sql = "INSERT INTO TB_MOVIMENTACAO (ID_MOVIMENTACAO, NM, CATEGORIA, DATA, VALOR) VALUES (SQ_TB_MOVIMENTACAO.NEXTVAL, ?, ?, ?, ?)";
		try (Connection conn = ConnectionManager.getInstance().getConnection();
		     PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, movimentacao.getNome());
			stmt.setString(2, movimentacao.getCategoria());
			stmt.setDate(3, Date.valueOf(movimentacao.getData()));
			stmt.setInt(4, movimentacao.getValor());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao inserir movimentacao", e);
		}
	}

	@Override
	public void atualizar(Movimentacao movimentacao) throws DBException {
		String sql = "UPDATE TB_MOVIMENTACAO SET NM = ?, CATEGORIA = ?, DATA = ?, VALOR = ? WHERE ID_MOVIMENTACAO = ?";
		try (Connection conn = ConnectionManager.getInstance().getConnection();
		     PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, movimentacao.getNome());
			stmt.setString(2, movimentacao.getCategoria());
			stmt.setDate(3, Date.valueOf(movimentacao.getData()));
			stmt.setInt(4, movimentacao.getValor());
			stmt.setInt(6, movimentacao.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar movimentacao", e);
		}
	}

	@Override
	public void deletar(Movimentacao movimentacao) throws DBException {
		String sql = "DELETE FROM TB_MOVIMENTACAO WHERE ID_MOVIMENTACAO = ?";
		try (Connection conn = ConnectionManager.getInstance().getConnection();
		     PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, movimentacao.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao deletar usuário", e);
		}
	}

	@Override
	public List<Movimentacao> listar() {
		List<Movimentacao> lista = new ArrayList<>();
		String sql = "SELECT * FROM TB_MOVIMENTACAO";
		try (Connection conn = ConnectionManager.getInstance().getConnection();
		     PreparedStatement stmt = conn.prepareStatement(sql);
		     ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("ID");
				String nome = rs.getString("NM");
				String categoria = rs.getString("CATEGORIA");
				Date data = rs.getDate("DATA");
				int valor = rs.getInt("VALOR");
				Movimentacao movimentacao= new Movimentacao(nome, categoria, data.toLocalDate(), valor);
				movimentacao.setId(id);
				lista.add(movimentacao);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Movimentacao buscar(int id) {
		Movimentacao movimentacao = null;
		String sql = "SELECT * FROM TB_MOVIMENTACAO WHERE ID_MOVIMENTACAO = ?";
		try (Connection conn = ConnectionManager.getInstance().getConnection();
		     PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					String nome = rs.getString("NM");
					String categoria = rs.getString("CATEGORIA");
					Date data = rs.getDate("DATA");
					int valor = rs.getInt("VALOR");
					String email = rs.getString("EMAIL");
					movimentacao = new Movimentacao(nome, categoria, data.toLocalDate(), valor );
					movimentacao.setId(id);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movimentacao;
	}
}

