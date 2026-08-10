print("Hola Mundo!")
nombre = input("ingrese su nombre")
print(f"Hola{nombre}!")
nombre = input("Ingrese su nombre nuevamente por favor: ")
apellido = input("ingrese su apellido: ")
edad = input ("ingrese su edad: ")
residencia = input ("ingrese su lugar de residencia: ")
import math
print(f"Soy {nombre} {apellido},tengo {edad} años y vivo en {residencia}")
radio = float(input("Ingrese el radio del circulo: "))
area = math.pi * (radio ** 2)
perimetro = 2 * math.pi * radio 
print(f"El area del circulo es: {area:2f}")
print(f"El perimetro (circunferencia) del circulo es: {perimetro:2f}")
segundos = int(input("Ingrese la cantidad de segundo: "))
horas = segundos // 3600 
print(f"{segundos}segundos equivalen a {horas} horas.")
numero = int(input ("Ingrese un numero para ver su tabla de multiplicar: "))
print(f"Tabla de multiplicar del {numero}:")
for i in range (1,11):
    print(f"{numero} x {i} = {numero * i}")
num1 = int(input("Ingrese el primer numero (distinto de 0): "))
num2 = int(input("Ingrese el segundo numero (distinto de 0):"))
if num1 == 0 or num2 == 0:
    print("Error: ninguno de los numeros puede ser 0")
else:
    suma = num1 + num2
    resta = num1 - num2
    multiplicacion = num1 * num2
    division = num1 / num2 
    print(f"{num1} + {num2} = {suma}")
    print(f"{num1} - {num2} = {resta} ")
    print(f"{num1} * {num2} = {multiplicacion}")
    print(f"{num1} / {num2} = {division:.2f}")
peso = float(input("Ingrese su peso en kg: "))
altura = float(input("Ingrese su altura en metros: "))
imc = peso / (altura ** 2)
print(f"Su índice de masa corporal (IMC) es: {imc:.2f}")
celsius = float(input("Ingrese la temperatura en grados Celsius: "))
fahrenheit = (9/5) * celsius + 32
print(f"{celsius}°C equivalen a {fahrenheit:.2f}°F")
n1 = float(input("Ingrese el primer número: "))
n2 = float(input("Ingrese el segundo número: "))
n3 = float(input("Ingrese el tercer número: "))
promedio = (n1 + n2 + n3) / 3
print(f"El promedio de {n1}, {n2} y {n3} es: {promedio:.2f}")

