package programacionestructurada.actividad1;

import java.util.Scanner;

public class ProgramacionEstructuradaActividad1 {
    public static void main(String[] args) {

        System.out.println("----- OPERADORES RELACIONALES -----");
        operadoresRelacionales();

        System.out.println("----- USAR EQUALS -----");
        usarEquals();

        System.out.println("----- CALCULADORA (condicional multiple) -----");
        condicionalMultiple();
    }


    public static void operadoresRelacionales() {
        System.out.println("4 < 5:  " + (4 < 5));
        System.out.println("5 <= 5: " + (5 <= 5));
        System.out.println("4 > 5:  " + (4 > 5));
        System.out.println("5 >= 5: " + (5 >= 5));
        System.out.println("4 == 5: " + (4 == 5));
        System.out.println("4 != 5: " + (4 != 5));
        System.out.println();
    }

    public static void usarEquals() {
        System.out.print("Adivina el nombre a comparar: ");
        String nombreDePersona = new Scanner(System.in).nextLine();
        String nombreEsperado = "Juan";

        if (nombreDePersona.equalsIgnoreCase(nombreEsperado)) {
            System.out.println("FELICIDADES. Ha adivinado el nombre!");
            System.out.println();
        } else {
            System.out.println("Mala Suerte, el nombre era Juan. Mejor suerte la proxima.");
            System.out.println();
        }
    }

    public static void condicionalMultiple() {
        int num1, num2;

        System.out.print("Ingresá numero 1: ");
        num1 = Integer.parseInt(new Scanner(System.in).nextLine());

        System.out.print("Ingresa numero 2: ");
        num2 = Integer.parseInt(new Scanner(System.in).nextLine());

        System.out.print("Seleccioná la operación ( + , - , x , / ): ");
        switch (new Scanner(System.in).nextLine().charAt(0)) {

            case '+':
                System.out.println("La SUMA es: " + (num1 + num2));
                break;

            case '-':
                System.out.println("La RESTA es: " + (num1 - num2));
                break;

            case 'x':
                System.out.println("El PRODUCTO es: " + (num1 * num2));
                break;

            case '/':
                if (num2 != 0) {
                    System.out.println("La DIVISION es: " + (num1 / num2));
                } else {
                    System.out.println("ERROR. No se puede dividir por 0");
                }
                break;

            default:
                System.out.println("OPCION INCORRECTA. Solo puede ingresar + , - , x , /");
                break;
        }
    }
    
}
