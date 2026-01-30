import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Manual de Convercion");
            System.out.println("1/C a F");
            System.out.println("2/F a C");
            System.out.println("3/Km a Millas");
            System.out.println("4/Millas a Km");
            System.out.println("5/Salir");
            System.out.println();



            System.out.print("Elige una opcion del 1--5: ");
            int opcion = scanner.nextInt();

            if (opcion == 5){
                System.out.println("Saliendo...");
                break;

            }else{
                System.out.print("Ingresa el valor a covertir ");
                double numeroA = scanner.nextDouble();


                System.out.println();

                double resultado = 0;
                boolean resultadoValido = true;

                switch (opcion) {
                    case 1:
                        resultado = numeroA*1.8 +32;
                        System.out.println("Operación seleccionada Sumar");
                        break;

                    case 2:
                        resultado = (numeroA - 32)/1.8;
                        System.out.println("Operacion seleccionada Restar");
                        break;

                    case 3:
                        resultado = numeroA * 0.621371;
                        System.out.println("Operacion seleccionada Multiplicar");
                        break;

                    case 4:
                        resultado = numeroA * 1.60934;
                        System.out.println("Operacion seleccionada Dividir");

                        break;
                    case 5:
                        System.out.println("Saliendo, nos vemos");

                        break;

                    default:
                        resultadoValido = false;
                        System.out.println("Opcion no valida");
                        break;
                }

                System.out.println("Valores colocados:");
                System.out.println("A = " + numeroA);

                if (resultadoValido) {
                    System.out.println("Resultado: " + resultado);
                }else{
                    System.out.println(" ");
                }

            }

        }

        scanner.close();
    }
}