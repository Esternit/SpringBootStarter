let currentSlide = 0;

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
}