let a = 10;
let b = 3

console.log("Suma: ", a + b); // 13
console.log("Resta: ", a - b); // 7
console.log("Multiplicacion: ", a * b); // 30
console.log("Division: ", a / b); // 3.333...
console.log("Modulo: ", a % b); // 1

let esMayor = true;
let tieneDNI = false

console.log(esMayor && tieneDNI); // false - necesita ambos
console.log(esMayor || tieneDNI); // true - al menos uno
console.log(!esMayor); // false - invierte true

let edad = 18
let mensaje = (edad >= 18) ? "Puede votar" : "Es menor de edad";

console.log(mensaje); // "Puede votar"