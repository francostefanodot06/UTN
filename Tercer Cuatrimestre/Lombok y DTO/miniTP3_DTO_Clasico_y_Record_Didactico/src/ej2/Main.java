package ej2;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Ana", "García", "ana@mail.com", "Rivadavia", 1234);
        Persona p2 = new Persona("Carlos", "Ruiz", "carlos@mail.com", "Corrientes", 567);
        Persona p3 = new Persona("María", "Torres", "maria@mail.com", "Belgrano", 890);

        // Persona 1
        DomicilioDto dom1 = new DomicilioDto(p1.getCalle(), p1.getNumero());
        PersonaDto dto1 = new PersonaDto(p1.getNombre(), dom1);
        PersonaRecordDto rec1 = new PersonaRecordDto(p1.getNombre(), dom1);

        System.out.println("Persona 1");
        System.out.println("[DTO clásico] " + dto1);
        System.out.println("[Record DTO] " + rec1);

        // Persona 2
        DomicilioDto dom2 = new DomicilioDto(p2.getCalle(), p2.getNumero());
        PersonaDto dto2 = new PersonaDto(p2.getNombre(), dom2);
        PersonaRecordDto rec2 = new PersonaRecordDto(p2.getNombre(), dom2);

        System.out.println("Persona 2");
        System.out.println("[DTO clásico] " + dto2);
        System.out.println("[Record DTO] " + rec2);

        // Persona 3
        DomicilioDto dom3 = new DomicilioDto(p3.getCalle(), p3.getNumero());
        PersonaDto dto3 = new PersonaDto(p3.getNombre(), dom3);
        PersonaRecordDto rec3 = new PersonaRecordDto(p3.getNombre(), dom3);

        System.out.println("Persona 3");
        System.out.println("[DTO clásico] " + dto3);
        System.out.println("[Record DTO] " + rec3);
    }
}

/*
 ===================================================================================
 COMENTARIO OBLIGATORIO - EJERCICIO 2
 ===================================================================================
 1. ¿Cómo cambia el formato de toString() en la consola?
    - En PersonaDto (POJO clásico), el toString() sigue la estructura personalizada definida mediante llaves y comillas simples alrededor de los valores de tipo String:
      PersonaDto{nombre='Ana', domicilio=DomicilioDto{calle='Rivadavia', numero=1234}}[cite: 23]
    - En PersonaRecordDto (Record DTO), el toString() es autogenerado por el compilador con el formato de clase con corchetes y sin comillas simples alrededor de los textos:
      PersonaRecordDto[nombre=Ana, domicilio=DomicilioDto{calle='Rivadavia', numero=1234}][cite: 20, 23, 26]

 2. ¿Cómo se accede al campo nombre en cada caso?
    - En PersonaDto (POJO) se requiere llamar al método getter convencional: personaDto.getNombre()[cite: 19, 26].
    - En PersonaRecordDto (Record) se accede directamente mediante el método accesor sin prefijo: personaRecordDto.nombre()[cite: 19, 26].

 3. ¿Qué diferencia existe en la cantidad de código necesario para definir cada tipo?
    - En PersonaDto (POJO) es necesario declarar los atributos privados, escribir el constructor explícito, definir getters para cada campo y sobrescribir el método toString() (aproximadamente 20 a 25 líneas de código repetitivo/boilerplate)[cite: 17, 19].
    - En PersonaRecordDto (Record) se declara la estructura completa, constructor, accesores, equals, hashCode y toString en una única línea de código[cite: 17, 19, 28].
 ===================================================================================
*/