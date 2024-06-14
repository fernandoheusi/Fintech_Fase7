package br.com.fintech.controller;

import java.io.IOException;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.bean.Movimentacao;
import br.com.fintech.dao.MovimentacaoDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.factory.DAOFactory;

@WebServlet("/home")
public class MovimentacaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MovimentacaoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovimentacaoDAO dao = DAOFactory.getMovimentacaoDAO();

        try {
            List<Movimentacao> movimentacoes = dao.listar();
            request.setAttribute("movimentacoes", movimentacoes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovimentacaoDAO dao = DAOFactory.getMovimentacaoDAO();

        String nomeNovaMovimentacao = request.getParameter("nomeNovaMovimentacao");
        String categoriaNovaMovimentacao = request.getParameter("categoriaNovaMovimentacao");
        String stringValorNovaMovimentacao = request.getParameter("valorNovaMovimentacao");
        int valorNovaMovimentacao = Integer.parseInt(stringValorNovaMovimentacao);
        String dataNovaMovimentacaoStr = request.getParameter("dataNovaMovimentacao");
        String tipoTransacao = request.getParameter("tipoTransacao");

        // Captura o ID da conta da URL ou do parâmetro do formulário
        String contaStr = request.getParameter("conta");
        int conta = Integer.parseInt(contaStr);

        LocalDate dataNovaMovimentacao;
        try {
            dataNovaMovimentacao = LocalDate.parse(dataNovaMovimentacaoStr);
        } catch (DateTimeParseException e) {
            request.setAttribute("erro", "Data de nascimento inválida.");
            request.getRequestDispatcher("home.jsp").forward(request, response);
            return;
        }

        Movimentacao novaMovimentacao = new Movimentacao(nomeNovaMovimentacao, categoriaNovaMovimentacao, dataNovaMovimentacao, valorNovaMovimentacao, tipoTransacao, conta);
        try {
            dao.salvar(novaMovimentacao);
        } catch (DBException e) {
            e.printStackTrace();
        } finally {
            response.sendRedirect("home?conta=" + conta);
        }
    }
}
