import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular area de un rectangulo");
            System.out.println("3. Convertir C a F");
            System.out.println("4. Calcular area de un circulo");
            System.out.println("5. Salir");
            System.out.println("Elige una opcion: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    System.out.println("\n Calculo de IMC ");
                    double peso = obtenerDouble(scanner, "Ingresa tu peso en Kilogramos:");
                    double altura = obtenerDouble(scanner, "Ingresa tu altura en Metros:");
                    double imc = calcularIMC(peso, altura);
                    System.out.printf("Tu IMC es: " + imc);
                    break;

                case 2:

                    System.out.println("\n Area de Rectangulo ");
                    double base = obtenerDouble(scanner, "Ingresa la base del rectangulo:");
                    double alturaRecta = obtenerDouble(scanner, "Ingresa la altura del rectangulo:");
                    double areaRect = calcularAreaRectangulo(base, alturaRecta);
                    System.out.println("El area del rectangulo es: " + areaRecta);
                    break;

                case 3:

                    System.out.println("\nConversion C a F ");
                    double celsius = obtenerDouble(scanner, "Ingresa los grados Celsius:");
                    double fahrenheit = convertirCelsiusAFahrenheit(celsius);
                    System.out.println(celsius + " grados Celsius son " + fahrenheit + " grados Fahrenheit.");
                    break;

                case 4:

                    System.out.println("\n Area de Circulo ");
                    double radio = obtenerDouble(scanner, "Ingresa el radio del circulo:");
                    double areaCirc = calcularAreaCirculo(radio);
                    System.out.printf("El area del circulo es: " + areaCirc);
                    break;

                case 5:
                    System.out.println("Saliendo del prog thx");
                    break;

                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
            }

        } while (choice != 5);

        scanner.close();
    }

    /**
     * Metodo auxiliar para capturar un double desde consola mostrando un mensaje.
     * @param sc Objeto Scanner para leer la entrada.
     * @param mensaje Texto que se mostrara al usuario antes de pedir el dato.
     * @return El numero decimal (double) ingresado por el usuario.
     */
    public static double obtenerDouble(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextDouble();
    }


    /**
     * Calcula el Indice de Masa Corporal (IMC) basado en peso y altura.
     * @param pesoKG Peso de la persona en kilogramos.
     * @param alturaM Altura de la persona en metros.
     * @return El valor del IMC calculado (peso / altura^2).
     */
    public static double calcularIMC(double pesoKG, double alturaM) {
        return pesoKG / (alturaM * alturaM);
    }

    /**
     * Calcula el area de un rectangulo dadas su base y altura.
     * @param base Longitud de la base del rectangulo.
     * @param altura Longitud de la altura del rectangulo.
     * @return El area total del rectangulo.
     */
    public static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Convierte una temperatura de grados Celsius a Fahrenheit.
     * @param celsius Temperatura en grados Celsius.
     * @return La temperatura equivalente en grados Fahrenheit usando la formula (C * 1.8) + 32.
     */
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Calcula el area de un circulo dado su radio.
     * @param radio El radio del circulo.
     * @return El area calculada usando la formula PI * radio^2.
     */
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }
}