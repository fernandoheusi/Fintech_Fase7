package br.com.fintech.controller;

import br.com.fintech.bean.Conta;
import br.com.fintech.dao.ContaDAO;
import br.com.fintech.dao.impl.OracleContaDAO;
import br.com.fintech.exception.DBException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/conta")
public class ContaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContaDAO contaDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        contaDAO = new OracleContaDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");

        System.out.println("ID do Usuário na sessão: " + usuarioId); // Verifique se o ID está na sessão

        if (usuarioId != null) {
            Conta conta = contaDAO.buscar(usuarioId);
            if (conta != null) {
                request.setAttribute("conta", conta);
            }
            request.getRequestDispatcher("menu.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp?status=failure&msg=Você precisa fazer login primeiro.");
        }
    }
  

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("criar")) {
            criar(request, response);
        } else if (action.equals("atualizar")) {
            atualizar(request, response);
        } else if (action.equals("remover")) {
            remover(request, response);
        }
    }

    private void criar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long agencia = Long.parseLong(request.getParameter("agencia"));
            Long conta = Long.parseLong(request.getParameter("conta"));
            Double saldo = Double.parseDouble(request.getParameter("saldo"));
            String titular = request.getParameter("titular");
            String tipo = request.getParameter("tipo");
            int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));

            Conta novaConta = new Conta();
            novaConta.setAgencia(agencia);
            novaConta.setConta(conta);
            novaConta.setSaldo(saldo);
            novaConta.setTitular(titular);
            novaConta.setTipo(tipo);
            novaConta.setUsuarioId(usuarioId);

            contaDAO.criar(novaConta);

            request.setAttribute("msg", "Conta cadastrada com sucesso!");
            request.getRequestDispatcher("conta.jsp").forward(request, response);
        } catch (DBException | NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("error", "Erro ao cadastrar conta.");
            request.getRequestDispatcher("conta.jsp").forward(request, response);
        }
    }

    private void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Long agencia = Long.parseLong(request.getParameter("agencia"));
            Long conta = Long.parseLong(request.getParameter("conta"));
            Double saldo = Double.parseDouble(request.getParameter("saldo"));
            String titular = request.getParameter("titular");
            String tipo = request.getParameter("tipo");
            int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));

            Conta contaAtualizada = new Conta();
            contaAtualizada.setId(id);
            contaAtualizada.setAgencia(agencia);
            contaAtualizada.setConta(conta);
            contaAtualizada.setSaldo(saldo);
            contaAtualizada.setTitular(titular);
            contaAtualizada.setTipo(tipo);
            contaAtualizada.setUsuarioId(usuarioId);

            contaDAO.atualizar(contaAtualizada);

            request.setAttribute("msg", "Conta atualizada com sucesso!");
            request.getRequestDispatcher("conta.jsp").forward(request, response);
        } catch (DBException | NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("error", "Erro ao atualizar conta.");
            request.getRequestDispatcher("conta.jsp").forward(request, response);
        }
    }

    private void remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            contaDAO.remover(id);

            request.setAttribute("msg", "Conta removida com sucesso!");
            request.getRequestDispatcher("conta.jsp").forward(request, response);
        } catch (DBException | NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("error", "Erro ao remover conta.");
            request.getRequestDispatcher("conta.jsp").forward(request, response);
        }
    }
}
