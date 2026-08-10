#Punto 2.a
options(digits=4)
if(!require(readxl)) install.packages("readxl")
library(readxl)
read_excel("TUPAD-2026-EST-TPI-planilla3 (1).xlsx")
datos <- read_excel("TUPAD-2026-EST-TPI-planilla3 (1).xlsx")
estudio <- datos$TIEMPO_SEMANAL_ESTUDIO_HS
n <- length(estudio)
k <- ceiling(1 + 3.322 * log10(n))
min_v <- min(estudio)
max_v <- max(estudio)
amplitud <- (max_v - min_v) / k
cortes <- seq(min_v, max_v, by = amplitud)
tabla_intervalos <- cut(estudio, breaks = cortes, right = FALSE, include.lowest = TRUE)
fi <- table(tabla_intervalos)
Fi <- cumsum(fi)
hi <- prop.table(fi)
Hi <- cumsum(hi)

tabla_estudio_final <- cbind(fi, Fi, hi, Hi)
print("TABLA DE FRECUENCIAS: HORAS DE ESTUDIO")
print(tabla_estudio_final)
#Punto 2.b
satisfaccion <- factor(datos$SATISF_CON_CARRERA, 
                       levels = c(1, 2, 3, 4),
                       labels = c("Muy Satisfecho", "Satisfecho", "Insatisfecho", "Muy Insatisfecho"))
fi_s <- table(satisfaccion)
Fi_s <- cumsum(fi_s)
hi_s <- prop.table(fi_s)
Hi_s <- cumsum(hi_s)

tabla_satisf_final <- cbind(fi_s, Fi_s, hi_s, Hi_s)
print("TABLA DE FRECUENCIAS: SATISFACCIÓN")
print(tabla_satisf_final)
#Punto 3
media_estudio <- mean(estudio)
mediana_estudio <- median(estudio)
sd_estudio <- sd(estudio)
cuartiles_estudio <- quantile(estudio, probs = c(0.25, 0.5, 0.75))
print("MEDIDAS HORAS DE ESTUDIO")
print(paste("Media:", round(media_estudio, 4)))
print(paste("Mediana:", mediana_estudio))
print(paste("Desviación Estándar:", round(sd_estudio, 4)))
print(cuartiles_estudio)

moda_satisfaccion <- names(which.max(fi_s))
print("MEDIDAS SATISFACCIÓN")
print(paste("Moda:", moda_satisfaccion))
#Punto 4:
hist(estudio, 
     breaks = cortes, 
     main = "Distribución de Horas de Estudio Semanales",
     xlab = "Horas", 
     ylab = "Frecuencia Absoluta (fi)",
     col = "skyblue", 
     right = FALSE)
porcentajes <- round(prop.table(fi_s) * 100, 2)
etiquetas <- paste0(names(fi_s), " (", porcentajes, "%)")

pie(fi_s, 
    labels = etiquetas, 
    main = "Nivel de Satisfacción con la Carrera",
    col = terrain.colors(4))
