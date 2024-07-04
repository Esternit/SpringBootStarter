let currentSlide = 0;
let param = new URLSearchParams(window.location.search);

const slug = param.get('slug');
const api1 = `http://localhost:8080/api/products/${slug}`;
const api2 = `http://localhost:8080/api/products/images/${slug}`;

Promise.all([
  fetch(api1, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  }),
  fetch(api2, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  })
])
  .then(responses => {
    // Проверяем, что оба запроса завершились успешно
    responses.forEach(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok ' + response.statusText);
      }
    });
    // Преобразуем результаты в JSON
    return Promise.all(responses.map(response => response.json()));
  })
  .then(data => {
    // Обработка данных из обоих API
    const [dataFromApi1, dataFromApi2] = data;

    // Здесь можно вызвать функции для обработки данных
    loadHTMLTABLE(dataFromApi1, dataFromApi2);
  })
  .catch(error => {
    console.error('There has been a problem with your fetch operation:', error);
  });


function showSlide(index) {
  const slides = document.querySelectorAll('.carousel-item');
  slides.forEach((slide, i) => {
    slide.classList.remove('active');
    if (i === index) {
      slide.classList.add('active');
    }
  });
}

function nextSlide() {
  const slides = document.querySelectorAll('.carousel-item');
  currentSlide = (currentSlide + 1) % slides.length;
  showSlide(currentSlide);
}

function prevSlide() {
  const slides = document.querySelectorAll('.carousel-item');
  currentSlide = (currentSlide - 1 + slides.length) % slides.length;
  showSlide(currentSlide);
}

document.addEventListener('DOMContentLoaded', () => {
  showSlide(currentSlide);
});

function infoLoader(){
    let param = new URLSearchParams(window.location.search);
    fetch('/api/products/' + param.get('slug'), {
        method: 'GET', // Или 'POST', 'PUT', 'DELETE', в зависимости от типа запроса
        headers: {
            'Content-Type': 'application/json',
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
}

function loadHTMLTABLE(data1, data2){
  console.log(data1, data2);
    data=data1[0];
    let tempHTML = `<img src="${data["mainPhoto"]}" alt="Product Image 1" class="carousel-item active">`;
    for (let i = 1; i < data2.length; i++) {
        tempHTML += `<img src="${data2[i]["url"]}" alt="Product Image ${i + 1}" class="carousel-item">
        `;
    }
    let prod = document.getElementById("product-page");
    prod.innerHTML = `
            <div class="carousel">
        <div class="carousel-inner">
            ${tempHTML}
        </div>
        <button class="carousel-control prev" onclick="prevSlide()">&#10094;</button>
        <button class="carousel-control next" onclick="nextSlide()">&#10095;</button>
    </div>
    <div class="product-details">
        <h1 class="product-name">${data["name"]}</h1>
        <p class="product-price">${data["costPriceInRubles"]} ₽</p>
        <p class="product-description">${data["description"]}</p>
    </div>
    `
}

