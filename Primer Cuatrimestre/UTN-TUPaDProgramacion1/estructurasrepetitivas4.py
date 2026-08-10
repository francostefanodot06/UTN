for i in range(101):
    print(i)
num = int(input("Ingrese un número entero: "))
print("Cantidad de dígitos:", len(str(abs(num))))
a = int(input("Ingrese primer número: "))
b = int(input("Ingrese segundo número: "))
if a > b:
    a, b = b, a
suma = sum(range(a+1, b))
print("La suma es:", suma)

suma = 0
while True:
    num = int(input("Ingrese un número (0 para terminar): "))
    if num == 0:
        break
    suma += num
print("Total acumulado:", suma)
import random

numSecreto = random.randint(0, 9)
intentos = 0

while True:
    num = int(input("Adivine el número (0-9): "))
    intentos += 1
    if num == numSecreto:
        print("¡Correcto! Intentos:", intentos)
        break
for i in range(100, -1, -2):
    print(i)
n = int(input("Ingrese un número positivo: "))
if n < 0:
    print("Debe ingresar un número positivo.")
else:
    suma = sum(range(n+1))
    print("La suma es:", suma)
pares = impares = positivos = negativos = 0

for i in range(100):
    num = int(input(f"Ingrese número {i+1}: "))
    if num % 2 == 0:
        pares += 1
    else:
        impares += 1
    if num > 0:
        positivos += 1
    elif num < 0:
        negativos += 1

print("Pares:", pares)
print("Impares:", impares)
print("Positivos:", positivos)
print("Negativos:", negativos)
pares = impares = positivos = negativos = 0

suma = 0
for i in range(100):
    num = int(input(f"Ingrese número {i+1}: "))
    suma += num
media = suma / 100
print("La media es:", media)

num = int(input("Ingrese un número: "))
signo = -1 if num < 0 else 1
abs_num = abs(num)
invertido = int(str(abs_num)[::-1]) * signo
print("Número invertido:", invertido)
