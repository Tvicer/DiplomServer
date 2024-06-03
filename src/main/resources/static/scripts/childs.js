var childsText = document.getElementById('childsText')

var url = 'http://127.0.0.1:8080/child/get'

const columnMappings = {
    "fio": "ФИО",
    "childAge": "Возраст ребёнка",
    "parentFio": "ФИО родителя",
    "parentAge": "Возраст родителя",
    "telephone": "Номер телефона",
    "address": "Адрес",
    "psychologist": "Email психолога",
    "groupNumber": "Номер группы",
    "goodGroup": "Подходит для данный группы",
    "result": "Итоговый балл"
};

const goodGroupValues = {
    true: "Да",
    false: "Нет"
};

fetch(url)
  .then(response => response.json())
  .then(data => {

    const table = document.createElement('table');
    table.style.width = '80%';
    table.style.margin = '0 auto';
    table.style.borderCollapse = 'collapse';

    const headers = Object.keys(data[0]);
    const headerRow = table.insertRow();
    headers.forEach(headerText => {
        const header = document.createElement('th');
        const newText = columnMappings[headerText] || headerText;
        const textNode = document.createTextNode(newText);
        header.appendChild(textNode);
        header.style.padding = '10px';
        header.style.textAlign = 'center';
        header.style.border = '1px solid black';
        headerRow.appendChild(header);
    });

    data.forEach(obj => {
        const row = table.insertRow();
        headers.forEach(header => {
            const cell = row.insertCell();
            const text = header === 'goodGroup' ? document.createTextNode(goodGroupValues[obj[header]]) : document.createTextNode(obj[header]);
            cell.appendChild(text);
            cell.style.padding = '10px';
            cell.style.textAlign = 'center';
            cell.style.border = '1px solid black';
        });
    });

    table.style.border = '1px solid black';
    table.style.borderCollapse = 'collapse';

    document.body.appendChild(table);
  })
  .catch(error => console.error('Ошибка при выполнении GET-запроса:', error));