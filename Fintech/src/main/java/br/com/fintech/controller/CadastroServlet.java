package br.com.fintech.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.bean.Usuario;
import br.com.fintech.bean.Conta;
import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.dao.ContaDAO;
import br.com.fintech.exception.DBException;
import br.com.fintech.factory.DAOFactory;
import br.com.fintech.utils.CriptografiaUtils;

@WebServlet("/cadastrar")
public class CadastroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
    private ContaDAO contaDAO = DAOFactory.getContaDAO();

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
            usuario.setSenha(senhaCriptografada);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao criptografar a senha.");
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            return;
        }

        try {
            usuarioDAO.salvar(usuario);
            // Buscar o ID do usuário recém-criado
            Usuario usuarioCriado = usuarioDAO.buscarPorEmail(email); // Novo método para buscar usuário pelo email

            // Criação automática da conta após o usuário ser salvo
            Conta conta = new Conta();
            conta.setAgencia(randomizarNumero(4)); // Número de agência randomizado com 4 dígitos
            conta.setConta(randomizarNumero(6));   // Número de conta randomizado
            conta.setSaldo(0.0);
            conta.setTitular(nome);
            conta.setTipo("Corrente"); // Defina o tipo de conta padrão como Corrente
            conta.setUsuarioId(usuarioCriado.getId());

            contaDAO.criar(conta);

            // Atualizar o usuário com o ID da conta criada
            usuarioCriado.setIdConta(conta.getId());
            usuarioDAO.atualizar(usuarioCriado);

            response.sendRedirect("login.jsp?status=success&msg=Usuário cadastrado com sucesso.");
        } catch (DBException e) {
            e.printStackTrace();
            response.sendRedirect("cadastro.jsp?status=failure&msg=Erro ao cadastrar o usuário.");
        }
    }

    private int randomizarNumero(int digitos) {
        Random random = new Random();
        int numero = random.nextInt((int) Math.pow(10, digitos));
        return numero;
    }
}
