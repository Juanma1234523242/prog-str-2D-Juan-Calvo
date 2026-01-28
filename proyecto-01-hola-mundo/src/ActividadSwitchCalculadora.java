import java.util.Scanner;

public class  {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcion;
        double a, b;
        double resultado = 0;
        boolean hayResultado = true;
        String operacion = "";

        // Mostrar menú
        System.out.println("===== MENÚ =====");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");
        System.out.print("Elige una opción: ");
        opcion = scanner.nextInt();

        // Pedir valores
        System.out.print("Ingresa el valor de a: ");
        a = scanner.nextDouble();

        System.out.print("Ingresa el valor de b: ");
        b = scanner.nextDouble();

        // Selección de operación
        switch (opcion) {
            case 1:
                operacion = "Suma";
                resultado = a + b;
                break;

            case 2:
                operacion = "Resta";
                resultado = a - b;
                break;

            case 3:
                operacion = "Multiplicación";
                resultado = a * b;
                break;

            case 4:
                operacion = "División";
                if (b == 0) {
                    System.out.println("No se puede dividir entre cero");
                    hayResultado = false;
                } else {
                    resultado = a / b;
                }
                break;

            default:
                System.out.println("Opción inválida");
                hayResultado = false;
                break;
        }

        // Imprimir resultados si aplica
        if (hayResultado && opcion >= 1 && opcion <= 4) {
            System.out.println("\n--- Resultado ---");
            System.out.println("Operación: " + operacion);
            System.out.println("Valor de a: " + a);
            System.out.println("Valor de b: " + b);
            System.out.println("Resultado: " + resultado);
        }

        scanner.close();
    }
}