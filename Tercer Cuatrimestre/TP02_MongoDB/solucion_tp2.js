// ==========================================
// TECNICATURA UNIVERSITARIA EN PROGRAMACIÓN - UTN
// Práctico 2: Modelado y diseño NoSQL (MongoDB)
// Estudiante: Franco Stefano Ghiossi Hrebin
// ==========================================

use plataforma_educativa

// ------------------------------------------
// ACTIVIDAD 1: Plataforma Educativa (Patrón Híbrido)
// ------------------------------------------

// a) Crear e insertar cursos
db.cursos.insertMany([
  {
    _id: ObjectId("65f1a2b3c4d5e6f7a8b9c0d1"),
    nombre: "Bases de Datos II",
    codigo: "BD2026",
    docente: "Prof. García",
    evaluaciones_resumen: { promedio_general: 8.5, total_evaluaciones: 2 }
  },
  {
    _id: ObjectId("65f1a2b3c4d5e6f7a8b9c0d2"),
    nombre: "Programación Orientada a Objetos",
    codigo: "POO2026",
    docente: "Prof. Martínez",
    evaluaciones_resumen: { promedio_general: 7.0, total_evaluaciones: 2 }
  }
]);

// b) Crear e insertar evaluaciones
db.evaluaciones.insertMany([
  {
    curso_id: ObjectId("65f1a2b3c4d5e6f7a8b9c0d1"),
    estudiante: "Franco Ghiossi",
    titulo: "Parcial 1 - NoSQL",
    nota: 9.0,
    fecha: "2026-05-10"
  },
  {
    curso_id: ObjectId("65f1a2b3c4d5e6f7a8b9c0d1"),
    estudiante: "Lucas Gómez",
    titulo: "Parcial 1 - NoSQL",
    nota: 8.0,
    fecha: "2026-05-10"
  },
  {
    curso_id: ObjectId("65f1a2b3c4d5e6f7a8b9c0d2"),
    estudiante: "Sofia Rossi",
    titulo: "TP Integrador Java",
    nota: 7.0,
    fecha: "2026-05-12"
  },
  {
    curso_id: ObjectId("65f1a2b3c4d5e6f7a8b9c0d2"),
    estudiante: "Franco Ghiossi",
    titulo: "TP Integrador Java",
    nota: 7.0,
    fecha: "2026-05-12"
  }
]);

// c) Consulta: Obtener curso específico con su resumen
db.cursos.find({ _id: ObjectId("65f1a2b3c4d5e6f7a8b9c0d1") });

// d) Consulta: Obtener evaluaciones detalladas de un curso
db.evaluaciones.find({ curso_id: ObjectId("65f1a2b3c4d5e6f7a8b9c0d1") });

// e) Agregación: Promedio de notas por curso
db.evaluaciones.aggregate([
  {
    $group: {
      _id: "$curso_id",
      promedio_calculado: { $avg: "$nota" },
      total_evaluaciones: { $sum: 1 }
    }
  }
]);

// ------------------------------------------
// ACTIVIDAD 2: Estudiante-Tutor (Muchos a Muchos)
// ------------------------------------------

// a) Crear estudiantes
db.estudiantes.insertMany([
  { _id: ObjectId("65f2a2b3c4d5e6f7a8b9c0e1"), nombre: "Franco Ghiossi", legajo: 12345 },
  { _id: ObjectId("65f2a2b3c4d5e6f7a8b9c0e2"), nombre: "Maria Fernandez", legajo: 12346 },
  { _id: ObjectId("65f2a2b3c4d5e6f7a8b9c0e3"), nombre: "Mateo Lopez", legajo: 12347 }
]);

// b) Crear tutores
db.tutores.insertMany([
  { _id: ObjectId("65f2a2b3c4d5e6f7a8b9c0f1"), nombre: "Lic. Ana Torres", especialidad: "Sistemas" },
  { _id: ObjectId("65f2a2b3c4d5e6f7a8b9c0f2"), nombre: "Ing. Carlos Ruiz", especialidad: "Programación" }
]);

