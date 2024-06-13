<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Carteira</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
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

        .credit-card-container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
        }

        .credit-card-container h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .credit-card {
            background-image: url('cartaoimg.png'); /* Substitua 'credit-card.jpg' pelo caminho da sua imagem de cartão de crédito */
            background-size: cover;
            background-position: center;
            width: 100%;
            height: 200px;
            margin-bottom: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .credit-card-info {
            padding: 20px;
            background-color: #7879F1;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: left;
        }

        .credit-card-info p {
            margin: 10px 0;
            font-size: 16px;
        }

        .credit-card-form {
            margin-top: 20px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: left;
        }

        .credit-card-form label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        .credit-card-form input {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }

        .credit-card-form select {
            width: calc(50% - 10px);
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #7879F1;
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
            transition: background-color 0.3s;
        }

        .button-submit-form:hover {
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
    <div class="credit-card-container">
        <h2>Adicionar Cartão de Crédito</h2>

        <div class="credit-card"></div>

    
        <form class="credit-card-form">
            <label for="numero-cartao">Número do Cartão:</label>
            <input type="text" id="numero-cartao" name="numero-cartao" maxlength="16" required /><br>

            <label for="nome-titular">Nome do Titular:</label>
            <input type="text" id="nome-titular" name="nome-titular" required /><br>

            <label for="validade">Validade:</label>
            <input type="text" id="validade" name="validade" placeholder="MM/AA" maxlength="5" required /><br>

            <label for="cvv">CVV:</label>
            <input type="text" id="cvv" name="cvv" maxlength="3" required /><br>

            <button type="submit" class="button-submit-form">Salvar Cartão</button>
        </form>

        <div class="links-container">
            <a href="#">Cancelar</a>
        </div>
    </div>
</body>
</html>
