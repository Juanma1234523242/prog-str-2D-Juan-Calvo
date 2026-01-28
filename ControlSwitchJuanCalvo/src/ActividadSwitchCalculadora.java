import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora");
        System.out.println("1/Sumar");
        System.out.println("2/Restar");
        System.out.println("3/Multiplicar");
        System.out.println("4/Dividir");
        System.out.println();

        System.out.print("Elige una opcion del 1--4: ");
        int opcion = scanner.nextInt();

        System.out.print("Ingresa el primer numero ");
        double numeroA = scanner.nextDouble();

        System.out.print("Ingresa el segundo numero ");
        double numeroB = scanner.nextDouble();

        System.out.println();

        double resultado = 0;
        boolean resultadoValido = true;

        switch (opcion) {
            case 1:
                resultado = numeroA + numeroB;
                System.out.println("Operación seleccionada Sumar");
                break;

            case 2:
                resultado = numeroA - numeroB;
                System.out.println("Operacion seleccionada Restar");
                break;

            case 3:
                resultado = numeroA * numeroB;
                System.out.println("Operacion seleccionada Multiplicar");
                break;

            case 4:
                System.out.println("Operacion seleccionada Dividir");
                if (numeroB == 0) {
                    System.out.println("error no es posible la division de 0");
                    resultadoValido = false;
                } else {
                    resultado = numeroA / numeroB;

                }
                break;

            default:
                resultadoValido = false;
                System.out.println("Opción no valida");
                break;
        }

        System.out.println("Valores colocados:");
        System.out.println("A = " + numeroA);
        System.out.println("B = " + numeroB);

        if (resultadoValido) {
            System.out.println("Resultado: " + resultado);
        }else{
            System.out.println(" ");
        }

        scanner.close();
    }
}