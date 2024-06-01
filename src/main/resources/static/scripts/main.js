document.getElementById('sendButton').addEventListener('click', function() {
    var tell1 = document.getElementById('tell1Area').value;
    var tell2 = document.getElementById('tell2Area').value;
    var tell3 = document.getElementById('tell3Area').value;

    var data = { 
        tell1: tell1,
        tell2: tell2,
        tell3: tell3 
    };

    var url = 'http://127.0.0.1:8080/nlp/sendToNlp'
    var result

    result = fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.ok) {
            console.log('Данные успешно отправлены!');
        } else {
            console.error('Ошибка при отправке данных.');
        }
        console.log(response.json().then((value) => {
            console.log(value.answer);
            document.getElementById('resultText').value = value.answer
          })
        )
    })
    .catch(error => {
        console.error('Произошла ошибка:', error);
    });
});

document.getElementById('endButton').addEventListener('click', function() {
    var fio = document.getElementById('fio').value;
    var childAge = document.getElementById('childAge').value;
    var parentAge = document.getElementById('parentAge').value;
    var telephone = document.getElementById('telephone').value;
    var address = document.getElementById('address').value;
    var result = document.getElementById('resultText').value;

    var data = {
        fio: fio,
        childAge: childAge,
        parentAge: parentAge,
        telephone: telephone,
        address: address,
        result: result
    };

    var url = 'http://127.0.0.1:8080/child/post'
    var result

    result = fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.ok) {
            console.log('Данные успешно отправлены!');
            window.location.href = "/psychologist";
        } else {
            console.error('Ошибка при отправке данных.');
        }
    })
    .catch(error => {
        console.error('Произошла ошибка:', error);
    });
});


