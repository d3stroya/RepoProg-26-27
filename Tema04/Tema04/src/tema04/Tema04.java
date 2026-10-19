package tema04;

import java.util.Scanner;
import operaciones.Operaciones;



/**
 * En esta clase vamos a aprender a utilizar métodos estáticos,
 * que permiten encapsular un código que resuleve 1 problema concreto
 * para reutilizarlo siempre que lo necesitemos para resolver ese problema.
 * 
 * Tienen esta estructura:
 * 
 * public static [tipo de dato que devuelve] [nombre del método] ([parámetros]) {
 * 
 *      [código que resuleve un problema concreto]
 * 
 * }
 * 
 * ¡Importante!: acostumbrarnos a comentar los métodos con Javadoc.
 * 
 * @author d3stroya
 */
public class Tema04 {
    // Escribo por pantalla un saludo. (No recibe parámetros. No devuelve nada).
    /**
     * Método que imprimer por pantalla "hola, mundo".
     */
    public static void saludar() {
        System.out.println("Hola, mundo");
    }

    
    // Pido un número entero al usuario. (No recibe parámetros. Devuelve un número entero).    
    /**
     * Método que pide al usuario un número entero.
     * 
     * @return el número que escribe el usuario.
     */
    public static int pedirNumero() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Número: ");
        return entrada.nextInt();        
    }
    
    // Multiplico dos números dados. (Recibe dos números. Devuelve el resultado).
    /**
     * Método que multiplica dos números recibidos por parámetro.
     * 
     * @param num1
     * @param num2
     * 
     * @return el resultado.
     */
    public static int multiplicar(int num1, int num2) {
        return num1 * num2;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Llamo al método saludar()
        saludar();
        
        
        // Llamo al método pedirNumero() dos veces 
        // y guardo los valores recibidos en dos variables.
        // (Reutilizo el método porque quiero hacer dos veces lo mismo).
        int num1 = pedirNumero();
        int num2 = pedirNumero();

        
        // Llamo al método multiplicar(int num1, int num2) y (¡IMPORTANTE!) lo guardo en una variable
        int resultado = multiplicar(num1, num2);       
        
        // Imprimo el resultado
        System.out.println("El resultado es: " + resultado);
        System.out.println(multiplicar(num1, num2));
        
        // Otra forma de hacer lo mismo (más avanzada).
        System.out.println("\nMultiplicar pasando método por parámetro:");
        System.out.println(multiplicar(pedirNumero(), pedirNumero()));
                
        // Si llamo a multiplicar(int num1, int num2) directamente, no se mostrará nada por pantalla.
        multiplicar(num1, num2);
        
        // Llamo al método sumar() de la clase Operaciones, que está en el paquete operaciones
        Operaciones.sumar(num1, num2);
        
    }    

}
