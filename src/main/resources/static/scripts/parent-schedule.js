var getUrl = 'http://127.0.0.1:8080/user/get'
var postUrl = 'http://127.0.0.1:8080/schedule/post'

var psychologistEmail = null

postData = {
    psychologistEmail: null,
    day: null,
    month: null,
    year: null,
    hour: null,
    minute: null
};

function fetchUsers() {
    fetch(getUrl)
        .then(response => response.json())
        .then(data => {
            const userDropdown = document.getElementById('userDropdown');
            const selectedUserField = document.getElementById('selectedUser');

            data.forEach(user => {
                const userLink = document.createElement('a');
                userLink.textContent = user.fio + '\n' + user.email;
                userLink.addEventListener('click', () => {
                    selectedUserField.value = user.fio;
                    userDropdown.style.display = 'none';

                    psychologistEmail = user.email

                });

                userDropdown.appendChild(userLink);
            });

            selectedUserField.addEventListener('click', () => {
                userDropdown.style.display = 'block';
            });
        })
        .catch(error => {
            console.error('Ошибка загрузки пользователей:', error);
        });
}

fetchUsers();

document.getElementById('sendBtn').addEventListener('click', function() {
    const day = document.getElementById('dayInput').value;
    const month = document.getElementById('monthInput').value;
    const year = document.getElementById('yearInput').value;
    const minute = document.getElementById('minuteInput').value;
    const hour = document.getElementById('hourInput').value;

    postData = {
        psychologistEmail: psychologistEmail,
        day: day,
        month: month,
        year: year,
        hour: hour,
        minute: minute
    };

    fetch(postUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
            body: JSON.stringify(postData)
        })
        .then(response => {
            console.log('POST запрос отправлен успешно');
            window.location.href = "/parent";
        })
        .catch(error => {
            console.error('Ошибка при отправке POST запроса:', error);
        });
});