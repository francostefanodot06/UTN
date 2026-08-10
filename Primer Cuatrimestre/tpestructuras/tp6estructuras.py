# ======================================
# 1) Diccionario inicial y agregar frutas
# ======================================

precios_frutas = {
    'Banana': 1200,
    'Ananá': 2500,
    'Melón': 3000,
    'Uva': 1450
}

# Agregar frutas nuevas
precios_frutas['Naranja'] = 1200
precios_frutas['Manzana'] = 1500
precios_frutas['Pera'] = 2300

print("1) Diccionario con nuevas frutas:")
print(precios_frutas)
print("-" * 50)


# ======================================
# 2) Actualizar precios
# ======================================

precios_frutas['Banana'] = 1330
precios_frutas['Manzana'] = 1700
precios_frutas['Melón'] = 2800

print("2) Diccionario con precios actualizados:")
print(precios_frutas)
print("-" * 50)


# ======================================
# 3) Lista con solo las frutas (las claves)
# ======================================

lista_frutas = list(precios_frutas.keys())

print("3) Lista de frutas:")
print(lista_frutas)
print("-" * 50)


# ======================================
# 4) Agenda telefónica
# ======================================

agenda = {}

print("4) Cargar contactos:")
for i in range(5):
    nombre = input(f"Ingrese nombre del contacto {i+1}: ")
    numero = input(f"Ingrese número de {nombre}: ")
    agenda[nombre] = numero

buscar = input("Ingrese un nombre para buscar su número: ")

if buscar in agenda:
    print("Número encontrado:", agenda[buscar])
else:
    print("El contacto no existe.")
print("-" * 50)


# ======================================
# 5) Palabras únicas y conteo de repetición
# ======================================

frase = input("5) Ingrese una frase: ")

palabras = frase.lower().split()

palabras_unicas = set(palabras)

conteo = {}
for p in palabras:
    conteo[p] = conteo.get(p, 0) + 1

print("Palabras únicas:", palabras_unicas)
print("Conteo de palabras:", conteo)
print("-" * 50)


# ======================================
# 6) Alumnos con tuplas de notas y promedios
# ======================================

alumnos = {}

for i in range(3):
    nombre = input(f"Ingrese nombre del alumno {i+1}: ")
    notas = []
    for j in range(3):
        nota = float(input(f"Ingrese nota {j+1} de {nombre}: "))
        notas.append(nota)
    alumnos[nombre] = tuple(notas)

print("Promedios:")
for alumno, notas in alumnos.items():
    promedio = sum(notas) / len(notas)
    print(f"{alumno}: {promedio:.2f}")
print("-" * 50)


# ======================================
# 7) Sets de aprobados
# ======================================

parcial1 = {1, 2, 3, 4, 5}
parcial2 = {4, 5, 6, 7}

ambos = parcial1 & parcial2
solo_uno = parcial1 ^ parcial2
al_menos_uno = parcial1 | parcial2

print("7) Aprobados en ambos parciales:", ambos)
print("Aprobados en solo uno:", solo_uno)
print("Aprobados en al menos uno:", al_menos_uno)
print("-" * 50)


# ======================================
# 8) Gestión de stock con diccionario
# ======================================

stock = {
    "Leche": 10,
    "Pan": 25,
    "Huevos": 12
}

producto = input("8) Ingrese un producto para consultar: ")

if producto in stock:
    print(f"Stock actual: {stock[producto]}")
    agregar = int(input("¿Cuántas unidades desea agregar? "))
    stock[producto] += agregar
    print("Stock actualizado:", stock)
else:
    print("El producto no existe. Será agregado.")
    nuevo_stock = int(input("Ingrese stock inicial: "))
    stock[producto] = nuevo_stock
    print("Producto agregado:", stock)

print("-" * 50)


# ======================================
# 9) Agenda con claves como tuplas (día, hora)
# ======================================

agenda_eventos = {
    (1, "10:00"): "Dentista",
    (2, "14:30"): "Reunión de trabajo",
    (3, "09:00"): "Gimnasio"
}

dia = int(input("9) Ingrese día para consultar: "))
hora = input("Ingrese hora (formato HH:MM): ")

clave = (dia, hora)

if clave in agenda_eventos:
    print("Evento:", agenda_eventos[clave])
else:
    print("No hay actividad registrada.")
print("-" * 50)


# ======================================
# 10) Invertir diccionario país-capital
# ======================================

paises = {
    "Argentina": "Buenos Aires",
    "Brasil": "Brasilia",
    "Chile": "Santiago",
    "Uruguay": "Montevideo"
}

capital_a_pais = {capital: pais for pais, capital in paises.items()}

print("10) Diccionario invertido (capital → país):")
print(capital_a_pais)
print("-" * 50)
