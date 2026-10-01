import type { Personaje, RespuestaPersonajes } from '../types/personaje'

const URL_API = 'https://thesimpsonsapi.com/api/characters'

export const obtenerPersonajes = async (): Promise<Personaje[]> => {
  const respuesta = await fetch(URL_API)
  const datos = (await respuesta.json()) as RespuestaPersonajes
  return datos.results
}