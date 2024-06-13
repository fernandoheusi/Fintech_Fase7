<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>EasyBank</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #7879F1;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 300px; /* ajustei a largura máxima para melhor visualização */
            margin: auto; /* centraliza o container na página */
        }

        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }

        .button-submit-form {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 3px;
            background-color: #7879F1;
            color: #fff;
            cursor: pointer;
        }

        .links-container {
            text-align: center;
            margin-top: 10px;
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
    <div class="login-container">
        <h2>EasyBank</h2>

        <form action="#" method="post">
            <input type="email" name="email" placeholder="E-mail" required />

            <input type="password" name="password" placeholder="Senha" required />

            <button type="submit" class="button-submit-form">Entrar</button>
        </form>

        <div class="links-container">
            <a href="#">Esqueceu a senha?</a>
            <span>|</span>
            <a href="#">Cadastre-se</a>
        </div>
    </div>
</body>
</html>
