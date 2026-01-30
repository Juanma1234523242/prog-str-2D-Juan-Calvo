import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        int CF = 0, FC = 0, KMMiL = 0, MillKil = 0;
        int totalConversiones = 0;

        do {
            System.out.println("Manual de Conversion");
            System.out.println("1) C a F");
            System.out.println("2) F a C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");
            System.out.print("Elige una opcion (1-5): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Opcion no valida. Ingresa un número.");
                scanner.next();
                System.out.print("Elige una opcion (1-5): ");
            }

            opcion = scanner.nextInt();

            if (opcion < 1 || opcion > 5) {
                System.out.println("ingresa un numero de los mostrados.");
            }

            if (opcion == 5) {
                break;
            }

            System.out.print("Ingresa el valor a convertir: ");

            while (!scanner.hasNextDouble()) {
                System.out.println("Ingresa un valor numerico");
                scanner.next();
                System.out.print("Ingresa el valor a convertir: ");
            }

            double valor = scanner.nextDouble();
            double resultado = 0;

            switch (opcion) {
                case 1:
                    resultado = valor * 1.8 + 32;
                    CF++;
                    break;
                case 2:
                    resultado = (valor - 32) / 1.8;
                    FC++;
                    break;
                case 3:
                    resultado = valor * 0.621371;
                    KMMiL++;
                    break;
                case 4:
                    resultado = valor * 1.60934;
                    MillKil++;
                    break;
            }

            totalConversiones++;
            System.out.println("Resultado: " + resultado);

        } while (opcion != 5);

        System.out.println("contador de usos");
        System.out.println("Total de conversiones: " + totalConversiones);
        System.out.println("°C a °F: " + CF);
        System.out.println("°F a °C: " + FC);
        System.out.println("Km a Millas: " + KMMiL);
        System.out.println("Millas a Km: " + MillKil);

        scanner.close();
    }
}