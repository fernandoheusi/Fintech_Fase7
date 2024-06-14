package br.com.fintech.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.fintech.bean.Usuario;
import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.factory.DAOFactory;
import br.com.fintech.utils.CriptografiaUtils;

@WebServlet("/cadastrar")
public class CadastroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO dao = DAOFactory.getUsuarioDAO();

    public CadastroServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String tel = request.getParameter("tel");
        String dataNascimentoStr = request.getParameter("dataNascimento");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (nome == null || tel == null || dataNascimentoStr == null || cpf == null || email == null || senha == null) {
            request.setAttribute("erro", "Todos os campos são obrigatórios.");
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            return;
        }

        LocalDate dataNascimento;
        try {
            dataNascimento = LocalDate.parse(dataNascimentoStr);
        } catch (DateTimeParseException e) {
            request.setAttribute("erro", "Data de nascimento inválida.");
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setTel(tel);
        usuario.setDataNascimento(dataNascimento);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        try {
            String senhaCriptografada = CriptografiaUtils.criptografar(senha);
            System.out.println("Senha criptografada durante cadastro: " + senhaCriptografada);
            usuario.setSenha(senhaCriptografada);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao criptografar a senha.");
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            return;
        }

        try {
            dao.salvar(usuario);
            response.sendRedirect("login.jsp?status=success&msg=Usuário cadastrado com sucesso.");
        } catch (DBException e) {
            e.printStackTrace();
            response.sendRedirect("cadastro.jsp?status=failure&msg=Erro ao cadastrar o usuário.");
        }
    }
}
