// A. Renderizar Categorías
const cargarCategorias = () => {
    const contenedorCategorias = document.getElementById("lista-categorias");
    
    categorias.forEach(categoria => {
        const li = document.createElement("li");
        li.innerHTML = `<a href="#">${categoria}</a>`;
        contenedorCategorias.appendChild(li);
    });
};

// B. Renderizar Productos
const cargarProductos = () => {
    const contenedorProductos = document.getElementById("contenedor-productos");
    
    productos.forEach(producto => {
        const article = document.createElement("article");
        
        article.innerHTML = `
            <img src="${producto.imagen}" alt="${producto.nombre}" width="150">
            <h3>${producto.nombre}</h3>
            <p>${producto.descripcion}</p>
            <p>Precio: <strong>$${producto.precio.toFixed(2)}</strong></p>
            <a href="#">Ver Detalles</a>
            <button type="button" onclick="alert('Agregaste el producto: ${producto.nombre}')">Agregar al Carrito</button>
        `;
        
        contenedorProductos.appendChild(article);
    });
};

// Ejecutar las funciones para que se muestren en pantalla
cargarCategorias();
cargarProductos();