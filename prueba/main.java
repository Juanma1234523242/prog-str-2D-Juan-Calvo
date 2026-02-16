package prueba;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Cuantas horas te estacionaste?");
        int horas = sc.nextInt();

        System.out.println("Cual es la tarifa por hora?");
        double tarifa = sc.nextDouble();

        System.out.println("Tienes boleto de descuento? (true/false)");
        boolean boleto = sc.nextBoolean();

        if (!validarHoras(horas)) {
            System.out.println("Error: Las horas deben ser mayores a 0.");
            return;
        }

        if (!validarTarifa(tarifa)) {
            System.out.println("Error: La tarifa debe ser mayor a 0.");
            return;
        }

      
        double total = horas * tarifa;
        total = aplicarDescuentoBoleto(total, boleto);
        total = aplicarDescuentoHoras(total, horas);
        System.out.println("El total a pagar es: " + total);

        sc.close();
    }

    
    static boolean validarHoras(int horas) {
        return horas > 0;
    }


    static boolean validarTarifa(double tarifa) {
        return tarifa > 0;
    }
   
    static double aplicarDescuentoHoras(double total, int horas) {
        if (horas > 10) {
            total = total * 0.88; 
        }
        return total;
    }

    static double aplicarDescuentoBoleto(double total, boolean tieneBoleto) {
        if (tieneBoleto) {
            total = total * 0.95;
        }
        return total;
    }
}

