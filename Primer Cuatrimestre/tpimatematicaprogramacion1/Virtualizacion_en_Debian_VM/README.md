
# Proyecto Integrador – Virtualización, Debian y Desarrollo en Python

Este repositorio contiene el trabajo práctico integrador correspondiente al módulo de virtualización e instalación de sistemas operativos Linux, junto con el desarrollo de una aplicación simple en Python para cálculos académicos.

El proyecto fue realizado íntegramente en un entorno virtualizado utilizando **VirtualBox** y el sistema operativo **Debian**.  
Además, se incorpora un pequeño programa en Python que solicita notas, calcula el promedio y determina si el usuario aprueba o desaprueba según el resultado.

---

## 📦 Contenido del Repositorio

- **/documentacion/** → Incluye el marco teórico en PDF y el informe completo del trabajo.  
- **/capturas/** → Imágenes del proceso de instalación del sistema operativo, configuración y ejecución del programa.  
- **/codigo/** → Archivo `promedio_notas.py` con el código del ejercicio práctico.  
- **README.md** → Este archivo con la presentación general del proyecto.

---

## 🖥️ Entorno Utilizado

- **Software de virtualización:** VirtualBox  
- **Sistema operativo invitado:** Debian 12/13  
- **Lenguaje utilizado:** Python 3.13  
- **Editor dentro de la VM:** Nano / Terminal  
- **Sistema operativo host:** Windows (para correr VirtualBox)

La elección del entorno se basa en la necesidad de trabajar de manera aislada, segura y reproducible, aprovechando las ventajas que proveen las máquinas virtuales para pruebas, aprendizaje y despliegue.

---

## ⚙️ Instalación de Debian (Resumen)

En la máquina virtual se realizaron las siguientes tareas:

1. Creación de la VM asignando procesador, RAM y disco virtual.  
2. Montaje de la imagen ISO de Debian.  
3. Ejecución del instalador gráfico.  
4. Configuración de usuario, contraseña de root y nombre de equipo.  
5. Particionado automático del disco.  
6. Instalación del entorno de escritorio.  
7. Actualización del sistema mediante terminal con:

   bash
   sudo apt update
   sudo apt upgrade -y
# Creacion de la maquina virtual e instalacion del sistema Linux Debian [1 (1).pdf](https://github.com/user-attachments/files/23536353/1.1.pdf)
# Capturas de la verificacion de la version de python, codigo del programa y resultado final [vpfayso.pdf](https://github.com/user-attachments/files/23537465/vpfayso.pdf)
Este repositorio lo subi desde la maquina virtual en Debian
