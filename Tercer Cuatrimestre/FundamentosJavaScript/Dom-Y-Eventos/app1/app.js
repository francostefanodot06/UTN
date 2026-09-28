const input = document.getElementById("inputTarea");
const boton = document.querySelector("#btnAgregar");
const lista = document.querySelector("#lista");


boton.addEventListener("click", () => {
  const valor = input.value;
  
  // Validación básica
  if (valor === "") return;

  // Crear elemento
  const li = document.createElement("li");
  li.textContent = valor;

  // Agregar a la lista
  lista.appendChild(li);

  // Limpiar el input
  input.value = "";
});