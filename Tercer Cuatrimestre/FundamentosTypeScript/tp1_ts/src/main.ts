import './style.css'

// Seleccionar y tipar explícitamente los elementos del DOM
const valor = document.querySelector<HTMLParagraphElement>('#valor')!;
const btnSumar = document.querySelector<HTMLButtonElement>('#btn-sumar')!;
const btnRestar = document.querySelector<HTMLButtonElement>('#btn-restar')!;

// Estado tipado para evitar sumar texto en lugar de números
let contador: number = 0;

const actualizarValor = (): void => {
  if (valor) {
    valor.textContent = String(contador);
  }
}

// Escuchar los clicks para sumar o restar
btnSumar.addEventListener('click', () => {
  contador++;
  actualizarValor();
});

btnRestar.addEventListener('click', () => {
  contador--;
  actualizarValor();
});

// Inicializar el valor en pantalla
actualizarValor();