package tema03;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author d3stroya
 */
public class ControlDeExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        
        try {
            // Pedir un dato ( ¡¡ CONFLICTIVO !! )
            Scanner entrada = new Scanner(System.in);
            System.out.print("Introduzca su edad: ");
            int edad = entrada.nextInt();             
           
            // Mostrar ese dato
            System.out.println("Tu edad es " + edad);
        } catch(InputMismatchException e) {
            System.out.println("Dato no válido; debes introducir un número entero.");
        } finally {
            System.out.println("Dato pedido al usuario.");
        }
        
        
    }    

}
