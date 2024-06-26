document.getElementById('benderform').addEventListener('submit', submitForm);


function submitForm(event) {
    // Отменяем стандартное поведение браузера с отправкой формы
    event.preventDefault();

    // event.target — это HTML-элемент form
    let formData = new FormData(event.target);

    // Собираем данные формы в объект
    let obj = {};
    formData.forEach((value, key) => obj[key] = value);

    // Собираем запрос к серверу
    let request = new Request(event.target.action, {
        method: 'POST',
        body: JSON.stringify(obj),
        headers: {
            'Content-Type': 'application/json',
        },
    });

    // Отправляем (асинхронно!)
    fetch(request).then(
        function(response) {
            window.location.href="/home";
        },
        function(error) {
            // Запрос не получилось отправить
            console.error(error);
        }
    );

    // Код после fetch выполнится ПЕРЕД получением ответа
    // на запрос, потому что запрос выполняется асинхронно,
    // отдельно от основного кода
    console.log('Запрос отправляется');
}