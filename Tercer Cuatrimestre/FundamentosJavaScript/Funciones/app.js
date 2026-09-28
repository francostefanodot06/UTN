function saludar() {
    console.log("¡Hola mundo!");
}

saludar(); // Invoca la función

// Definición de la función
function calcularArea(ancho, alto) {
    const area = ancho * alto;
    return area;
}

// Invocación - puede hacerse antes de la declaración
console.log(calcularArea(5, 3)); // 15
console.log(calcularArea(8, 4)); // 32

const despedir = function() {
    console.log("¡Hasta luego!");
};

despedir(); // Invocación

const saludar = function saludo() {
    console.log("¡Hola!");
};

saludar(); // Funciona

// Arrow Functions (Funciones Flecha)
const sumar = (a, b) => {
    return a + b;
};
// const sumar = (a, b) => a + b;
// const cuadrado = n => n * n;
// const obtenerFecha = () => new Date();

// Función Tradicional
// const numeros = [1, 2, 3, 4, 5];
// const dobles = numeros.map(function(n) {
//     return n * 2;
// });

// Arrow Function
const numeros = [1, 2, 3, 4, 5];
const dobles = numeros.map(n => n * 2);

// Parámetros por Defecto
function crearUsuario(nombre = "Invitado", edad = 18, activo = true) {
 return {
 nombre: nombre,
 edad: edad,
 activo: activo
 };
}

console.log(crearUsuario()); 
// { nombre: "Invitado", edad: 18, activo: true }

console.log(crearUsuario("Ana", 25)); 
// { nombre: "Ana", edad: 25, activo: true }

// Callbacks: Funciones como Argumentos
function procesarDatos(datos, callback) {
 console.log("Procesando...");
 const resultado = datos.map(x => x * 2);
 callback(resultado);
}

// Diferentes callbacks para diferentes comportamientos
procesarDatos([1, 2, 3], (resultado) => {
 console.log("Resultado:", resultado); // [2, 4, 6]
});

procesarDatos([1, 2, 3], (resultado) => {
 console.log("Suma total:", resultado.reduce((a, b) => a + b));
});