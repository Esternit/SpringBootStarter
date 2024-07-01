fetch('/api/runs', {
    method: 'GET', // Или 'POST', 'PUT', 'DELETE', в зависимости от типа запроса
    headers: {
        'Content-Type': 'application/json',
        // Добавьте другие заголовки, если необходимо, например, авторизационный токен
        'Authorization': 'Bearer your-token-here'
    }
})
.then(response => {
    if (!response.ok) {
        throw new Error('Network response was not ok ' + response.statusText);
    }
    return response.json();
})
.then(data => {
    console.log(data); // Обработка данных ответа
})
.catch(error => {
    console.error('There has been a problem with your fetch operation:', error);
});