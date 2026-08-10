import random
notas = [7, 8, 6, 9, 5, 10, 4, 7, 8, 6]
print("Notas de los estudiantes:")
for nota in notas:
    print(nota, end=" ")
promedio = sum(notas) / len(notas)
print(f"\nPromedio: {promedio:.2f}")
print("Nota más alta:", max(notas))
print("Nota más baja:", min(notas))
productos = []
for i in range(5):
    producto = input(f"Ingrese el producto {i+1}: ")
    productos.append(producto)

print("\nLista ordenada alfabéticamente:")
for p in sorted(productos):
    print(p)

eliminar = input("\n¿Qué producto desea eliminar?: ")
if eliminar in productos:
    productos.remove(eliminar)
    print("Lista actualizada:")
    for p in productos:
        print(p)
else:
    print("Ese producto no está en la lista.")


valores = [1, 2, 2, 3, 4, 4, 5, 1, 6]
sin_repetidos = list(set(valores))
print("\nLista original:", valores)
print("Lista sin repetidos:", sin_repetidos)
estudiantes = ["Ana", "Luis", "María", "Carlos", "Lucía", "Juan", "Sofía", "Pedro"]

accion = input("\n¿Desea agregar o eliminar un estudiante? (agregar/eliminar): ").lower()

if accion == "agregar":
    nuevo = input("Nombre del nuevo estudiante: ")
    estudiantes.append(nuevo)
elif accion == "eliminar":
    borrar = input("Nombre del estudiante a eliminar: ")
    if borrar in estudiantes:
        estudiantes.remove(borrar)
    else:
        print("No se encontró ese nombre.")
else:
    print("Acción no reconocida.")

print("Lista final de estudiantes:")
print(estudiantes)
numeros = [10, 20, 30, 40, 50, 60, 70]
rotada = [numeros[-1]] + numeros[:-1]
print("\nLista original:", numeros)
print("Lista rotada:", rotada)
temperaturas = [[random.randint(5, 15), random.randint(16, 35)] for _ in range(7)]

prom_min = sum([t[0] for t in temperaturas]) / 7
prom_max = sum([t[1] for t in temperaturas]) / 7

print("\nTemperaturas (mín, máx):")
for dia, t in enumerate(temperaturas, start=1):
    print(f"Día {dia}: {t}")

amplitudes = [t[1] - t[0] for t in temperaturas]
dia_mayor_amplitud = amplitudes.index(max(amplitudes)) + 1

print(f"Promedio mínimas: {prom_min:.2f}")
print(f"Promedio máximas: {prom_max:.2f}")
print(f"Día con mayor amplitud térmica: Día {dia_mayor_amplitud}")
notas = [
    [7, 8, 6],
    [6, 5, 9],
    [8, 7, 10],
    [5, 6, 7],
    [9, 8, 8]
]
print("\nPromedio por estudiante:")
for i, fila in enumerate(notas, start=1):
    promedio = sum(fila) / len(fila)
    print(f"Estudiante {i}: {promedio:.2f}")
print("\nPromedio por materia:")
for j in range(3):
    promedio = sum([fila[j] for fila in notas]) / len(notas)
    print(f"Materia {j+1}: {promedio:.2f}")
tablero = [["-" for _ in range(3)] for _ in range(3)]

def mostrar_tablero():
    for fila in tablero:
        print(" ".join(fila))
    print()
mostrar_tablero()

for turno in range(9):
    jugador = "X" if turno % 2 == 0 else "O"
    print(f"Turno del jugador {jugador}")
    fila = int(input("Fila (0-2): "))
    col = int(input("Columna (0-2): "))
    if tablero[fila][col] == "-":
        tablero[fila][col] = jugador
    else:
        print("Esa casilla ya está ocupada.")
        continue
    mostrar_tablero()
ventas = [[random.randint(10, 100) for _ in range(7)] for _ in range(4)]
print("\nTotal vendido por cada producto:")
for i, producto in enumerate(ventas, start=1):
    total = sum(producto)
    print(f"Producto {i}: {total}")
totales_dia = [sum([ventas[p][d] for p in range(4)]) for d in range(7)]
dia_mayor = totales_dia.index(max(totales_dia)) + 1
print(f"\nDía con mayores ventas totales: Día {dia_mayor}")
totales_producto = [sum(p) for p in ventas]
producto_top = totales_producto.index(max(totales_producto)) + 1
print(f"Producto más vendido: Producto {producto_top}")