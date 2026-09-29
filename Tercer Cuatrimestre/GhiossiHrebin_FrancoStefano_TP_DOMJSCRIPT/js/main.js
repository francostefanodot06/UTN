// A. Renderizar Categorías
function cargarCategorias() {
    const contenedorCategorias = document.getElementById("lista-categorias");
    
    categorias.forEach(categoria => {
        const li = document.createElement("li");
        li.innerHTML = `<a href="#">${categoria}</a>`;
        contenedorCategorias.appendChild(li);
    });
}

// B. Renderizar Productos
function cargarProductos() {
    const contenedorProductos = document.getElementById("contenedor-productos");
    
    productos.forEach(producto => {
        const article = document.createElement("article");
        // Puedes agregar la clase CSS que usaste en tu TP anterior
        article.classList.add("producto-card"); 
        
        article.innerHTML = `
            <img src="${producto.imagen}" alt="${producto.nombre}">
            <h3>${producto.nombre}</h3>
            <p>${producto.descripcion}</p>
            <p class="precio">$${producto.precio}</p>
            <button onclick="alert('Agregaste el producto: ${producto.nombre}')">Agregar</button>
        `;
        
        contenedorProductos.appendChild(article);
    });
}

// Ejecutar las funciones para que se muestren en pantalla
cargarCategorias();
cargarProductos();