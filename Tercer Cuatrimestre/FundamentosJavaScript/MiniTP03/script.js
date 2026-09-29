const URL_API = "https://thesimpsonsapi.com/api/characters";
const URL_IMAGENES = "https://cdn.thesimpsonsapi.com/500";
const contenedor = document.getElementById("personajes");

// Actividad 1: Función async que hace fetch a la API, convierte a JSON y muestra datos por consola
const obtenerPersonajes = async () => {
    try {
        // Pausar la ejecución hasta que la promesa del fetch se resuelva
        const response = await fetch(URL_API);
        
        // Convertir la respuesta a formato JSON[cite: 3]
        const datos = await response.json();
        
        // Mostrar por consola el array results para verificar que los datos llegan[cite: 3]
        console.log(datos.results);
        
        // Llamar a la función que renderiza las tarjetas pasándole el array de personajes[cite: 3]
        mostrarPersonajes(datos.results);
        
    } catch (error) {
        console.error("Hubo un error al obtener los personajes:", error);
    }
};

// Actividad 2: Crear una tarjeta por cada personaje en el DOM[cite: 3]
const mostrarPersonajes = (personajes) => {
    // Recorrer el array de personajes[cite: 3]
    personajes.forEach(personaje => {
        // Crear el elemento div para la tarjeta[cite: 3]
        const card = document.createElement("div");
        card.classList.add("personaje-card");

        // Armar el contenido interno concatenando la base del CDN con portrait_path para la imagen[cite: 3]
        // y agregando los datos: nombre, ocupación, status y edad[cite: 3].
        card.innerHTML = `
            <img src="${URL_IMAGENES}${personaje.portrait_path}" alt="Imagen de ${personaje.name}">
            <h2>${personaje.name}</h2>
            <p><strong>Ocupación:</strong> ${personaje.occupation}</p>
            <p><strong>Estado:</strong> ${personaje.status}</p>
            <p><strong>Edad:</strong> ${personaje.age}</p>
        `;

        // Agregar la tarjeta terminada al contenedor principal #personajes[cite: 3]
        contenedor.appendChild(card);
    });
};

// Iniciar el flujo de ejecución de la aplicación
obtenerPersonajes();