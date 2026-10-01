import './style.css'
import { obtenerPersonajes } from './api/personajes'
import type { Personaje } from './types/personaje'

const URL_IMAGENES = 'https://cdn.thesimpsonsapi.com/500'
const contenedor = document.querySelector<HTMLDivElement>('#personajes')!

const crearTarjeta = (personaje: Personaje): HTMLDivElement => {
  const tarjeta = document.createElement('div')
  tarjeta.className = 'personaje-card' 
  
  tarjeta.innerHTML = `
    <img src="${URL_IMAGENES}${personaje.portrait_path}" alt="${personaje.name}">
    <h3>${personaje.name}</h3>
    <p><strong>Ocupación:</strong> ${personaje.occupation}</p>
    <p><strong>Estado:</strong> ${personaje.status}</p>
    <p><strong>Edad:</strong> ${personaje.age}</p>
  `
  return tarjeta
}

const mostrarPersonajes = (personajes: Personaje[]): void => {
  personajes.forEach(personaje => {
    const tarjeta = crearTarjeta(personaje)
    contenedor.appendChild(tarjeta)
  })
}

const iniciar = async (): Promise<void> => {
  const personajes = await obtenerPersonajes()
  mostrarPersonajes(personajes)
}

iniciar()