fetch('/api/products', {
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
    loadHTMLTABLE(data); // Обработка данных ответа
})
.catch(error => {
    console.error('There has been a problem with your fetch operation:', error);
});

function loadHTMLTABLE(data){
    let prod = document.getElementById("product-table");
    console.log(data);
    data.forEach(product => {
        prod.innerHTML += `
            <div class="product">
                <a href='/product_detail?slug=${product["slug"]}'>
                    <img src='${product["mainPhoto"]}' alt="Product">
                    <h3>${product["name"]}</h3>
                    <p class="price">${product["costPriceInRubles"]} ₽</p>
                </a>
            </div>
        `
    })
}