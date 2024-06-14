<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!doctype html>
<html lang="pt-BR">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Fintech</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=PT+Sans:ital,wght@1,700&family=Poppins&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/stylesheet.css">
  </head>
  <body>

      <div class="container-fluid text-center" id="header">
        <h1 id="title">Fintech</h1>
      </div>
    
      <div id="cards">

        <div class="card-income-outcome">
          <p class="card-title">
            Entradas
            <img src="./images/Entradas.png" alt="Entradas" class="card-images">
          </p>
          <p class="card-value">R$ 5.200,00</p>
        </div>
        
        <div class="card-income-outcome">
          <p class="card-title">
            Gastos
            <img src="./images/Saidas.png" alt="Saidas" class="card-images">
          </p>
          <p class="card-value">R$ 5.200,00</p>
        </div>
      </div>
      <% int n = 14; %>
      <%for (int x = 0; x < n; x++){ %>
      
      	<li><%= x %></li>
      	
      <%} %>
      
      
      <div class="container" id="list"tor>
				<div id="button-div">
          <button type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">
						<p>Cadastrar nova movimentacao</p>
					</button>
				</div>

        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-body">
                <form >
                  <div>
                    <input class="text-input" placeholder="nome da movimentacao" type="text" id="nome-movimentacao"/>
                    <input class="text-input" placeholder="valor da movimentacao" type="number" id="valor-movimentacao" />
                  </div>
      
                  <div>
                    <input type="radio" id="despesa" name="despesaOuReceita" value="despesa">
                    <label for="despesa">Despesa</label>
                    <input type="radio" id="receita" name="despesaOuReceita" value="receita">
                    <label for="receita">Receita</label>
                  </div>
      
                  <input type="submit" value="Cadastrar Movimentacao" data-bs-dismiss="modal">
                </form>
              </div>
            </div>
          </div>
        </div>

        <div class="list-item">
          <div class="icon-plus-description">
            <img src="./images/food.png" alt="Saidas" class="card-images">
            <div class="description">
              <p class="item-type">Comida</p>
              <p class="item-description">Lanchonete do Zé</p>
            </div>
          </div>
          <p class="value-outcome">-R$40,00</p>
        </div>
        
        <div class="list-item">
          <div class="icon-plus-description">
            <img src="./images/cinema.png" alt="Saidas" class="card-images">
            <div class="description">
              <p class="item-type">Comida</p>
              <p class="item-description">Lanchonete do Zé</p>
            </div>
          </div>
          <p class="value-outcome">-R$40,00</p>
        </div>

        <div class="list-item">
          <div class="icon-plus-description">
            <img src="./images/food.png" alt="Saidas" class="card-images">
            <div class="description">
              <p class="item-type">Comida</p>
              <p class="item-description">Lanchonete do Zé</p>
            </div>
          </div>
          <p class="value-outcome">-R$40,00</p>
        </div>

        <div class="list-item">
          <div class="icon-plus-description">
            <img src="./images/market.png" alt="Saidas" class="card-images">
            <div class="description">
              <p class="item-type">Comida</p>
              <p class="item-description">Lanchonete do Zé</p>
            </div>
          </div>
          <p class="value-outcome">-R$40,00</p>
        </div>

        <div class="list-item">
          <div class="icon-plus-description">
            <img src="./images/studies.png" alt="Saidas" class="card-images">
            <div class="description">
              <p class="item-type">Comida</p>
              <p class="item-description">Lanchonete do Zé</p>
            </div>
          </div>
          <p class="value-outcome">-R$40,00</p>
        </div>

        <div class="list-item">
          <div class="icon-plus-description">
            <img src="./images/money.png" alt="Saidas" class="card-images">
            <div class="description">
              <p class="item-type">Comida</p>
              <p class="item-description">Lanchonete do Zé</p>
            </div>
          </div>
          <p class="value-income">-R$40,00</p>
        </div>
      </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>