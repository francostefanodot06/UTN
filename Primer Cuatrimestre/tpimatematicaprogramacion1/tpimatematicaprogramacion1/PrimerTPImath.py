# Generador y analizador de tablas de verdad

def operar(p, q, operador):
    if operador == "AND":
        return p and q
    if operador == "OR":
        return p or q
    if operador == "NOT":
        return not p
    if operador == "=>":  # implicación
        return (not p) or q
    if operador == "<=>":  # doble implicación
        return p == q
    return None

def analizar(resultados):
    if all(resultados):
        return "TAUTOLOGÍA"
    elif not any(resultados):
        return "CONTRADICCIÓN"
    else:
        return "CONTINGENCIA"

print("=== GENERADOR DE TABLAS DE VERDAD ===")
exp = input("Ingrese la expresión (ej: p AND q, p OR q, NOT p, p => q, p <=> q): ").split()

# Caso especial: NOT p
if len(exp) == 2 and exp[0] == "NOT":
    operador = "NOT"
    print("\np | NOT p")
    print("-----------")
    resultados = []
    for p in [0, 1]:
        r = operar(bool(p), None, operador)
        resultados.append(r)
        print(p, "| ", int(r))

    print("\nClasificación:", analizar(resultados))

else:
    p_var = exp[0]
    operador = exp[1]
    q_var = exp[2]

    print("\np | q | Resultado")
    print("--------------------")
    resultados = []

    for p in [0, 1]:
        for q in [0, 1]:
            r = operar(bool(p), bool(q), operador)
            resultados.append(r)
            print(p, "|", q, "|", int(r))

    print("\nClasificación:", analizar(resultados))
