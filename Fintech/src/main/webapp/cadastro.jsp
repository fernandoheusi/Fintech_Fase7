<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cadastro</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family:  Arial, sans-serif;
            background-color: #7879F1;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
        }

        .form-container h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .form-container input {
            width: calc(100% - 20px);
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }

        .form-container .button-submit-form {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 3px;
            background-color: #7879F1;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .form-container .button-submit-form:hover {
            background-color: #7879F1;
        }

        .links-container {
            text-align: center;
            margin-top: 20px;
        }

        .links-container a {
            color: #7879F1;
            text-decoration: none;
            margin: 0 10px;
        }

        .links-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Cadastro</h2>

        <form action="#" method="post">
            <input type="text" name="nome" placeholder="Nome" required />
            <br>
            <input type="tel" name="telefone" placeholder="Telefone" required />
            <br>
            <input type="date" name="data_nascimento" placeholder="Data de Nascimento" required />
            <br>
            <input type="text" name="cpf" placeholder="CPF" required />
            <br>
            <input type="email" name="email" placeholder="E-mail" required />
            <br>
            <input type="password" name="senha" placeholder="Senha" required />
            <br>
            <button type="submit" class="button-submit-form">Cadastrar</button>
        </form>

        <div class="links-container">
            <a href="#">Já possui uma conta? Faça login</a>
        </div>
    </div>
</body>
</html>

</html>