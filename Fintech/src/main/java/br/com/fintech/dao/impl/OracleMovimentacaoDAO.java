package br.com.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.Movimentacao;
import br.com.fintech.dao.MovimentacaoDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;

public class OracleMovimentacaoDAO implements MovimentacaoDAO {

    @Override
    public void salvar(Movimentacao movimentacao) throws DBException {
        String sql = "INSERT INTO TB_MOVIMENTACAO (ID_MOVIMENTACAO, NM, CATEGORIA, DATA_MOVIMENTACAO, VALOR, ID_CONTA, TIPO_TRANSACAO) VALUES (RM553184.SEQ_MOVIMENTACAO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, movimentacao.getNome());
            stmt.setString(2, movimentacao.getCategoria());
            stmt.setDate(3, Date.valueOf(movimentacao.getData()));
            stmt.setInt(4, movimentacao.getValor());
            stmt.setInt(5, movimentacao.getConta());
            stmt.setString(6, movimentacao.getTipoTransacao());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException("Erro ao inserir movimentacao", e);
        }
    }

    @Override
    public void atualizar(Movimentacao movimentacao) throws DBException {
        String sql = "UPDATE TB_MOVIMENTACAO SET NM = ?, CATEGORIA = ?, DATA = ?, VALOR = ?, TIPO_TRANSACAO = ? WHERE ID_MOVIMENTACAO = ?";
        try (Connection conn = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, movimentacao.getNome());
            stmt.setString(2, movimentacao.getCategoria());
            stmt.setDate(3, Date.valueOf(movimentacao.getData()));
            stmt.setInt(4, movimentacao.getValor());
            stmt.setString(5, movimentacao.getTipoTransacao());
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
                int id = rs.getInt("ID_MOVIMENTACAO");
                String nome = rs.getString("NM");
                String categoria = rs.getString("CATEGORIA");
                Date data = rs.getDate("DATA_MOVIMENTACAO");
                int valor = rs.getInt("VALOR");
                int conta = rs.getInt("ID_CONTA");
                String tipoTransacao = rs.getString("TIPO_TRANSACAO");
                Movimentacao movimentacao = new Movimentacao(nome, categoria, data.toLocalDate(), valor, tipoTransacao, conta);
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
                    Date data = rs.getDate("DATA_MOVIMENTACAO");
                    int valor = rs.getInt("VALOR");
                    int conta = rs.getInt("ID_CONTA");
                    String tipoTransacao = rs.getString("TIPO_TRANSACAO");
                    movimentacao = new Movimentacao(nome, categoria, data.toLocalDate(), valor, tipoTransacao, conta);
                    movimentacao.setId(id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movimentacao;
    }

    @Override
    public List<Movimentacao> listarPorConta(int idConta) {
        List<Movimentacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM TB_MOVIMENTACAO WHERE ID_CONTA = ?";
        try (Connection conn = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, idConta);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("ID_MOVIMENTACAO");
                    String nome = rs.getString("NM");
                    String categoria = rs.getString("CATEGORIA");
                    Date data = rs.getDate("DATA_MOVIMENTACAO");
                    int valor = rs.getInt("VALOR");
                    int conta = rs.getInt("ID_CONTA");
                    String tipoTransacao = rs.getString("TIPO_TRANSACAO");
                    Movimentacao movimentacao = new Movimentacao(nome, categoria, data.toLocalDate(), valor, tipoTransacao, conta);
                    movimentacao.setId(id);
                    lista.add(movimentacao);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

}
