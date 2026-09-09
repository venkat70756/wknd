(function () {
    "use strict";

    document.addEventListener("DOMContentLoaded", function () {

        const dropdown = document.getElementById("pageSelector");
        const loading = document.getElementById("pageSelectorLoading");
        const errorMessage = document.getElementById("pageSelectorError");

        if (!dropdown) {
            return;
        }

        const servletUrl = "/bin/avinashquery";

        function loadPages() {

            fetch(servletUrl, {
                method: "GET",
                headers: {
                    "Accept": "application/json"
                }
            })
                .then(function (response) {

                    if (!response.ok) {
                        throw new Error(
                            "Servlet returned HTTP " + response.status
                        );
                    }

                    return response.json();
                })
                .then(function (pages) {

                    loading.style.display = "none";

                    if (!Array.isArray(pages) || pages.length === 0) {
                        errorMessage.textContent = "No pages found.";
                        return;
                    }

                    pages.forEach(function (page) {

                        if (!page.pageTitle || !page.pagePath) {
                            return;
                        }

                        const option = document.createElement("option");

                        option.textContent = page.pageTitle;
                        option.value = page.pagePath;

                        dropdown.appendChild(option);
                    });
                })
                .catch(function (error) {

                    console.error("Error loading pages:", error);

                    loading.style.display = "none";

                    errorMessage.textContent =
                        "Unable to load pages. Please try again.";
                });
        }

        dropdown.addEventListener("change", function () {

            const selectedPath = this.value;

            if (!selectedPath) {
                return;
            }

            // Redirect to the selected AEM page
            window.location.href = selectedPath + ".html";
        });

        loadPages();
    });

})();
