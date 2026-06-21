document.addEventListener("DOMContentLoaded", function () {

    const employeeContainer = document.getElementById("employee-list");

    fetch("/bin/employee")
        .then(response => response.json())
        .then(result => {

            employeeContainer.innerHTML = "";

            if (result.status === "success" && result.data) {

                result.data.forEach(employee => {

                    const card = document.createElement("div");
                    card.className = "employee-card";

                    card.innerHTML = `
                        <div class="employee-avatar">
                            ${employee.employee_name.charAt(0)}
                        </div>

                        <div class="employee-info">
                            <h3>${employee.employee_name}</h3>

                            <p>
                                <strong>ID:</strong>
                                ${employee.id}
                            </p>

                            <p>
                                <strong>Age:</strong>
                                ${employee.employee_age}
                            </p>

                            <p>
                                <strong>Salary:</strong>
                                ₹${Number(employee.employee_salary).toLocaleString()}
                            </p>
                        </div>
                    `;

                    employeeContainer.appendChild(card);
                });
            }
        })
        .catch(error => {

            console.error(error);

            employeeContainer.innerHTML = `
                <div class="error">
                    Unable to load employee data.
                </div>
            `;
        });
});