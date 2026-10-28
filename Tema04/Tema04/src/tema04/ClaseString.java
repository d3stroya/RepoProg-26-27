package tema04;

import java.util.Scanner;


/**
 *
 * @author d3stroya
 */
public class ClaseString {
    
    // Pedimos un String al usuario
    public static String pedirObjeto() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Objeto: ");
        return entrada.nextLine();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creamos una variable de tipo String
        String objeto1 = "mesa";
        String objeto2 = "Mesa";
        
        // Comparamos dos cadenas de caracteres
        System.out.println(objeto1.equals(objeto2));    // Distingue mayúsculas y minúsculas
        System.out.println(objeto1.equalsIgnoreCase(objeto2));    // Ignora mayúsculas y minúsculas
        
        // Mostramos una cadena escrita por el usuario
        System.out.println("Tu objeto es " + pedirObjeto());
    }    

}
