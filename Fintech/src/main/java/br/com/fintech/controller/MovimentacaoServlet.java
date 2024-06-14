package br.com.fintech.controller;

import java.io.IOException;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.bean.Movimentacao;
import br.com.fintech.dao.MovimentacaoDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.factory.DAOFactory;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/home")
public class MovimentacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovimentacaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		// TODO Auto-generated method stub
        MovimentacaoDAO dao = DAOFactory.getMovimentacaoDAO();
        
        try {
            List<Movimentacao> movimentacoes = dao.listar();
            System.out.println(movimentacoes);
            for (Movimentacao m : movimentacoes) {
                System.out.println("Movimentacao: " + m.getNome() + ", categoria: " + m.getCategoria() + ", data: " + m.getData() + ", valor: " + m.getValor() );
            }
            request.setAttribute("movimentacoes", movimentacoes);
        } catch (Exception e) {
            e.printStackTrace();
        }


		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        MovimentacaoDAO dao = DAOFactory.getMovimentacaoDAO();

		
        String nomeNovaMovimentacao = request.getParameter("nomeNovaMovimentacao");
        String categoriaNovaMovimentacao = request.getParameter("categoriaNovaMovimentacao");
		String stringValorNovaMovimentacao = request.getParameter("valorNovaMovimentacao");
		int valorNovaMovimentacao = Integer.parseInt(stringValorNovaMovimentacao);
        String dataNovaMovimentacaoStr = request.getParameter("dataNovaMovimentacao");
        String tipoTransacao = request.getParameter("tipoTransacao");
        int conta = Integer.parseInt(request.getParameter("conta"));
        LocalDate dataNovaMovimentacao;
        
        try {
        	dataNovaMovimentacao = LocalDate.parse(dataNovaMovimentacaoStr);
        } catch (DateTimeParseException e) {
            request.setAttribute("erro", "Data de nascimento inválida.");
            request.getRequestDispatcher("home.jsp").forward(request, response);
            return;
        }

        Movimentacao novaMovimentacao = new Movimentacao(nomeNovaMovimentacao,categoriaNovaMovimentacao, dataNovaMovimentacao, valorNovaMovimentacao, tipoTransacao, conta);
		System.out.println(novaMovimentacao);
        try {
            dao.salvar(novaMovimentacao);
        } catch (DBException e) {
            e.printStackTrace();
//            response.sendRedirect("home.jsp?status=failure&msg=Erro ao cadastrar movimentacao");
        } finally {
            response.sendRedirect("home");

        }

	}

}