public class Ticket {

    public Ticket(){} //Constructor

    private final double IVA=0.16;
    private final double PRECIO_PRODUCTO=10;
    public double total;
    public double subtotal;
//private final double DESCUENTO=0.10;

    public double calcularSubtotal(int cantidad){
        return cantidad*PRECIO_PRODUCTO;
    }

    public double calcularIva(double subtotal){
        return subtotal*IVA;
    }

    public double calcularTotal(double subtotal){
        return subtotal + calcularIva(subtotal);
    }

    public void imprimirTicket(int cantidad, double subtotal, double ivaCalculado, double total){

        System.out.println("Cantidad: "+cantidad);
        System.out.println("Subtotal: "+subtotal);
        System.out.println("Iva: "+ivaCalculado);
        System.out.println("Total: "+total);

    }
}