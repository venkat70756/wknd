console.log("pages naviagation js loaded");

document.addEventListener("DOMContentLoaded", function () {

    const dropdown = document.getElementById("pageDropdown");

    if (!dropdown) {
        return;
    }

    fetch("/bin/querytest")
        .then(function (response) {
            if (!response.ok) {
                throw new Error("Failed to fetch pages");
            }

            return response.json();
        })
        .then(function (pages) {

            pages.forEach(function (page) {

                const option = document.createElement("option");

                option.textContent = page.pageTitle;
                option.value = page.pagePath;

                dropdown.appendChild(option);
            });
        })
        .catch(function (error) {
            console.error("Error loading pages:", error);
        });

    dropdown.addEventListener("change", function () {

        const pagePath = this.value;

        if (pagePath) {
            window.location.href = pagePath + ".html";
        }
    });
});
