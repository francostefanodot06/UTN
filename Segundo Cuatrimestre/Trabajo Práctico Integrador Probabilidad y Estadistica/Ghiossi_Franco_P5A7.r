# Variables iniciales del caso de estudio
p_muy_satisfecho   <- 0.30
p_satisfecho       <- 0.40
p_insatisfecho     <- 0.20
p_muy_insatisfecho <- 0.10

media_estatura <- 172
sd_estatura    <- 7
n_5            <- 16

# Ejercicio 5: Distribución Binomial
p_5a <- 1 - pbinom(9, size = n_5, prob = p_muy_satisfecho)
p_5b <- pbinom(8, size = n_5, prob = p_satisfecho) - pbinom(3, size = n_5, prob = p_satisfecho)
p_5c <- pbinom(4, size = n_5, prob = p_insatisfecho)
p_5d <- dbinom(10, size = n_5, prob = p_muy_insatisfecho)

# Ejercicio 6: Distribución de Poisson
lambda_6a <- 10
p_6a      <- 1 - ppois(5, lambda = lambda_6a)

lambda_6b <- 20
p_6b      <- ppois(12, lambda = lambda_6b)

p_6c      <- ppois(9, lambda = 15) - ppois(7, 15)

# Ejercicio 7: Distribución Normal
p_7a   <- 1 - pnorm(179, mean = media_estatura, sd = sd_estatura)
p_7b   <- pnorm(172, mean = media_estatura, sd = sd_estatura) - pnorm(147, mean = media_estatura, sd = sd_estatura)
val_7c <- qnorm(0.975, mean = media_estatura, sd = sd_estatura)

# Impresión de resultados numéricos individuales
print(round(p_5a, 4))
print(round(p_5b, 4))
print(round(p_5c, 4))
print(round(p_5d, 4))
print(round(p_6a, 4))
print(round(p_6b, 4))
print(round(p_6c, 4))
print(round(p_7a, 4))
print(round(p_7b, 4))
print(round(val_7c, 2))