// c) Crear colección asociativa 'tutorias'
db.tutorias.insertMany([
  {
    estudiante_id: ObjectId("65f2a2b3c4d5e6f7a8b9c0e1"),
    tutor_id: ObjectId("65f2a2b3c4d5e6f7a8b9c0f1"),
    fecha_inicio: "2026-03-01",
    tipo_acompanamiento: "académico"
  },
  {
    estudiante_id: ObjectId("65f2a2b3c4d5e6f7a8b9c0e2"),
    tutor_id: ObjectId("65f2a2b3c4d5e6f7a8b9c0f1"),
    fecha_inicio: "2026-03-15",
    tipo_acompanamiento: "motivacional"
  },
  {
    estudiante_id: ObjectId("65f2a2b3c4d5e6f7a8b9c0e1"),
    tutor_id: ObjectId("65f2a2b3c4d5e6f7a8b9c0f2"),
    fecha_inicio: "2026-04-01",
    tipo_acompanamiento: "técnico"
  }
]);

// d) Consultar estudiantes de un tutor específico
db.tutorias.aggregate([
  { $match: { tutor_id: ObjectId("65f2a2b3c4d5e6f7a8b9c0f1") } },
  {
    $lookup: {
      from: "estudiantes",
      localField: "estudiante_id",
      foreignField: "_id",
      as: "datos_estudiante"
    }
  },
  { $unwind: "$datos_estudiante" },
  {
    $project: {
      _id: 0,
      estudiante: "$datos_estudiante.nombre",
      legajo: "$datos_estudiante.legajo",
      tipo_acompanamiento: 1,
      fecha_inicio: 1
    }
  }
]);

// ------------------------------------------
// ACTIVIDAD 3: Biblioteca Digital (Recursos)
// ------------------------------------------

// a) Crear recursos compartidos
db.recursos.insertMany([
  {
    _id: ObjectId("65f3a2b3c4d5e6f7a8b9c001"),
    titulo: "Guía de Sintaxis MongoDB",
    tipo: "PDF",
    url: "https://biblioteca.utn.edu.ar/nosql.pdf"
  },
  {
    _id: ObjectId("65f3a2b3c4d5e6f7a8b9c002"),
    titulo: "Video Tutorial de Aggregation Pipeline",
    tipo: "Video",
    url: "https://biblioteca.utn.edu.ar/video-aggregation"
  }
]);

// b) Crear materias que referencian recursos
db.materias.insertMany([
  {
    _id: ObjectId("65f3a2b3c4d5e6f7a8b9c011"),
    nombre: "Bases de Datos II",
    recursos_ids: [
      ObjectId("65f3a2b3c4d5e6f7a8b9c001"),
      ObjectId("65f3a2b3c4d5e6f7a8b9c002")
    ]
  },
  {
    _id: ObjectId("65f3a2b3c4d5e6f7a8b9c012"),
    nombre: "Administración de Bases de Datos",
    recursos_ids: [
      ObjectId("65f3a2b3c4d5e6f7a8b9c001")
    ]
  }
]);

// c) Cantidad de materias que usan un recurso específico
db.materias.countDocuments({
  recursos_ids: ObjectId("65f3a2b3c4d5e6f7a8b9c001")
});

// d) Listar materias que usan un recurso específico
db.materias.find(
  { recursos_ids: ObjectId("65f3a2b3c4d5e6f7a8b9c001") },
  { nombre: 1, _id: 0 }
);

// e) Agregar nuevo recurso a materia existente
db.recursos.insertOne({
  _id: ObjectId("65f3a2b3c4d5e6f7a8b9c003"),
  titulo: "CheatSheet de Modifiers y Operadores",
  tipo: "Enlace",
  url: "https://biblioteca.utn.edu.ar/cheatsheet.html"
});

db.materias.updateOne(
  { _id: ObjectId("65f3a2b3c4d5e6f7a8b9c011") },
  { $push: { recursos_ids: ObjectId("65f3a2b3c4d5e6f7a8b9c003") } }
);
