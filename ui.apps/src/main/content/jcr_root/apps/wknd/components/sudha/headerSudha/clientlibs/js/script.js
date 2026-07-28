document.addEventListener("DOMContentLoaded", () => {
    fetch("/bin/yl/query")
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch data");
            }
            return response.json();
        })
        .then(data => {
            const container = document.getElementById("page-list");

            let html = "<ul>";

            data.forEach(page => {
                html += `
                    <li>
                    <a href="${page.pagePath}.html">  <strong>${page.pageTitle}</strong></a><br>
                       

                    </li>
                `;
            });

            html += "</ul>";

            container.innerHTML = html;
        })
        .catch(error => {
            console.error("Error:", error);
        });
});