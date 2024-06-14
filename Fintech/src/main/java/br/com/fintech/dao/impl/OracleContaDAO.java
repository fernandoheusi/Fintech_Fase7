package br.com.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fintech.bean.Conta;
import br.com.fintech.dao.ContaDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.singleton.ConnectionManager;

public class OracleContaDAO implements ContaDAO {

    @Override
    public void criar(Conta conta) throws DBException {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO TB_CONTA_FINTECH (ID_CONTA, NU_AGENCIA, NU_CONTA, VL_SALDO, NM_TITULAR, TP_CONTA, ID_USUARIO) VALUES (SEQ_CONTA_FINTECH.NEXTVAL, ?, ?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql, new String[]{"ID_CONTA"});
            stmt.setLong(1, conta.getAgencia());
            stmt.setLong(2, conta.getConta());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setString(4, conta.getTitular());
            stmt.setString(5, conta.getTipo());
            stmt.setInt(6, conta.getUsuarioId());
            stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                conta.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar conta.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Conta buscar(int usuarioId) {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Conta conta = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_CONTA_FINTECH WHERE ID_USUARIO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                conta = new Conta();
                conta.setId(rs.getInt("ID_CONTA"));
                conta.setAgencia(rs.getLong("NU_AGENCIA"));
                conta.setConta(rs.getLong("NU_CONTA"));
                conta.setSaldo(rs.getDouble("VL_SALDO"));
                conta.setTitular(rs.getString("NM_TITULAR"));
                conta.setTipo(rs.getString("TP_CONTA"));
                conta.setUsuarioId(rs.getInt("ID_USUARIO"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conta;
    }

    @Override
    public void atualizar(Conta conta) throws DBException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE TB_CONTA_FINTECH SET NU_AGENCIA = ?, NU_CONTA = ?, VL_SALDO = ?, NM_TITULAR = ?, TP_CONTA = ? WHERE ID_CONTA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, conta.getAgencia());
            stmt.setLong(2, conta.getConta());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setString(4, conta.getTitular());
            stmt.setString(5, conta.getTipo());
            stmt.setInt(6, conta.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar conta.");
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
    public void remover(int id) throws DBException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM TB_CONTA_FINTECH WHERE ID_CONTA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover conta.");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
