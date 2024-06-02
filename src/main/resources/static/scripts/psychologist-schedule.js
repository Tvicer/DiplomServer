var url = 'http://127.0.0.1:8080/schedule/get';
const columnMappings = {
    "parentFio": "ФИО родителя",
    "parentEmail": "Email родителя",
    "dateTime": "Дата и время"
};

fetch(url)
  .then(response => response.json())
  .then(data => {

    const table = document.createElement('table');
    table.style.width = '80%';
    table.style.margin = '0 auto';
    table.style.borderCollapse = 'collapse';
    table.style.border = '1px solid black';

    const headers = Object.keys(data[0]).filter(header => header !== 'id' && header !== 'psychologistEmail');
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
            const text = document.createTextNode(obj[header]);
            cell.appendChild(text);
            cell.style.padding = '10px';
            cell.style.textAlign = 'center';
            cell.style.border = '1px solid black';
        });
    });

    document.body.appendChild(table);
  })
  .catch(error => console.error('Ошибка при выполнении GET-запроса:', error));