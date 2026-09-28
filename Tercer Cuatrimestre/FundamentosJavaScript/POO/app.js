let persona = {
  nombre: "Ana",
  edad: 25,
  saludar: function() {
    console.log("Hola, soy " + this.nombre);
  }
};

console.log(persona.nombre); // Ana
persona.saludar(); // Hola, soy Ana

// Plantillas para Crear Objetos
class Persona {
 constructor(nombre, edad) {
 this.nombre = nombre;
 this.edad = edad;
 }
 
 saludar() {
 console.log(`Hola, me llamo ${this.nombre}`);
 }
}

let p1 = new Persona("Luis", 30);
p1.saludar(); // Hola, me llamo Luis

// Propiedades y Métodos en Profundidad
class Coche {
  constructor(marca, modelo) {
    this.marca = marca;    // propiedad
    this.modelo = modelo;  // propiedad
    this.encendido = false; // estado inicial
  }
  
  arrancar() {           // método
    this.encendido = true;
    console.log("El coche está arrancando...");
  }
  
  obtenerInfo() {        // método
    return `${this.marca} ${this.modelo}`;
  }
}

// Desestructuración de Objetos
let persona2 = { nombre: "Ana", edad: 25, ciudad: "Madrid" };
let { nombre, edad } = persona;

console.log(nombre); // Ana
console.log(edad);   // 25

// Desestructuración de Arrays
let numeros = [10, 20, 30, 40];
let [a, b, ...resto] = numeros;

console.log(a); // 10
console.log(b); // 20
console.log(resto); // [30, 40]

// Operador Spread (...)
// Con Arrays
let arr1 = [1, 2, 3];
let arr2 = [...arr1, 4, 5];
console.log(arr2); // [1, 2, 3, 4, 5]

// Con Objetos
let obj1 = { nombre: "Ana" };
let obj2 = { ...obj1, edad: 25 };
console.log(obj2); // { nombre: "Ana", edad: 25 }

// Operador Rest (...)
// Parámetros Rest
function sumar(...numeros) {
  return numeros.reduce((a, b) => a + b, 0);
}

console.log(sumar(1, 2, 3, 4)); // 10
console.log(sumar(5, 10));      // 15

// Desestructuración Rest
let [primero, segundo, ...resto2] = [1, 2, 3, 4, 5];

console.log(primero); // 1
console.log(segundo); // 2
console.log(resto); // [3, 4, 5]

// Ejercicio
class Estudiante {
  constructor(nombre, edad, notas) {
    this.nombre = nombre;
    this.edad = edad;
    this.notas = notas;
  }
  
  promedio() {
    return this.notas.reduce((a, b) => a + b, 0) / this.notas.length;
  }
}

// Crear un estudiante
let e1 = new Estudiante("María", 20, [8, 9, 10]);

// Usar el método promedio
console.log(e1.promedio()); // 9

// Desestructuración
let { nombre2 } = e1;
console.log(nombre2); // María

// Spread para copiar y modificar
let e2 = { ...e1, edad: 21 };
console.log(e2);