form.addEventListener("submit", function (event) {
  event.preventDefault();

  const weight = parseFloat(document.getElementById("weight").value);
  const heightInCentimeters = parseFloat(document.getElementById("height").value);
  const value = document.getElementById("value");
  const description = document.getElementById("description");

  value.classList.remove(
      "underweight",
      "normal",
      "overweight",
      "obesity",
      "severe-obesity",
      "morbid-obesity"
  );
  description.classList.remove(
      "underweight",
      "normal",
      "overweight",
      "obesity",
      "severe-obesity",
      "morbid-obesity"
  );

  fetch("http://localhost:8080/api/calcular", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      alturaCm: heightInCentimeters,
      pesoKg: weight,
    }),
  })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok: " + response.statusText);
        }
        return response.json();
      })
      .then((data) => {

        console.log(data);
        value.textContent = data.imc.toFixed(2);
        description.textContent = data.message;

        value.classList.add(data.classification);
        description.classList.add(data.classification);
      })
      .catch((error) => {
        console.error("Error:", error);
      });
});

form.addEventListener("keypress", function (event) {
  if (event.key === "Enter") {
    document.getElementById("calculate").click();
  }
});