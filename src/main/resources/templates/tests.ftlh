<!DOCTYPE HTML>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Главное меню психолога</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <style type="text/css">
    .choise button {
      padding: 15px 30px;
      background-color: #0d6dfd; 
      color: white;
      border: 2px solid #0d6dfd;
      border-radius: 30px;
      cursor: pointer;
      margin: 0 auto;
      width: 300px;
      height: 200px;
    }

    .choise button:hover {
      padding: 15px 30px;
      background-color: #0026ff; 
      color: white;
      border: 2px solid #0026ff;
      border-radius: 30px;
      cursor: pointer;
      margin: 0 auto;
    }
  </style>
 </head>
 <body>
    <header class="d-flex justify-content-center py-3">
        <ul class="nav nav-pills">
          <li class="nav-item"><a href="tests" class="nav-link active" aria-current="page">Провести тестирование</a></li>
          <li class="nav-item"><a href="psychologist-schedule" class="nav-link">Расписание</a></li>
          <li class="nav-item"><a href="childs" class="nav-link">Все дети</a></li>
        </ul>
      </header>
    <div class="col-xxl-8 my-3 mx-3">
        <button class="btn btn-light rounded-pill px-1 col-xxl-1" id="psyBackBtn" type="button" onclick="location.href='/psychologist'">Назад</button>
    </div>
    <div class="choise" style="text-align: center; margin-top: 10%;">
      <button style="margin-right: 100px;" onclick="location.href='/test1'">
        <h5>Определить уровень развития по нарративу</h5>
      </button>

      <button>
        <h5>Тест №2<br>(в разработке)</h5>
      </button>

        <button style="margin-left: 100px;">
          <h5>Тест №3<br>(в разработке)</h5>
        </button>
    </div>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
 </body>
</html>