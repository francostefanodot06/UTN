# ==============================================================================
# TRABAJO PRÁCTICO INTEGRADOR - PyE - UTN
# RESOLUCIÓN AUTOMÁTICA - PREGUNTA 8 (MUESTREO)
# ==============================================================================

# Definición de parámetros poblacionales del caso de estudio (Peso)
mu_poblacional <- 74.0
sd_poblacional <- 8.0

# Configuración del muestreo
n_muestra    <- 20
num_muestras <- 6

# Fijamos semilla para que los resultados sean reproducibles al evaluar
set.seed(2026)

# Inicializamos un vector para almacenar los promedios muestrales
promedios_muestrales <- numeric(num_muestras)

# Generación de las 6 muestras aleatorias simples y cálculo de sus medias
for(i in 1:num_muestras) {
  muestra <- rnorm(n = n_muestra, mean = mu_poblacional, sd = sd_poblacional)
  promedios_muestrales[i] <- mean(muestra)
}

# Impresión formal de resultados en consola
print(paste("Parámetro Poblacional (Media Real mu):", mu_poblacional))
for(i in 1:num_muestras) {
  print(paste("Muestra", i, "- Peso Promedio:", round(promedios_muestrales[i], 2)))
}