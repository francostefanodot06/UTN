// Array de categorías
const categorias = ["Hamburguesas", "Pizzas", "Papas Fritas", "Bebidas"];

// Array de objetos para los productos (mínimo 4)
const productos = [
  {
    id: 1,
    nombre: "Hamburguesa Triple",
    descripcion: "Hamburguesa triple smash con mucho cheddar.",
    precio: 25000,
    imagen: "assets/hamburguesa.avif",
    categoria: "Hamburguesas"
  },
  {
    id: 2,
    nombre: "Pizza Muzzarella",
    descripcion: "Salsa de tomate casera y muzzarella abundante.",
    precio: 18000,
    imagen: "assets/pizza.jpg",
    categoria: "Pizzas"
  },
  {
    id: 3,
    nombre: "Papas Cheddar",
    descripcion: "Papas fritas con abundante cheddar y verdeo",
    precio: 8500,
    imagen: "assets/fritas.jpeg", 
    categoria: "Papas Fritas"
  },
  {
    id: 4,
    nombre: "Gaseosa Cola",
    descripcion: "Lata de 354ml bien fría",
    precio: 2500,
    imagen: "assets/coca.webp", // Asegurate de tener una imagen guardada con este nombre en tu carpeta assets
    categoria: "Bebidas"
  }
];