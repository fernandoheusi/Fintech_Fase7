<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Início</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: #7879F1;
            color: #fff;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .navbar-left {
            display: flex;
            align-items: center;
        }

        .navbar-left img {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            margin-right: 10px;
        }

        .navbar-left h3 {
            margin: 0;
            color: #fff;
            font-size: 1.2rem;
        }

        .navbar-right {
            display: flex;
            align-items: center;
        }

        .navbar-right a {
            color: #fff;
            text-decoration: none;
            margin-left: 20px;
            position: relative;
        }

        .navbar-right a .badge {
            position: absolute;
            top: -5px;
            right: -10px;
            background-color: red;
            color: #fff;
            padding: 3px 6px;
            border-radius: 50%;
            font-size: 12px;
        }

        .menu-icon {
            display: none;
            font-size: 24px;
            cursor: pointer;
        }

        .menu {
            display: none;
            position: absolute;
            top: 60px;
            right: 20px;
            background-color: #007bff;
            padding: 10px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            z-index: 1000;
        }

        .menu a {
            display: block;
            color: #fff;
            text-decoration: none;
            padding: 10px;
            border-bottom: 1px solid #0056b3;
        }

        .menu a:last-child {
            border-bottom: none;
        }

        .menu.show {
            display: block;
        }

        @media screen and (max-width: 768px) {
            .navbar {
                flex-direction: column;
                align-items: flex-start;
                padding: 10px;
            }

            .navbar-left,
            .navbar-right {
                margin-bottom: 10px;
            }

            .navbar-right {
                display: none;
                position: 10px;
            }

            .menu-icon {
                display: block;
                order: 1;
                margin-left: auto;
            }

            .menu {
                top: 50px;
                right: 10px;
            }

            .menu.show {
                display: block;
            }
        }
    </style>
</head>
<body>
    <div class="navbar">
        <div class="navbar-left">
            <img src="images/logo.png" alt="logo">
            <h3>Olá, Gabi</h3>
        </div>

        <div class="navbar-right">
            <a href="#">
                <span class="badge">3</span>
                <i class="bi bi-bell-fill"></i>
               
            </a>
        </div>

            <div class="navbar-right">
                <a href="#">
                    <i class="bi bi-person-circle"></i>
                </a>
            <a href="#">Configurações</a>
           
        </div>

        <div class="menu-icon">&#9776;</div>

        <div class="menu">
            <a href="#">Perfil</a>
            <a href="#">Configurações</a>
            <a href="#">Sair</a>
        </div>
    </div>	
    <script>
        // JavaScript para controlar o menu sanduíche
        document.querySelector('.menu-icon').addEventListener('click', function() {
            document.querySelector('.menu').classList.toggle('show');
        });
    </script>
</body>
</html>
