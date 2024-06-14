<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Conta</title>
    <link rel="stylesheet" href="css/cadastro-conta.css">
</head>
<body>

<div class="container">
    <div class="header">
        <h2>Cadastro de Conta</h2>
    </div>
    <form>
        <div class="form-group">
            <label for="agencia">Número da Agência</label>
            <input type="text" id="agencia" name="agencia" required>
        </div>
        <div class="form-group">
            <label for="conta">Número da Conta</label>
            <input type="text" id="conta" name="conta" required>
        </div>
        <div class="form-group">
            <label for="saldo">Saldo</label>
            <input type="text" id="saldo" name="saldo" required>
        </div>
        <div class="form-group">
            <label for="titular">Nome do Titular</label>
            <input type="text" id="titular" name="titular" required>
        </div>
        <div class="form-group">
            <button type="submit" class="btn">Cadastrar</button>
        </div>
    </form>
</div>

</body>
</html>