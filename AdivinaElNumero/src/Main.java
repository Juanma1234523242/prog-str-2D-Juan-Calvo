import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int CF = 0;
        int FC = 0;
        int KILMILL = 0;
        int MILLKIL = 0;
        int totalConversiones = 0;

        int opcion;

        do {
            System.out.println("Manual de Conversion");
            System.out.println("1/C a F");
            System.out.println("2/F a C");
            System.out.println("3/Km a Millas");
            System.out.println("4/Millas a Km");
            System.out.println("5/Salir");
            System.out.print("Elige una opcion (1-5): ");


            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else {
                System.out.println("Ingresa una opcion numerica");
                scanner.next();
                continue;
            }

            if (opcion < 1 || opcion > 5) {
                System.out.println("Ingresa un numero entre las opciones");
                continue;
            }

            if (opcion == 5) {
                break;
            }

            System.out.print("Ingresa el valor a convertir ");

            if (!scanner.hasNextDouble()) {
                System.out.println("Dato no numerico");
                scanner.next();
                continue;
            }

            double numeroA = scanner.nextDouble();
            double resultado = 0;

            switch (opcion) {
                case 1:
                    resultado = numeroA * 1.8 + 32;
                    CF++;
                    break;
                case 2:
                    resultado = (numeroA - 32) / 1.8;
                    FCC++;
                    break;
                case 3:
                    resultado = numeroA * 0.621371;
                    KILMILL++;
                    break;
                case 4:
                    resultado = numeroA * 1.60934;
                    MILLKIL++;
                    break;
            }

            totalConversiones++;
            System.out.println("Resultado: " + resultado);

        } while (true);

        System.out.println("contador de converciones solicitados");
        System.out.println("Total de conversiones: " + totalConversiones);
        System.out.println("C a F: " + CF);
        System.out.println("F a C: " + FC);
        System.out.println("Km a Millas: " + KILMILL);
        System.out.println("Millas a Km: " + MILLKIL);

        scanner.close();
    }
}