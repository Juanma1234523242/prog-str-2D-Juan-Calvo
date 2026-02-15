package CRUDalumnos;

import java.util.Scanner;

public class InputDataValidator {
    
    /**
     * Captura una cadena de texto no vacía del usuario
     * @param sc Scanner para input
     * @param msg Mensaje a mostrar al usuario
     * @return String validado (no vacío)
     */
    public static String captureNonEmptyString(Scanner sc, String msg) {
        String texto;
        do {
            System.out.print(msg);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Error: La entrada no puede estar en blanco. Intenta de nuevo.");
            }
        } while (texto.isEmpty());
        return texto;
    }
    
    /**
     * Obtiene un número decimal dentro de un rango válido
     * @param sc Scanner para input
     * @param msg Mensaje a mostrar al usuario
     * @param min Valor mínimo permitido
     * @param max Valor máximo permitido
     * @return Valor double validado
     */
    public static double getValidatedDouble(Scanner sc, String msg, double min, double max) {
        double valor;
        do {
            System.out.print(msg + " [" + min + " - " + max + "]: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Error: Formato inválido. Por favor ingresa un número decimal.");
                System.out.print(msg + " [" + min + " - " + max + "]: ");
                sc.next();
            }
            valor = sc.nextDouble();
            if (valor < min || valor > max) {
                System.out.println("Error: Fuera de rango. Debes ingresar un valor entre " + min + " y " + max);
            }
        } while (valor < min || valor > max);
        sc.nextLine(); 
        return valor;
    }
    
    /**
     * Obtiene un número entero dentro de un rango válido
     * @param sc Scanner para input
     * @param msg Mensaje a mostrar al usuario
     * @param min Valor mínimo permitido
     * @param max Valor máximo permitido
     * @return Valor int validado
     */
    public static int getValidatedInteger(Scanner sc, String msg, int min, int max) {
        int valor;
        do {
            System.out.print(msg + " [" + min + " - " + max + "]: ");
            while (!sc.hasNextInt()) {
                System.out.println("Error: Entrada inválida. Ingresa un número entero.");
                System.out.print(msg + " [" + min + " - " + max + "]: ");
                sc.next();
            }
            valor = sc.nextInt();
            if (valor < min || valor > max) {
                System.out.println("Error: Selección fuera de rango. Valor válido: " + min + " a " + max);
            }
        } while (valor < min || valor > max);
        sc.nextLine(); 
        return valor;
    }

    public static int getIntegerGreaterThan(Scanner sc, String msg, int min) {
        int valor;
        do {
            System.out.print(msg + " (mín. " + min + "): ");
            while (!sc.hasNextInt()) {
                System.out.println("Error: Entrada inválida. Ingresa un número entero.");
                System.out.print(msg + " (mín. " + min + "): ");
                sc.next();
            }
            valor = sc.nextInt();
            if (valor < min) {
                System.out.println("Error: El valor debe ser mayor o igual a " + min);
            }
        } while (valor < min);
        sc.nextLine(); 
        return valor;
    }
    
    /**
     * Captura un valor booleano (true/false)
     * @param sc Scanner para input
     * @param msg Mensaje a mostrar al usuario
     * @return Valor boolean validado
     */
    public static boolean captureBoolean(Scanner sc, String msg) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine().trim().toLowerCase();
            if (!input.equals("true") && !input.equals("false")) {
                System.out.println("Error: Respuesta inválida. Ingresa 'true' o 'false'.");
            }
        } while (!input.equals("true") && !input.equals("false"));
        return Boolean.parseBoolean(input);
    }
}