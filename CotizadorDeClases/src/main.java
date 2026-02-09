mport java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {

//I-P-O
        Scanner sc= new Scanner(System.in);
        InputDataValidator inputDataValidator = new InputDataValidator();
        Ticket ticket1 = new Ticket();//Creacion de objeto de la clase Ticket

//Input
        int cantidad= inputDataValidator.getValidInt(sc, "Ingresa la cantidad de productos");
//Process
        ticket1.process(cantidad);
//Output
        ticket1.imprimirTicket(cantidad);



    }
}