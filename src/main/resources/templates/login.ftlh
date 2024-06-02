<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Авторизация</title>
    <style>
    body {
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
    }

    .container {
        display: flex;
        height: 100vh;
        margin-top: 10%;
    }

    .right-panel {
        width: 100%;
        padding-top: 20px;
        padding-left: 15%;
        padding-right: 15%;
        padding-bottom: 20px;
        box-sizing: border-box;
        overflow-y: auto;
    }

    .input-section {
        display: flex;
        flex-direction: column;
        align-items: center;
        background-color: #f5f5f5;
        height: 300px;
        border: none;
        margin-bottom: 15%;
    }

    .input-section .input-textarea {
        width: 30%;
        padding: 10px;
        border: 2px solid black;
        border-radius: 15px;
        box-sizing: border-box;
        font-size: 17px;
    }
    .submit-button {
        padding: 15px 30px;
        background-color: #0d6dfd;
        color: white;
        border: 2px solid #0d6dfd;
        border-radius: 5px;
        cursor: pointer;
        display: block;
        margin: 0 auto;
    }

    .submit-button:hover {
        padding: 15px 30px;
        background-color: #0026ff;
        color: white;
        border: 2px solid #0026ff;
        border-radius: 5px;
        cursor: pointer;
        display: block;
        margin: 0 auto;
    }
    </style>
    <#import "/spring.ftl" as spring/>
</head>
<body>
    <div class="container">
        <div class="right-panel">
            <h1 style="text-align: center;">Авторизация</h1>
            <form class="input-section" action="/login" method="post">
                Эл. почта: <input class="input-textarea" type="email" name="username"><br><br>
                Пароль: <input class="input-textarea" type="password" name="password"><br><br>
                <button class="submit-button" type="submit">Войти</button><br>
                <a href="/registration">Зарегистрироваться</a>
            </form>
        </div>
    </div>
</body>
</html>