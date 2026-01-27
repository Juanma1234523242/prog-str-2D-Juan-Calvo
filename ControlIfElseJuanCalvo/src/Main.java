import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int edad;
        int tarifa = 0;
        boolean esEstudiante;

        System.out.println("Ingresa tu edad:");
        edad = scanner.nextInt();

        System.out.println("¿Eres estudiante? (true/false):");
        esEstudiante = scanner.nextBoolean();

        if (edad <= 0 || edad >= 120) {
            System.out.println("Edad inválida");
        } else if (edad < 12) {
            tarifa = 50;
        } else if (edad >= 12 && edad <= 17) {
            if (esEstudiante) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        } else {
            if (esEstudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }

        if (edad > 0 && edad < 120) {
            System.out.println(
                    "Tienes una edad de " + edad +
                            ", estudiante: " + esEstudiante +
                            ", con una tarifa a pagar de $" + tarifa
            );
        }

        scanner.close();
    }
}
