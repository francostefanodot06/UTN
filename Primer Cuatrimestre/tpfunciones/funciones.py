# 1. Función que imprime "Hola Mundo"
def imprimir_hola_mundo():
    print("Hola Mundo!")

imprimir_hola_mundo()


# 2. Función que devuelve un saludo personalizado
def saludar_usuario(nombre):
    return f"Hola {nombre}!"

nombre = input("Ingresá tu nombre: ")
print(saludar_usuario(nombre))


# 3. Función que muestra información personal
def informacion_personal(nombre, apellido, edad, residencia):
    print(f"Soy {nombre} {apellido}, tengo {edad} años y vivo en {residencia}")

nombre = input("Nombre: ")
apellido = input("Apellido: ")
edad = input("Edad: ")
residencia = input("Residencia: ")
informacion_personal(nombre, apellido, edad, residencia)


# 4. Área y perímetro de un círculo
def calcular_area_circulo(radio):
    return 3.14159 * (radio ** 2)

def calcular_perimetro_circulo(radio):
    return 2 * 3.14159 * radio

radio = float(input("Ingresá el radio del círculo: "))
print("Área:", calcular_area_circulo(radio))
print("Perímetro:", calcular_perimetro_circulo(radio))


# 5. Convertir segundos a horas
def segundos_a_horas(segundos):
    return segundos / 3600

seg = int(input("Ingresá segundos: "))
print("Horas equivalentes:", segundos_a_horas(seg))


# 6. Tabla de multiplicar
def tabla_multiplicar(numero):
    for i in range(1, 11):
        print(f"{numero} x {i} = {numero * i}")

num = int(input("Número para la tabla: "))
tabla_multiplicar(num)


# 7. Operaciones básicas
def operaciones_basicas(a, b):
    suma = a + b
    resta = a - b
    multi = a * b
    division = a / b if b != 0 else "No se puede dividir por cero"
    return suma, resta, multi, division

a = float(input("Ingresá número A: "))
b = float(input("Ingresá número B: "))
resultados = operaciones_basicas(a, b)

print("Suma:", resultados[0])
print("Resta:", resultados[1])
print("Multiplicación:", resultados[2])
print("División:", resultados[3])


# 8. Calcular IMC
def calcular_imc(peso, altura):
    return peso / (altura ** 2)

peso = float(input("Peso en kg: "))
altura = float(input("Altura en metros: "))
print("Tu IMC es:", round(calcular_imc(peso, altura), 2))


# 9. Convertir Celsius a Fahrenheit
def celsius_a_fahrenheit(celsius):
    return (celsius * 9/5) + 32

c = float(input("Temperatura en °C: "))
print("En Fahrenheit es:", celsius_a_fahrenheit(c))


# 10. Calcular promedio de tres números
def calcular_promedio(a, b, c):
    return (a + b + c) / 3

n1 = float(input("Número 1: "))
n2 = float(input("Número 2: "))
n3 = float(input("Número 3: "))
print("Promedio:", calcular_promedio(n1, n2, n3))

