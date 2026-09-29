// Actividad 2: Cargar tareas guardadas (o array vacío si no hay nada) usando JSON.parse
let todos = JSON.parse(localStorage.getItem("todos")) || [];

// Función para guardar el estado en cada cambio usando JSON.stringify[cite: 2]
const guardarTodos = () => {
    localStorage.setItem("todos", JSON.stringify(todos));
};

const form = document.getElementById("todo-form");
const input = document.getElementById("todo-input");
const lista = document.getElementById("todo-list");

// Función que limpia la <ul> y recrea los <li> basándose siempre en el estado (array)[cite: 2]
const renderTodos = () => {
    lista.innerHTML = ""; // Limpiar <ul>

    todos.forEach(tarea => {
        // Crear elemento de lista con document.createElement[cite: 2]
        const li = document.createElement("li");

        // Crear contenedor para el texto de la tarea
        const textoSpan = document.createElement("span");
        textoSpan.textContent = tarea.texto;
        textoSpan.style.cursor = "pointer"; 

        // Si la tarea está completada, la tachamos[cite: 2]
        if (tarea.completada) {
            textoSpan.style.textDecoration = "line-through";
        }

        // Click en el texto para tachar/destachar[cite: 2]
        textoSpan.addEventListener("click", () => toggleTodo(tarea.id));

        // Botón Eliminar[cite: 2]
        const btnEliminar = document.createElement("button");
        btnEliminar.textContent = "Eliminar";
        btnEliminar.style.marginLeft = "10px";
        btnEliminar.addEventListener("click", () => eliminarTodo(tarea.id));

        // Armar el <li> y agregarlo a la <ul>
        li.appendChild(textoSpan);
        li.appendChild(btnEliminar);
        lista.appendChild(li);
    });
};

// Actividad 1: Agregar una tarea al array
const agregarTodo = (texto) => {
    const nuevaTarea = {
        id: Date.now(), // Generamos un ID único usando la fecha actual
        texto: texto,
        completada: false
    };
    
    todos.push(nuevaTarea);
    guardarTodos();
    renderTodos(); // Re-renderizar después de modificar el estado[cite: 2]
};

// Eliminar tarea filtrando el array por ID
const eliminarTodo = (id) => {
    todos = todos.filter(tarea => tarea.id !== id);
    guardarTodos();
    renderTodos();
};

// Marcar/Desmarcar tarea como completada
const toggleTodo = (id) => {
    const tareaEncontrada = todos.find(tarea => tarea.id === id);
    if (tareaEncontrada) {
        tareaEncontrada.completada = !tareaEncontrada.completada; // Invierte el estado
        guardarTodos();
        renderTodos();
    }
};

// Escuchar el evento submit del formulario
form.addEventListener("submit", (evento) => {
    evento.preventDefault(); // Evitar el recargado por defecto del formulario[cite: 2]
    
    const texto = input.value.trim();
    if (texto !== "") {
        agregarTodo(texto);
        input.value = ""; // Limpiar el input
    }
});

// Renderizar la lista inicialmente al cargar la página
renderTodos();