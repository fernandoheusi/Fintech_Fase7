<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html> 
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Receita e Despesa</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="css/gastos-registros.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <h2>Cadastro de Receita e Despesa</h2>
        </div>
        <div class="balance">
            <h2>Saldo Atual</h2>
            <p>R$ 0,00</p>
        </div>
        <form action="#" method="get">
            <div class="form-group">
                <label for="transaction-type">Tipo de Transação</label>
                <select id="transaction-type" name="transaction-type" required>
                    <option value="1">Receita</option>
                    <option value="2">Despesa</option>
                </select>
            </div>
            <div class="form-group">
                <label for="description">Descrição</label>
                <input type="text" id="description" name="description" required>
            </div>
            <div class="form-group">
                <label for="amount">Valor</label>
                <input type="number" id="amount" name="amount" required>
            </div>
            <div class="form-group">
                <label for="date">Data</label>
                <input type="date" id="date" name="date" required>
            </div>
            <div class="form-group">
                <button type="submit" class="btn">Cadastrar</button>
            </div>
        </form>
    </div>
</body>
</html>
