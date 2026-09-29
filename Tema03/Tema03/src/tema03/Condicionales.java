package tema03;


/**
 *
 * @author d3stroya
 */
public class Condicionales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num1 = 8;
        
        // IF
        System.out.println("IF");
        if(num1 % 2 == 0) {
            System.out.println("El número es par.");
        }                    

        
        // IF-ELSE
        System.out.println("\nIF ELSE");
        if(num1 % 2 == 0) {
            System.out.println("El número es par.");
        } else {
            System.out.println("El número es impar.");
        }

        
        // IF-ELSE IF-ELSE
        System.out.println("\nIF - ELSE IF - ELSE");
        if(num1 > 0) {
            System.out.println("El número es positivo.");
        } else if(num1 < 0) {
            System.out.println("El número es negativo.");
        } else {
            System.out.println("El número es 0.");
        }

        
        // SWITCH
        System.out.println("\nSWITCH");
        switch(num1) {
            case 1 -> {
                System.out.println("Lunes");
                System.out.println("Lunes");
            }
            case 2 -> System.out.println("Martes");
            case 3 -> System.out.println("Miércoles");
            case 4 -> System.out.println("Jueves");
            case 5 -> System.out.println("Viernes");
            case 6 -> System.out.println("Sábado");
            case 7 -> System.out.println("Domingo");
            default -> System.out.println("No existe ese día de la semana.");
        }
        
    }    

}
