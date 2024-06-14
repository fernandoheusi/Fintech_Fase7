
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html> 
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cartão</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="css/registro-cartao.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <h2>Cartões</h2>
        </div>
        <div class="balance">
            <h2>Registrar novo Cartão</h2>           
        </div>
        <form>
            <div class="form-group">
                <label for="cardholder-name">Nome do Titular</label>
                <input type="text" id="cardholder-name" name="cardholder-name" required>
            </div>
            <div class="form-group">
                <label for="card-number">Número do Cartão</label>
                <input type="text" id="card-number" name="card-number" maxlength="16" required>
            </div>
            <div class="form-group">
                <label for="expiry-date">Data de Validade</label>
                <input type="month" id="expiry-date" name="expiry-date" required>
            </div>
            <div class="form-group">
                <label for="cvv">Código de Segurança (CVV)</label>
                <input type="text" id="cvv" name="cvv" maxlength="3" required>
            </div>
            <div class="form-group">
                <button type="submit" class="btn">Cadastrar</button>
            </div>
        </form>
        <div class="registered-cards">
            <div class="card-item">
                <h3>Cartão 1</h3>
                <p>Número do Cartão: **** **** **** 1234</p>
                <button class="edit-button btn btn-primary">
                    <i class="fas fa-edit"></i>
                    Extrato 
                </button>
                <button class="delete-button btn btn-danger">
                    <i class="fas fa-trash"></i>
                    Excluir
                </button>
            </div>
            <div class="card-item">
                <h3>Cartão 2</h3>
                <p>Número do Cartão: **** **** **** 5678</p>
                <button class="edit-button btn btn-primary">
                    <i class="fas fa-edit"></i>
                    Extrato
                </button>
                <button class="delete-button btn btn-danger">
                    <i class="fas fa-trash"></i>
                    Excluir
                </button>
            </div>
        </div>
    </div>
    </div>

</body>
</html>
