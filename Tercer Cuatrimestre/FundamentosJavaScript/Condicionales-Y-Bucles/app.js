let nota = 7;

if (nota >= 9){
    console.log("Excelente");
}else if (nota >= 6){
    console.log("Aprobado");
}else {
    console.log("Reprobado");
}

let dia = 5;

switch (dia) {
    case 1:
        console.log("Lunes");
        break;
    case 2:
        console.log("Martes");
        break;
    case 3:
        console.log("Miercoles");
        break;
    default:
        console.log("Dia invalido");
}

for ( let i = 0; i < 5; i++){
    console.log("Iteracion: " + i); // Salida: 0, 1, 2, 3, 4
}

let n = 1;

while (n <= 3){
    console.log("Numero: ",n);
    n++;
}

let x = 1;

do {
    console.log("Ejecutado: " + x);
    x++;
}while (x<=3);


let numeros = [1,2,3];

numeros.forEach((num, i) => {
    // Código a ejecutar
    console.log(`Posición ${i}: ${num * 2}`);
})