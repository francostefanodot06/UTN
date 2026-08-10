import os

# --- Configuración ---
NOMBRE_ARCHIVO = "productos.txt"

# --- Funciones de Utilidad ---

def crear_archivo_inicial():
    """
    Actividad 1: Crea el archivo productos.txt con 3 productos iniciales 
    si no existe, con el formato: nombre,precio,cantidad.
    """
    if not os.path.exists(NOMBRE_ARCHIVO):
        print(f"Creando archivo inicial: {NOMBRE_ARCHIVO}...")
        # Usa el modo 'w' para escribir y crear el archivo
        with open(NOMBRE_ARCHIVO, 'w') as archivo:
            archivo.write("Lapicera,120.5,30\n")
            archivo.write("Cuaderno,850.0,15\n")
            archivo.write("Goma,45.25,50\n")
        print("Archivo creado con éxito.\n")

def leer_y_cargar_productos():
    """
    Actividad 4: Lee el archivo y carga los datos en una lista de diccionarios.
    """
    productos = []
    try:
        # Usa el modo 'r' para lectura (read)
        with open(NOMBRE_ARCHIVO, 'r') as archivo:
            print(f"Leyendo productos de {NOMBRE_ARCHIVO}...")
            for linea in archivo:
                # Actividad 2: Procesamiento de la línea
                linea_limpia = linea.strip()
                if not linea_limpia:
                    continue
                
                datos = linea_limpia.split(",")
                
                if len(datos) == 3:
                    try:
                        producto = {
                            "nombre": datos[0].strip(),
                            # Se convierten a float e int
                            "precio": float(datos[1].strip()),
                            "cantidad": int(datos[2].strip())
                        }
                        productos.append(producto)
                    except ValueError:
                        print(f"ADVERTENCIA: Saltando línea con datos inválidos: {linea_limpia}")
                
        return productos
    except FileNotFoundError:
        print(f"ERROR: El archivo '{NOMBRE_ARCHIVO}' no se encontró.")
        return []

def mostrar_productos(productos):
    """
    Actividad 2: Muestra los productos en el formato solicitado.
    """
    if not productos:
        print("No hay productos para mostrar.\n")
        return

    print("\n--- Lista de Productos Almacenados ---")
    for p in productos:
        # Formato solicitado: Producto: Lapicera | Precio: $120.5 | Cantidad: 30
        print(f"Producto: {p['nombre']} | Precio: ${p['precio']:.2f} | Cantidad: {p['cantidad']}")
    print("--------------------------------------\n")

def agregar_producto(productos):
    """
    Actividad 3: Solicita un nuevo producto y lo agrega a la lista en memoria.
    """
    print("\n--- Agregar Nuevo Producto ---")
    while True:
        try:
            nombre = input("Ingrese nombre del producto: ").strip()
            if not nombre:
                 print("El nombre no puede estar vacío.")
                 continue

            precio = float(input("Ingrese precio: "))
            if precio <= 0:
                print("El precio debe ser mayor a cero.")
                continue

            cantidad = int(input("Ingrese cantidad: "))
            if cantidad < 0:
                print("La cantidad no puede ser negativa.")
                continue
            
            # Crear diccionario del nuevo producto y agregar a la lista
            nuevo_producto = {
                "nombre": nombre,
                "precio": precio,
                "cantidad": cantidad
            }
            productos.append(nuevo_producto)
            print(f"\nProducto '{nombre}' agregado a la lista en memoria.")
            return

        except ValueError:
            print("ERROR: El precio debe ser un número y la cantidad un número entero.\n")

def buscar_producto(productos):
    """
    Actividad 5: Pide un nombre, busca en la lista y muestra sus datos o un error.
    """
    print("\n--- Buscar Producto ---")
    nombre_buscado = input("Ingrese el nombre del producto a buscar: ").strip()
    
    encontrado = False
    for p in productos:
        if p["nombre"].lower() == nombre_buscado.lower():
            print("\n¡Producto Encontrado!")
            print(f"Nombre: {p['nombre']}")
            print(f"Precio: ${p['precio']:.2f}")
            print(f"Cantidad: {p['cantidad']}")
            encontrado = True
            break
            
    if not encontrado:
        print(f"\nERROR: El producto '{nombre_buscado}' no se encontró en la lista.")

def guardar_productos_actualizados(productos):
    """
    Actividad 6: Sobrescribe el archivo productos.txt con el contenido actualizado 
    de la lista de diccionarios.
    """
    if not productos:
        print("\nNo hay productos para guardar. El archivo se vaciará.")
    
    try:
        # Usa el modo 'w' para sobrescribir (write) todo el contenido
        with open(NOMBRE_ARCHIVO, 'w') as archivo:
            for p in productos:
                # Escribe la línea en el formato nombre,precio,cantidad
                linea = f"{p['nombre']},{p['precio']},{p['cantidad']}\n"
                archivo.write(linea)
        print(f"\n¡Datos guardados con éxito! El archivo '{NOMBRE_ARCHIVO}' ha sido actualizado.")
    except Exception as e:
        print(f"ERROR al guardar los datos: {e}")

# --- Programa Principal ---

def main():
    print("--- INICIO DE LA PRÁCTICA DE ARCHIVOS ---")

    # 1. Crear archivo inicial si no existe
    crear_archivo_inicial()
    
    # 4. Cargar productos del archivo a la lista de diccionarios (en memoria)
    lista_productos = leer_y_cargar_productos()
    
    if not lista_productos:
        return

    # 2. Mostrar productos cargados
    mostrar_productos(lista_productos)

    # 3. Agregar un producto
    agregar_producto(lista_productos)
    
    # 5. Buscar un producto
    buscar_producto(lista_productos)

    # 6. Guardar los productos actualizados (lista + nuevo producto) en el archivo
    guardar_productos_actualizados(lista_productos)

    print("\n--- FIN DE LA PRÁCTICA ---")

if __name__ == "__main__":
    main()