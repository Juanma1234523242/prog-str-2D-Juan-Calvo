package prue2;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalValidos = 0;
        int totalPermitidos = 0;
        int totalDenegados = 0;

        while (true) {

            System.out.println("Código de usuario (o SALIR para terminar):");
            String codigo = sc.nextLine();

            if (codigo.equals("SALIR")) {
                break;
            }

            if (!esCodigoValido(codigo)) {
                System.out.println("Código inválido");
                continue;
            }

            totalValidos++;
     
            System.out.println("Tipo de usuario (true = alumno, false = externo):");

            if (!sc.hasNextBoolean()) {
                System.out.println("Tipo inválido");
                return;
            }

            boolean esAlumno = sc.nextBoolean();

         
            System.out.println("Hora de entrada (0..23):");

            if (!sc.hasNextInt()) {
                System.out.println("Hora inválida");
                return;
            }

            int hora = sc.nextInt();
            sc.nextLine(); 
            if (hora < 0 || hora > 23) {
                System.out.println("Hora inválida");
                return;
            }

            if (hora >= 21) {
                System.out.println("Biblioteca cerrada");
                break;
            }

            if (esHorarioPermitido(hora, esAlumno)) {
                System.out.println("Acceso permitido");
                totalPermitidos++;
            } else {
                System.out.println("Acceso denegado");
                totalDenegados++;
            }
        }

        System.out.println("\n--- RESUMEN ---");
        System.out.println("Total registros válidos: " + totalValidos);
        System.out.println("Total permitidos: " + totalPermitidos);
        System.out.println("Total denegados: " + totalDenegados);

        if (totalValidos > 0) {
            double porcentaje = (double) totalPermitidos / totalValidos * 100;
            System.out.printf("Porcentaje de permitidos: %.2f%%\n", porcentaje);
        } else {
            System.out.println("Porcentaje de permitidos: 0.00%");
        }

        sc.close();
    }

    static boolean esCodigoValido(String codigo) {

        if (codigo == null) return false;

        if (codigo.isBlank()) return false;

        if (codigo.length() != 6) return false;

        for (int i = 0; i < codigo.length(); i++) {
            char c = codigo.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        return true;
    }

    static boolean esHorarioPermitido(int hora, boolean esAlumno) {

        if (esAlumno) {
            return hora >= 8 && hora <= 20;
        } else {
            return hora >= 10 && hora <= 18;
        }
    }
}