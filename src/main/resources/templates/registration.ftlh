<!DOCTYPE html>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h1>Регистрация</h1><hr>
<form action="/registration" method="post">
    Эл. почта: <input type="email" name="email"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Зарегистрироваться"/>
</form>

</body>
</html>