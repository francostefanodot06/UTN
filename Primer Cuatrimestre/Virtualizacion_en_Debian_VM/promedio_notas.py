#programa de calculo de promedio de notas tpi
#autor: franco stefano (user light)
#descripcion: programa que solicita notas, las almacena  en una lista, calcula el promedio y muestra los resultados

def calcular_promedio(notas):
    """Calcula el promedio de una lista de notas"""
    if len(notas) == 0:
        return 0
    return sum(notas) / len(notas)
def main ():
    print("=== Calculadora de promedios ===\n")
#La cantidad de notas

cantidad = int(input("¿Cuántas notas querés ingresar?:"))
#Lista para almacenar las notas
notas = []

#El ciclo for para cargar las notas
for i in range(cantidad):
    nota = float(input(f"Ingresá la nota {i+1}: "))
    notas.append(nota)
#Agrego calculo aritmético del promedio
promedio = calcular_promedio(notas)

#salida formateada
print("\n=== Resultados ===")
print(f"Notas ingresadas: {notas}")
print(f"Promedio final: {promedio:.2f}")

if promedio >=6:
    print("Estado Aprobado")
else:
    print("Estado Desaprobado")
if __name__ == "__main__":
    main()
