// Callbacks: El Punto de Partida
function procesarUsuario(nombre, callback) {
  console.log("Procesando usuario:", nombre);
  callback();
}

procesarUsuario("Ana", () => {
  console.log("Usuario procesado con éxito");
});

function buscarUsuario(id, callback) {
  const usuarios = [
    { id: 1, nombre: "Ana" },
    { id: 2, nombre: "Luis" },
  ];

  // Simulamos un retraso (como si fuera una      //consulta a BD)
  setTimeout(() => {
    const usuario = usuarios.find((u) => u.id === id);

    if (usuario) {
      // Primer parámetro null = no hay error
      callback(null, usuario);
    } else {
      // Pasamos un error como primer parámetro
      callback("Usuario no encontrado", null);
    }
  }, 1000);
}
buscarUsuario(1, (error, usuario) => {
  if (error) {
    console.log("Error:", error);  
  } else {     
    console.log("Usuario encontrado:", usuario.nombre);
  }
});

// Callbach Hell
pedirPizza((err, pizza) => {
    if (!err) {
        pedirBebida((err, bebida) => {
            if (!err) {
                pedirPostre((err, postre) => {
                    if (!err) {
                        console.log("Cena completa:", 
                                   pizza, bebida, postre);
                    }
                });
            }
        });
    }
});

// Promesas: La Evolución Natural
const promesa = new Promise((resolve, reject) => {
  let exito = true;
  if (exito) {
    resolve("Operación exitosa");
  } else {
    reject("Algo salió mal ");
  }
});

promesa
  .then((resultado) => console.log(resultado))
  .catch((error) => console.log(error));

// Encadenando Promesas
// Funciones que devuelven promesas
function pedirPizza() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve("¡Pizza lista!");
    }, 2000); // Simula 2 segundos para preparar la pizza
  });
}
function pedirBebida() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve("¡Bebida entregada!");
    }, 1000); // Simula 1 segundo para entregar la bebida
  });
}
function pedirPostre() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve("¡Postre servido!");
    }, 1500); // Simula 1.5 segundos para servir el postre
  });
}

// Funciones que devuelven promesas
function pedirPizza() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve("¡Pizza lista!");
    }, 2000); // Simula 2 segundos para preparar la pizza
  });
}
function pedirBebida() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve("¡Bebida entregada!");
    }, 1000); // Simula 1 segundo para entregar la bebida
  });
}
function pedirPostre() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve("¡Postre servido!");
    }, 1500); // Simula 1.5 segundos para servir el postre
  });
}

// Async/Await: La Sintaxis del Futuro
// Con Promesas
function cenaCompleta() {
    return pedirPizza()
        .then(pizza => {
            console.log(pizza);
            return pedirBebida();
        })
        .then(bebida => {
            console.log(bebida);
            return pedirPostre();
        })
        .then(postre => {
            console.log(postre);
        });
}

// Con Async/Await
async function cenaCompleta() {
 try {
 const pizza = await pedirPizza();
 console.log(pizza);
 
 const bebida = await pedirBebida();
 console.log(bebida);

 const postre = await pedirPostre();
 console.log(postre);
 } catch (error) {
 console.log("Error:", error);
 }
}

// Ejemplo Real: Peticiones HTTP
// Usando promesas
fetch('https://jsonplaceholder.typicode.com/users')
    .then(res => res.json())
    .then(data => {
        console.log('Usuarios:', data);
        // Procesar datos aquí
    })
    .catch(err => {
        console.error('Error:', err);
    });

// Usando Async/Await
async function cargarUsuarios() {
    try {
        const res = await fetch('https://jsonplaceholder.typicode.com/users');
        const data = await res.json();
        console.log('Usuarios:', data);
        // Procesar datos aquí
    } catch (err) {
        console.error('Error:', err);
    }
}
cargarUsuarios();