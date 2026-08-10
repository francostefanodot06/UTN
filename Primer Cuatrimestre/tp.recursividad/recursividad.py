import sys

# --- EJERCICIO 1: Factorial Recursivo ---
def factorial_recursivo(n):
    """Calcula el factorial de un número n."""
    if n == 0:
        return 1
    return n * factorial_recursivo(n - 1)

def ejercicio_1():
    print("\n--- EJERCICIO 1: Factorial ---")
    try:
        limite = int(input("Ingrese el número entero positivo hasta el que desea calcular el factorial: "))
        if limite < 1:
            print("El límite debe ser mayor o igual a 1.")
            return
        
        for i in range(1, limite + 1):
            resultado = factorial_recursivo(i)
            print(f"El factorial de {i}! es: {resultado}")
    except ValueError:
        print("Entrada inválida. Debe ingresar un número entero.")

# --- EJERCICIO 2: Serie de Fibonacci Recursiva ---
def fibonacci_recursivo(pos):
    """Calcula el valor de la serie de Fibonacci en la posición indicada."""
    if pos <= 0:
        return 0
    elif pos == 1:
        return 1
    return fibonacci_recursivo(pos - 1) + fibonacci_recursivo(pos - 2)

def ejercicio_2():
    print("\n--- EJERCICIO 2: Serie de Fibonacci ---")
    try:
        limite = int(input("Ingrese la posición hasta la que desea mostrar la serie de Fibonacci: "))
        if limite < 0:
            print("La posición debe ser un número positivo.")
            return

        print(f"Serie de Fibonacci hasta la posición {limite}:")
        serie = [fibonacci_recursivo(i) for i in range(limite + 1)]
        print(serie)
    except ValueError:
        print("Entrada inválida. Debe ingresar un número entero.")

# --- EJERCICIO 3: Potencia Recursiva ---
def potencia_recursiva(base, exponente):
    """Calcula la potencia de un número base elevado a un exponente."""
    if exponente == 0:
        return 1
    elif exponente == 1:
        return base
    return base * potencia_recursiva(base, exponente - 1)

def ejercicio_3():
    print("\n--- EJERCICIO 3: Potencia ---")
    try:
        base = float(input("Ingrese la base (n): "))
        exponente = int(input("Ingrese el exponente (m): "))
        
        if exponente < 0:
            print("El ejercicio pide exponentes positivos (o cero) para esta fórmula recursiva.")
            return
            
        resultado = potencia_recursiva(base, exponente)
        print(f"El resultado de {base} elevado a la {exponente} es: {resultado}")
    except ValueError:
        print("Entrada inválida. Asegúrese de que el exponente sea un entero.")

# --- EJERCICIO 4: Conversión Decimal a Binario Recursiva ---
def decimal_a_binario_recursivo(decimal):
    """Convierte un número decimal a su representación binaria (string) usando recursión."""
    if decimal == 0:
        return ""
    
    return decimal_a_binario_recursivo(decimal // 2) + str(decimal % 2)

def ejercicio_4():
    print("\n--- EJERCICIO 4: Decimal a Binario ---")
    try:
        num = int(input("Ingrese un número entero positivo en base decimal (Ej: 10): "))
        if num < 0:
            print("Debe ser un número entero positivo.")
            return

        if num == 0:
            print("Binario: 0")
        else:
            binario = decimal_a_binario_recursivo(num)
            print(f"El resultado binario de {num} es: {binario}") # Ejemplo: 10 -> "1010"
    except ValueError:
        print("Entrada inválida. Debe ingresar un número entero positivo.")

# --- EJERCICIO 5: Palíndromo Recursivo ---
def es_palindromo_recursivo(palabra):
    """Devuelve True si la palabra es un palíndromo, False si no lo es."""
    if len(palabra) <= 1:
        return True
        
    if palabra[0].lower() == palabra[-1].lower():
        return es_palindromo_recursivo(palabra[1:-1])
    else:
        return False

def ejercicio_5():
    print("\n--- EJERCICIO 5: Palíndromo ---")
    palabra_input = input("Ingrese una palabra (sin espacios ni tildes, Ej: anilina): ").strip().replace(" ", "")
    
    if es_palindromo_recursivo(palabra_input):
        print(f"'{palabra_input}' es un palíndromo. (True)")
    else:
        print(f"'{palabra_input}' NO es un palíndromo. (False)")

# --- EJERCICIO 6: Suma de Dígitos Recursiva ---
def suma_digitos_recursiva(n):
    """Calcula la suma de los dígitos de un número entero positivo n."""
    if n == 0:
        return 0
        
    return (n % 10) + suma_digitos_recursiva(n // 10)

def ejercicio_6():
    print("\n--- EJERCICIO 6: Suma de Dígitos ---")
    try:
        num = int(input("Ingrese un número entero positivo (Ej: 1234): "))
        if num < 0:
            print("Debe ingresar un número positivo.")
            return

        resultado = suma_digitos_recursiva(num)
        print(f"La suma de los dígitos de {num} es: {resultado}") # Ej: 1234 -> 10
    except ValueError:
        print("Entrada inválida. Debe ingresar un número entero.")

# --- EJERCICIO 7: Contar Bloques de la Pirámide Recursiva ---
def contar_bloques_recursiva(n):
    """Calcula el total de bloques necesarios para la pirámide."""
    if n <= 1:
        return 1
        
    return n + contar_bloques_recursiva(n - 1)

def ejercicio_7():
    print("\n--- EJERCICIO 7: Contar Bloques ---")
    try:
        niveles = int(input("Ingrese el número de bloques en el nivel más bajo (n, Ej: 4): "))
        if niveles <= 0:
            print("El número de bloques debe ser positivo.")
            return

        resultado = contar_bloques_recursiva(niveles)
        print(f"El total de bloques necesarios para la pirámide de {niveles} niveles es: {resultado}")
    except ValueError:
        print("Entrada inválida. Debe ingresar un número entero.")

# --- EJERCICIO 8: Contar Dígitos Recursiva ---
def contar_digito_recursiva(numero, digito):
    """Cuenta cuántas veces aparece un dígito dentro de un número entero."""
    if numero == 0:
        return 0
    
    ultimo_digito = numero % 10
    
    contador = 1 if ultimo_digito == digito else 0
    
    return contador + contar_digito_recursiva(numero // 10, digito)

def ejercicio_8():
    print("\n--- EJERCICIO 8: Contar Dígito ---")
    try:
        num = int(input("Ingrese el número principal (Ej: 12233421): "))
        d = int(input("Ingrese el dígito a contar (0-9, Ej: 2): "))
        
        if num < 0 or d < 0 or d > 9:
            print("Entrada inválida. Asegúrese de que el número sea positivo y el dígito esté entre 0 y 9.")
            return
        
        if num == 0:
            resultado = 1 if d == 0 else 0
        else:
            resultado = contar_digito_recursiva(num, d)

        print(f"El dígito {d} aparece {resultado} veces en el número {num}")
    except ValueError:
        print("Entrada inválida.")

# --- PROGRAMA PRINCIPAL ---

def main():
    print("===========================================")
    print("--- INICIO DE PRÁCTICO RECURSIVIDAD UTN ---")
    print("===========================================")
    
    ejercicio_1()
    ejercicio_2()
    ejercicio_3()
    ejercicio_4()
    ejercicio_5()
    ejercicio_6()
    ejercicio_7()
    ejercicio_8()

if __name__ == "__main__":
    main()