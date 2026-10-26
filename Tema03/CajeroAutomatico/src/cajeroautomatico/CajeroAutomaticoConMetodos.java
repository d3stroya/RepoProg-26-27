package cajeroautomatico;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author d3stroya
 */
public class CajeroAutomaticoConMetodos {
    // CONSTANTES Y VARIABLES GLOBALES
    final static float LIMITE_RETIRADA = 500.00f;
    final static int PIN = 1234;
    static float saldo = 1000.00f;
    static int operacionesValidas = 0;
    static int operacionesErroneas = 0;
    static int numIngresos = 0;
    static int numRetiradas = 0;
    static int numMaxIntentos = 3;

    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        // VARIABLES LOCALES                
        int opcion = 0;

        
        // 1. PEDIMOS EL PIN PARA INICIAR SESIÓN
        boolean login = login();

        
        // 2. SI EL PIN ES CORRECTO, MOSTRAMOS EL MENÚ Y GESTIONAMOS SUS OPCIONES
        if (login) {

            do {

                try {
                    // 2.1. Mostramos el menú
                    mostrarMenu();

                    opcion = pedirOpcion();

                    // Manejamos las opciones del menú
                    switch (opcion) {                        
                        case 1 -> mostrarSaldo();                            
                        case 2 -> ingresar();
                        case 3 -> retirar();                                                
                        case 4 -> resumirSesion();
                        default -> System.out.println("[!] No has elegido una opción válida.\n"
                                    + " · Por favor, selecciona una opción entre 1 y 4.");
                    }

                } catch(InputMismatchException e) {
                    System.out.println("Error: Has introducido un dato incorrecto. "
                            + "Selecciona una opción válida.");
                }
                
            } while (opcion != 4);

        }

    }
    
    
    // ======= PEDIR DATOS ======= //
    /**
     * Método que pide al usuario una cantidad de dinero.
     * Permite decimales.
     * 
     * @return la cantidad escrita.
     */
    public static float pedirCantidad() {
        Scanner entradaFloat = new Scanner(System.in);               
        return entradaFloat.nextFloat();
    }
    
    /**
     * Método que pide al usuario el pin de su cuenta.
     * 
     * @return el pin escrito.
     */
    public static int pedirPin() {
        Scanner entradaInt = new Scanner(System.in);
        System.out.print("  -> Por favor, introduzca su clave PIN: ");        
        return entradaInt.nextInt();
    }
    
    /**
     * Método que pide al usuario la opción del menú.
     * 
     * @return la opción escrita.
     */
    public static int pedirOpcion() {
        Scanner entradaInt = new Scanner(System.in);
        System.out.print("Elige una opción: ");        
        return entradaInt.nextInt();
    }
    
    
    
    
    // ====== SESIÓN ====== //            
    /**
     * Método que abre sesión en la cuenta del usuario
     * comprobando que el pin sea válido (3 intentos).
     * 
     * @return true si el pin es correcto antes de agotar 3 intentos
     * y false en caso contrario.
     */
    public static boolean login() {
        int pinUsuario, intentos = 0;
        boolean login = false;
        
        do {
            try {
                
                System.out.println("- INICIO DE SESIÓN -");
                pinUsuario = pedirPin();
                intentos++;
                
                if (pinUsuario == PIN) {
                    login = true;
                    System.out.println("\n[√] Sesión iniciada correctamente.");
                } else if (intentos < 3) {
                    System.out.println("\n[x] Clave PIN incorrecta. Por favor, inténtelo de nuevo. (" + intentos + "/" + numMaxIntentos + ")\n");
                } else {
                    System.out.println("\n[x] Clave PIN incorrecta. Vuelva más tarde.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Error: Has introducido un dato incorrecto. "
                        + "Selecciona una opción válida.");
            }
            
        } while (!login && intentos < 3);
        
        return login;
    }
    
    /**
     * Método que muestra el menú de opciones.
     */
    public static void mostrarMenu() {       
        System.out.println("\n- MENÚ -");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Ingresar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Salir");
    }

    /**
     * Método que muestra el resumen de la sesión.
     */
    public static void resumirSesion() {
        System.out.println("\n- RESUMEN DE LA SESIÓN -");
        System.out.println("· Saldo final: " + saldo + "€ | "
                + "Ingresos: " + numIngresos + " | "
                        + "Retiradas: " + numRetiradas);
        
        System.out.println("· Entradas erróneas interceptadas: " + operacionesErroneas);
        System.out.println("· Operaciones válidas: " + operacionesValidas);
        
        System.out.println("\n¡Gracias por usar este cajero!");
        System.out.println("¡Hasta pronto!");
    }
    
    
    
    // ======= OPERACIONES EN CUENTA ====== //
    /**
     * Método que permite retirar de la cuenta
     * el dinero indicado por el usuario.
     */
    public static void retirar() {
        System.out.println("\n· SOLICITUD DE RETIRADA");
        boolean cantidadCorrecta;
        
        do {
            cantidadCorrecta = contralarRetirada();
            
        } while (!cantidadCorrecta);
        
        numRetiradas++;
    }

    /**
     * Método que controla que la cantidad retirada
     * de la cuenta sea correcta (mayor que 0, menor que el saldo y
     * menor que el límite de retirada).
     * 
     * @return true si la cantidad es correcta y false en caso contrario.
     */
    public static boolean contralarRetirada() {   
        boolean cantidadCorrecta = false;

        System.out.print("  -> Cantidad a retirar: "); 
        float cantidad = pedirCantidad();
                
        if (cantidad > 0 && cantidad <= saldo && cantidad < LIMITE_RETIRADA) {
            cantidadCorrecta = true;
            operacionesValidas++;
            
            retirarCantidad(cantidad);
            
        } else {
            operacionesErroneas++;
            
            if (cantidad < 0) {
                System.out.println("[x] ERROR: La cantidad debe ser superior a 0€.");
            } else if (cantidad > LIMITE_RETIRADA) {
                System.out.println("[x] ERROR: Cantidad superior al límite establecido: " + LIMITE_RETIRADA + "€.");
            } else {
                System.out.println("[x] ERROR: La cantidad debe ser inferior al saldo disponible.");
                System.out.println("[i] El saldo disponible es " + saldo + "€.");
            }
        }
        
        return cantidadCorrecta;
    }

    /**
     * Método que ejecuta la retirada del dinero.
     * 
     * @param cantidad 
     */
    public static void retirarCantidad(float cantidad) {
        saldo -= cantidad;
        System.out.println("\n[√] Cantidad retirada: " + cantidad);
        System.out.println("\n[i] Saldo actual: " + saldo + "€.");
    }

    
    
    /**
     * Método que permite ingresar una cantidad de
     * dinero indciada por el usuario.
     * 
     * @return true si la cantidad es correcta y false en caso contrario.
     */
    public static boolean ingresar() {
        float cantidad = 0;
        boolean cantidadCorrecta = false;
        
        System.out.println("\n· SOLICITUD DE INGRESO");

        // Pido al usuario la cantidad que quiere ingresar
        do {
            System.out.print("  -> Cantidad a ingresar: ");
            cantidad = pedirCantidad();
            
            cantidadCorrecta = comprobarIngreso(cantidad, cantidadCorrecta);
            
        } while (!cantidadCorrecta);
        
        ingresarCantidad(cantidad);
        
        return cantidadCorrecta;
    }    

    /**
     * Método que comprueba que la cantidad que
     * se quiere ingresar sea correcta (que sea mayor que 0).
     * 
     * @param cantidad
     * @param cantidadCorrecta
     * 
     * @return true si la cantidad es correcta y false en caso contrario.
     */
    public static boolean comprobarIngreso(float cantidad, boolean cantidadCorrecta) {
        if (cantidad > 0) {
            cantidadCorrecta = true;
            operacionesValidas++;
        } else {
            System.out.println("[x] ERROR: La cantidad debe ser superior a 0€.");
            operacionesErroneas++;
        }
        return cantidadCorrecta;
    }
    
    /**
     * Método que ejecuta el ingreso
     * de la cantidad indicada.
     * 
     * @param cantidad 
     */
    public static void ingresarCantidad(float cantidad) {
        // Sumo la cantidad al saldo total
        saldo += cantidad;
        System.out.println("\n[√] Cantidad ingresada: " + cantidad);
        System.out.println("\n[i] Saldo actual: " + saldo + "€");
        
        numIngresos++;
    }

    
    /**
     * Método que muestra el saldo total de la cuenta.
     */
    public static void mostrarSaldo() {
        System.out.println("\n· CONSULTA DE SALDO");
        System.out.println("[i] Saldo disponible: " + saldo + "€.");
    }
    
    
    
    
}
