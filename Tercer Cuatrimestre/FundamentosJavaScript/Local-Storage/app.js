// Guardar información
localStorage.setItem("nombre", "Carlos");
localStorage.setItem("edad", "25");

// Leer información
console.log(localStorage.getItem("nombre")); 
// Resultado: "Carlos"

// Borrar un elemento específico
localStorage.removeItem("edad");

// Borrar todo el contenido
localStorage.clear();

const usuario = {
  nombre: "Ana",
  edad: 20,
  email: "ana@email.com"
};

localStorage.setItem("usuario", JSON.stringify(usuario));

const data = JSON.parse(localStorage.getItem("usuario"));
console.log(data.nombre); // "Ana"

// Guardar preferencia temporal
sessionStorage.setItem("color", "azul");
sessionStorage.setItem("idioma", "español");

// Leer preferencia
const colorActual = sessionStorage.getItem("color");
console.log(colorActual); // "azul"

// Al cerrar la pestaña, todos los datos
// de sessionStorage desaparecen automáticamente

//setTimeout
console.log("Inicio");

setTimeout(() => {
  console.log("Han pasado 2 segundos");
}, 2000);

// setInterval y clearInterval
let contador = 0;

const intervalo = setInterval(() => {
  contador++;
  console.log("Contador:", contador);
  
  if (contador === 5) {
    clearInterval(intervalo);
    console.log("Intervalo detenido");
  }
}, 1000);