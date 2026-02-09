import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {

        Scanner sc= new Scanner(System.in);
        InputDataValidator inputDataValidator= new InputDataValidator();
        Ticket ticket1 = new Ticket();//Creacion de objeto de la clase Ticket

        int cantidad= inputDataValidator.getValidInt(sc, "Ingresa la cantidad de productos");
        double subtotal = ticket1.calcularSubtotal(cantidad);
        double ivaCalculado = ticket1.calcularIva(subtotal);
        double total = ticket1.calcularTotal(subtotal);

        ticket1.imprimirTicket(cantidad, subtotal, ivaCalculado, total);



    }
}