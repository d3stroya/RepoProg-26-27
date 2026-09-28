package tema02; // Paquete al que pertenece mi clase

// Importamos la clase Scanner con la sentencia import
import java.util.Scanner;



/**
 * Clase principal de repaso del Tema 2.
 * 
 * @author d3stroya
 */
public class Apuntes {
    // VARIABLES (globales)
    static int vida = 100;
    
    // CONSTANTES
    final static float GRAVEDAD = 9.8f;
    
    // ÁMBITO DE LAS VARIABLES
    public static void atacar() {
        int danio = 5;  // Variable local
        System.out.println("La vida del héreo ahora es de: " + (vida - danio));
    }
    
    /**
     * Método main (principal).
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hola mundo");
        
        System.out.println("La vida del héroe es: " + vida);
        
        System.out.println("La gravedad es: " + GRAVEDAD);
        
        
        // VARIABLES (locales)
        // Enteros
        byte edad;
        short distancia = 100;       
        int numMatricula = 2543;
        long numAlumnos = 30;
        
        System.out.println(vida - numMatricula);
        
        // Decimales
        float altura = 1.70f;
        double peso = 10.5;     
        
        // Booleanos
        boolean esEnReposo = true;
        
        // Caracteres
        char letra = 'A';
        
        
        
        // OPERACIONES        
        int resto = distancia % 2;
        System.out.println("El resto de dividir " + distancia + " / " + 2 + " es " + resto);
        
        System.out.print("¿Es la variable distancia un número par? ");
        boolean esPar = distancia % 2 == 0;       
        System.out.println(esPar);
        
        
        
        
        
        
        
        
        // CASTING (Conversión de tipos de datos)
        int num1 = 1;
        short num2 = 2;
        
        // Conversión implícita
        num1 = num2;
        
        // Convesión explícita
//        num2 = num1;    // Error de compilación
        num2 = (short)num1;    // Error de compilación
        
        
        
        
        
        
        
        
        
        // ENTRADA DE DATOS POR TECLADO
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("¿Cuál es tu edad?: ");
        int edad2 = entrada.nextInt();
        
        System.out.println("Tu edad es: " + edad2);
        

        
    }    

}
