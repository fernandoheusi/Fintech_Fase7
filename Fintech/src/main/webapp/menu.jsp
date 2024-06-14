<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EasyBank</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="css/menustyles.css" />
</head>
<body>
<%@include file="navbar.jsp"%>
    <div class="container">
        <div class="header">
            <h1>AgÃªncia ${conta.agencia} - Conta ${conta.conta}</h1>
        </div>
        <div class="balance">
            <h2>Saldo disponÃ­vel</h2>
            <p>R$ ${conta.saldo}</p>
        </div>
        <div class="buttons">
            <a href="home?conta=${conta.conta} }"><div class="button"><i class="bi bi-text-left"></i> Extratos</div></a>
            <div class="button"><i class="bi bi-graph-up-arrow"></i> Investimentos</div>
            <div class="button"><i class="bi bi-people-fill"></i> Fale com Luna</div>
            <div class="button"><i class="bi bi-upc-scan"></i> Boletos</div>
            <div class="button"><i class="bi bi-gift-fill"></i> + BenefÃ­cios</div>
            <div class="button"><i class="bi bi-person-fill-up"></i> Programa de Fidelidade</div>
            <div class="button"><i class="bi bi-currency-dollar"></i> Limites de crÃ©dito</div>
            <div class="button"><i class="bi bi-currency-exchange"></i> EmprÃ©stimos</div>
        </div>
    </div>
</body>
</html>
