<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Список пользователей</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
    body {
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
    }

    .container {
        display: flex;
        flex-direction: column;
        height: 100vh;
        align-items: center;
        justify-content: center;
    }

    .right-panel {
        width: 100%;
        padding: 20px;
        box-sizing: border-box;
        overflow-y: auto;
    }

    .user-dropdown {
        position: relative;
        display: inline-block;
    }
    .user-dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
        z-index: 1;
    }
    .user-dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }
    .user-dropdown-content a:hover {
        background-color: #f1f1f1;
    }
    .user-dropdown:hover .user-dropdown-content {
        display: block;
    }

    .input-section {
        width: 50%;
        height: 200px;
        display: flex;
        flex-direction: column;
        align-items: center;
        background-color: #f5f5f5;
        border: none;
        margin: auto;
    }

    .input-row {
        display: flex;
        margin-bottom: 10px;
    }

    .input-row label {
        display: inline-block;
        width: 80px;
        text-align: right;
        margin-right: 10px;
        line-height: 40px;
    }

    .input-row input[type="text"] {
        vertical-align: middle;
    }

    .input-textarea {
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
        background-color: #0026ff;
        border: 2px solid #0026ff;
    }
</style>
</head>
<body>
    <header class="d-flex justify-content-center py-3">
        <ul class="nav nav-pills">
          <li class="nav-item"><a href="/parent-schedule" class="nav-link active" aria-current="page">Записаться на приём</a></li>
          <li class="nav-item"><a href="/info" class="nav-link">Информация</a></li>
        </ul>
    </header>
    <div class="col-xxl-8 my-3 mx-3">
        <button class="btn btn-light rounded-pill px-1 col-xxl-1" id="psyBackBtn" type="button" onclick="location.href='/parent'">Назад</button>
    </div>
    <div class="container">
        <div class="right-panel">
            <div class="input-section">
                <div class="user-dropdown">
                    <input type="text" id="selectedUser" readonly placeholder="Выберите психолога">
                    <div class="user-dropdown-content" id="userDropdown">
                    </div>
                </div>
            </div>
            <div class="input-section">
                <div class="input-row">
                    <label>День:</label>
                    <input class="input-textarea" id="dayInput">
                    <label>Месяц:</label>
                    <input class="input-textarea" id="monthInput">
                    <label>Год:</label>
                    <input class="input-textarea" id="yearInput">
                </div>
                <div class="input-row">
                    <label>Часы:</label>
                    <input class="input-textarea" id="hourInput">
                    <label>Минуты:</label>
                    <input class="input-textarea" id="minuteInput">
                </div>
                <button class="submit-button" type="submit" id="sendBtn">Записаться</button>
            </div>
        </div>
    </div>
    <script src="scripts/parent-schedule.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>