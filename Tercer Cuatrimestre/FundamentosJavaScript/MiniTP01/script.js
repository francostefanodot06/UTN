// ===== Actividad 1: Introducción y datos / variables =====

// Ejercicio 1: Declarar un string, un number, un boolean, un array y un object, y mostrarlos con console.log
let miString = "Desarrollo Web - JavaScript";
let miNumber = 2026;
let miBoolean = true;
let miArray = ["HTML", "CSS", "JavaScript"];
let miObject = { nombre: "Estudiante", curso: "Frontend" };

console.log("=== Ejercicio 1: Valores declarados ===");
console.log(miString);
console.log(miNumber);
console.log(miBoolean);
console.log(miArray);
console.log(miObject);

// Ejercicio 2: Usar typeof sobre cada una de esas variables para imprimir su tipo por consola
console.log("=== Ejercicio 2: Tipos con typeof ===");
console.log(typeof miString);  // string
console.log(typeof miNumber);  // number
console.log(typeof miBoolean); // boolean
console.log(typeof miArray);   // object (en JS los arrays son internamente objetos)
console.log(typeof miObject);  // object

// Ejercicio 3: Declarar una variable con const y comentar qué pasa si se intenta reasignarla
const GRAVEDAD = 9.8;
console.log("=== Ejercicio 3: Uso de const ===");
console.log("Valor de la constante GRAVEDAD:", GRAVEDAD);

/* 
¿Qué pasa si intentamos reasignar una constante?
Si descomentamos la línea de abajo:
GRAVEDAD = 10;
JavaScript arrojará un error en la consola: "TypeError: Assignment to constant variable."
Esto ocurre porque las variables declaradas con const no pueden ser reasignadas una vez inicializadas.
*/


// ===== Actividad 2: Operadores, condicionales y bucles =====

// Ejercicio 4: Con dos números, mostrar suma, resta, multiplicación, división y módulo (%)
let numA = 12;
let numB = 5;

console.log("=== Ejercicio 4: Operadores Aritméticos ===");
console.log("Suma (12 + 5):", numA + numB);
console.log("Resta (12 - 5):", numA - numB);
console.log("Multiplicación (12 * 5):", numA * numB);
console.log("División (12 / 5):", numA / numB);
console.log("Módulo (12 % 5):", numA % numB);

// Ejercicio 5: Comparar "5" == 5 contra "5" === 5 (y otro caso) con console.log
console.log("=== Ejercicio 5: Igualdad flexible vs estricta ===");
console.log('"5" == 5 (flexible):', "5" == 5);       // true (convierte el tipo implícitamente)
console.log('"5" === 5 (estricta):', "5" === 5);     // false (compara tanto valor como tipo: string vs number)
console.log('0 == false (flexible):', 0 == false);   // true
console.log('0 === false (estricta):', 0 === false); // false

// Ejercicio 6: Con if/else, verificar si un número es par o impar usando el módulo
console.log("=== Ejercicio 6: Condicionales (Par / Impar) ===");
let numeroTest = 8;

if (numeroTest % 2 === 0) {
    console.log("El número", numeroTest, "es PAR.");
} else {
    console.log("El número", numeroTest, "es IMPAR.");
}

// Ejercicio 7: Con un bucle for, recorrer un array e imprimir cada elemento con su índice
console.log("=== Ejercicio 7: Bucle for (Recorrer Array) ===");
let lenguajes = ["HTML", "CSS", "JavaScript", "React"];

for (let i = 0; i < lenguajes.length; i++) {
    console.log(`Índice ${i}: ${lenguajes[i]}`);
}

// Ejercicio 8: Con un bucle while, imprimir los números del 1 al 5
console.log("=== Ejercicio 8: Bucle while (Contador del 1 al 5) ===");
let contador = 1;

while (contador <= 5) {
    console.log("Número:", contador);
    contador++;
}