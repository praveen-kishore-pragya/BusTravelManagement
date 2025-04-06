document.addEventListener("DOMContentLoaded", function () {

    // navbarLoader.js
    fetch("navbar.html")
        .then(res => res.text())
        .then(data => {
          document.getElementById("navbar-container").innerHTML = data;

          // Handle Dashboard Redirect Logic
          const dashboardLink = document.getElementById("dashboard-link");
          if (dashboardLink) {
            dashboardLink.addEventListener("click", (e) => {
              const user = localStorage.getItem("loggedInUser");
              if (!user) {
                e.preventDefault();
                window.location.href = "signup.html";
              }
            });
          }
        });




});
