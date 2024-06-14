package br.com.fintech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.fintech.bean.Usuario;
import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.dao.impl.OracleUsuarioDAO;
import br.com.fintech.exception.DBException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    public LoginServlet() {
        super();
        usuarioDAO = new OracleUsuarioDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Usuario usuario = null;

        System.out.println("Email recebido: " + email);
        System.out.println("Senha recebida: " + senha);

        try {
            usuario = usuarioDAO.validarUsuario(email, senha);
        } catch (DBException e) {
            e.printStackTrace();
        }

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            session.setAttribute("usuarioId", usuario.getId()); 
            response.sendRedirect("conta");
        } else {
            response.sendRedirect("login.jsp?status=failure&msg=Email ou senha inválidos.");
        }
    }
}
