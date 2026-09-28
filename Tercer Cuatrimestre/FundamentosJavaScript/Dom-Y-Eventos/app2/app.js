/* Formulario */
const form = document.querySelector("#formTarea");
const inputTitulo = document.querySelector("#inputTitulo");
const inputDescripcion = document.querySelector("#inputDescripcion");
const lista = document.querySelector("#lista");



// Evento desde el FORM (clave)
form.addEventListener("submit", (e) => {
  e.preventDefault(); // evita recargar la página

  const titulo = inputTitulo.value.trim();
  const descripcion = inputDescripcion.value.trim();

  if (!titulo || !descripcion) {
    alert("Titulo o descripcion no tiene un valor")
    return
  };

  // Crear elementos
  const li = document.createElement("li");

  const span = document.createElement("span");
  span.textContent = `${titulo} - ${descripcion}`;

  const btnEliminar = document.createElement("button");
  btnEliminar.textContent = "Eliminar";

  // Evento eliminar (por elemento)
  btnEliminar.addEventListener("click", () => {
    li.remove();
  });

  // Armar estructura
  li.appendChild(span);
  li.appendChild(btnEliminar);

  // Agregar a la lista
  lista.appendChild(li);

  // Limpiar inputs
  form.reset();
});

