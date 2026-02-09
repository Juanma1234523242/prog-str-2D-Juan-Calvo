import java.util.Scanner;

public class ImputDataValidator {

    /**
     * Lee un string no vacío
     */
    public static String leerTextoNoVacio(Scanner scanner, String message) {
        String userInput;
        do {
            System.out.print(message);
            userInput = scanner.nextLine().trim();
            if (userInput.isEmpty()) {
                System.out.println("Error: El texto no puede estar vacío.");
            }
        } while (userInput.isEmpty());
        return userInput;
    }

    /**
     * Lee un double dentro de un rango específico
     */
    public static double leerDoubleEnRango(
            Scanner scanner, String message, double minValue, double maxValue) {

        double number;
        do {
            System.out.print(message + " [" + minValue + " - " + maxValue + "]: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Error: Pon un número decimal válido.");
                System.out.print(message + " [" + minValue + " - " + maxValue + "]: ");
                scanner.next();
            }
            number = scanner.nextDouble();
            if (number < minValue || number > maxValue) {
                System.out.println("Error: El valor debe estar entre " + minValue + " y " + maxValue);
            }
        } while (number < minValue || number > maxValue);

        scanner.nextLine(); // consumir salto de línea
        return number;
    }

    /**
     * Lee un int dentro de un rango específico
     */
    public static int leerIntEnRango(
            Scanner scanner, String message, int minValue, int maxValue) {

        int number;
        do {
            System.out.print(message + " [" + minValue + " - " + maxValue + "]: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Pon un número entero válido.");
                System.out.print(message + " [" + minValue + " - " + maxValue + "]: ");
                scanner.next();
            }
            number = scanner.nextInt();
            if (number < minValue || number > maxValue) {
                System.out.println("Error: El valor debe estar entre " + minValue + " y " + maxValue);
            }
        } while (number < minValue || number > maxValue);

        scanner.nextLine(); // consumir salto de línea
        return number;
    }

    /**
     * Lee un boolean (solo acepta true/false)
     */
    public static boolean leerBoolean(Scanner scanner, String message) {
        String userInput;
        do {
            System.out.print(message);
            userInput = scanner.nextLine().trim().toLowerCase();
            if (!userInput.equals("true") && !userInput.equals("false")) {
                System.out.println("Error: Debe ingresar 'true' o 'false'.");
            }
        } while (!userInput.equals("true") && !userInput.equals("false"));

        return Boolean.parseBoolean(userInput);
    }
}