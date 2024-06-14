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
import br.com.fintech.utils.CriptografiaUtils;

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

        try {
            // Criptografar a senha recebida antes da validação
            String senhaCriptografada = CriptografiaUtils.criptografar(senha);
            usuario = usuarioDAO.validarUsuario(email, senhaCriptografada);
        } catch (DBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (usuario != null) {
        	HttpSession session = request.getSession();
        	session.setAttribute("usuarioId", usuario.getId());
        	session.setAttribute("usuario", usuario);
        	response.sendRedirect("conta");
        } else {
            response.sendRedirect("login.jsp?status=failure&msg=Email ou senha inválidos.");
        }
    }
}
