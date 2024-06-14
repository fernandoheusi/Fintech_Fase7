package br.com.fintech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.bean.Movimentacao;
import br.com.fintech.dao.MovimentacaoDAO;
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
		// TODO Auto-generated method stub
        MovimentacaoDAO dao = DAOFactory.getMovimentacaoDAO();
        
        try {
            List<Movimentacao> movimentacao = dao.listar();
            for (Movimentacao m : movimentacao) {
                System.out.println("Movimentacao: " + m.getNome() + ", categoria: " + m.getCategoria() + ", data: " + m.getData() + ", valor: " + m.getValor() );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}