(function () {
    "use strict";

    const carousels = document.querySelectorAll(".custom-carousel");

    carousels.forEach(function (carousel) {

        const track = carousel.querySelector("[data-carousel-track]");
        const slides = carousel.querySelectorAll(".custom-carousel__slide");
        const prevButton = carousel.querySelector("[data-carousel-prev]");
        const nextButton = carousel.querySelector("[data-carousel-next]");
        const dotsContainer = carousel.querySelector("[data-carousel-dots]");

        if (!track || slides.length === 0) {
            return;
        }

        let currentIndex = 0;

        // Create dots
        slides.forEach(function (slide, index) {

            const dot = document.createElement("button");

            dot.type = "button";
            dot.className = "custom-carousel__dot";

            dot.setAttribute(
                "aria-label",
                "Go to slide " + (index + 1)
            );

            dot.addEventListener("click", function () {
                goToSlide(index);
            });

            dotsContainer.appendChild(dot);
        });

        const dots = dotsContainer.querySelectorAll(
            ".custom-carousel__dot"
        );

        function goToSlide(index) {

            if (index < 0) {
                index = slides.length - 1;
            }

            if (index >= slides.length) {
                index = 0;
            }

            currentIndex = index;

            track.style.transform =
                "translateX(-" + (currentIndex * 100) + "%)";

            dots.forEach(function (dot, dotIndex) {

                dot.classList.toggle(
                    "custom-carousel__dot--active",
                    dotIndex === currentIndex
                );

            });
        }

        prevButton.addEventListener("click", function () {
            goToSlide(currentIndex - 1);
        });

        nextButton.addEventListener("click", function () {
            goToSlide(currentIndex + 1);
        });

        // Initialize
        goToSlide(0);

    });

})();