document.getElementById('сhildsBtn').addEventListener('click', function() {
    var childsText = document.getElementById('childsText')

    var url = 'http://127.0.0.1:8080/child/get'
    var result

    result = fetch(url)
    .then(response => {
            if (response.ok) {
                console.log('Данные успешно отправлены!');
            } else {
                console.error('Ошибка при отправке данных.');
            }
            console.log(response.json().then((value) => {
                console.log(value);
                childsText.value = JSON.stringify(value, null, 2);
              })
            )
        })
    .catch(error => {
        console.error('Произошла ошибка:', error);
    });
});
