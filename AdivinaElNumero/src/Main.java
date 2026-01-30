import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int max = 100;
        int min = 1;

        int secreto = random.nextInt(100)+1;
        int intentos = 0;
        int intentosNoNumericos = 0;
        int intentosFueraRango = 0;
        int limiteIntentos = 7;
        boolean gano = false;
        System.out.println(secreto);
        System.out.println("Adivina el numero secreto (1-100)");

        while(intentos<limiteIntentos){

            int numero = obtenerNumeroValido(sc, "Intento: "+(intentos+1), min,max,intentosNoNumericos,intentosFueraRango );
            intentos++;

            if(numero == secreto){
                gano = true;
                break;
            } else if(numero > secreto){
                System.out.println("El numero que estas buscando es menor a "+ numero);
            } else if (numero < secreto) {
                System.out.println("El numero que estas buscando es mayor a "+numero);
            }
        }

        if(gano){
            System.out.println("Ganaste! En el intento: "+intentos);
        } else{
            System.out.println("NOOOO PERDISTE :(");
            System.out.println("El numero secreto era " + secreto + " tan facil...");

        }
    }

    public static int obtenerNumeroValido(Scanner sc, String mensaje, int min, int max,  int intentosNoNumericos,  int intentosFueraRango){
        int valor;
        while (true){
            System.out.println(mensaje);
            if(sc.hasNextInt()){
                valor = sc.nextInt();
                if(valor >= min && valor <= max){
                    return valor;
                }else{
                    System.out.println("El valor ingresado esta fuera de rango");
                    intentosFueraRango++;
                    System.out.println("Intentos fuera de rango " + intentosFueraRango);
                }
            }else{
                System.out.println("El dato ingresado no es numerico");
                intentosNoNumericos++;
                System.out.println("Intentos no numericos: " + intentosNoNumericos);
            }
            sc.next();
        }
    }
}