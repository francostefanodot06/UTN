// Limitamos a 151 para traer solo la primera generación
const URL_API = "https://pokeapi.co/api/v2/pokemon?limit=151"; 
const contenedor = document.getElementById("pokedex-container");

const obtenerPokemones = async () => {
    try {
        const response = await fetch(URL_API);
        const datos = await response.json();
        
        // Pasamos el array con los resultados a la función que los va a dibujar
        mostrarPokemones(datos.results);
    } catch (error) {
        console.error("Error al obtener la lista de Pokémon:", error);
    }
};

const mostrarPokemones = async (pokemones) => {
    // Usamos for...of para procesar las peticiones en orden
    for (const pokemon of pokemones) {
        try {
            // Hacemos fetch a la URL específica de cada Pokémon para traer sus imágenes y datos
            const res = await fetch(pokemon.url);
            const dataPokemon = await res.json();
            
            const card = document.createElement("div");
            card.classList.add("pokemon-card");
            
            // Extraer y formatear los tipos (ej: grass, poison)
            const tipos = dataPokemon.types.map(t => t.type.name).join(", ");
            
            // Usamos el artwork oficial si está disponible, o el sprite de baja resolución como fallback
            const imagen = dataPokemon.sprites.other['official-artwork'].front_default || dataPokemon.sprites.front_default;
            
            card.innerHTML = `
                <img src="${imagen}" alt="${dataPokemon.name}">
                <h2>#${dataPokemon.id} ${dataPokemon.name}</h2>
                <p><strong>Tipo:</strong> ${tipos}</p>
                <p><strong>Peso:</strong> ${dataPokemon.weight / 10} kg</p>
            `;
            
            contenedor.appendChild(card);
        } catch (error) {
            console.error(`Error cargando los detalles de ${pokemon.name}:`, error);
        }
    }
};

// Iniciar aplicación
obtenerPokemones();