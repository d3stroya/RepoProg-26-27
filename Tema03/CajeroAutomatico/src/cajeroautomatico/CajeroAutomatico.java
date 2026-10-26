package cajeroautomatico;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author d3stroya
 */
public class CajeroAutomatico {

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
        // Declaramos variables necesarias
        Scanner entradaInt = new Scanner(System.in);
        Scanner entradaFloat = new Scanner(System.in);
        int opcion = 0, pinUsuario, intentos = 0;
        float cantidad = 0;
        boolean cantidadCorrecta = false, login = false;

        
        // 1. PEDIMOS EL PIN
        do {
            try {
                
                System.out.println("- INICIO DE SESIÓN -");
                System.out.print("  -> Por favor, introduzca su clave PIN: ");
                pinUsuario = entradaInt.nextInt();
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

        
        // 2. SI EL PIN ES CORRECTO, MOSTRAMOS EL MENÚ Y GESTIONAMOS SUS OPCIONES
        if (login) {

            do {

                try {
                    // 2.1. Mostramos el menú
                    System.out.println("\n- MENÚ -");
                    System.out.println("1. Consultar saldo");
                    System.out.println("2. Ingresar dinero");
                    System.out.println("3. Retirar dinero");
                    System.out.println("4. Salir");

                    // Pedimos la opción del menú al usuario
                    System.out.print("Elige una opción: ");
                    opcion = entradaInt.nextInt();

                    // Manejamos las opciones del menú
                    switch (opcion) {
                        
                        // 2.2. Muestra el saldo disponible en la cuenta
                        case 1:
                            System.out.println("\n· CONSULTA DE SALDO");
                            System.out.println("[i] Saldo disponible: " + saldo + "€.");
                            break;

                        // 2.3. Pide al usuario una cantidad y la ingresa en la cuenta sumándola al saldo total
                        case 2:
                            System.out.println("\n· SOLICITUD DE INGRESO");                            

                            do {
                                System.out.print("  -> Cantidad a ingresar: ");
                                cantidad += entradaFloat.nextFloat();

                                if (cantidad > 0) {
                                    cantidadCorrecta = true;
                                    cantidad += 
                                    operacionesValidas++;
                                } else {
                                    System.out.println("[x] ERROR: La cantidad debe ser superior a 0€.");
                                    cantidadCorrecta = false;
                                    operacionesErroneas++;
                                }
                            } while (!cantidadCorrecta);

                            saldo += cantidad;
                            System.out.println("\n[√] Cantidad ingresada: " + cantidad);
                            System.out.println("\n[i] Saldo actual: " + saldo + "€");

                            numIngresos++;
                            break;

                        // 2.4. Pide un dato al usuario y lo retira de la cuenta restándoselo al saldo total    
                        case 3:
                            System.out.println("\n· SOLICITUD DE RETIRADA");

                            do {
                                System.out.print("  -> Cantidad a retirar: ");
                                cantidad = entradaFloat.nextFloat();

                                if (cantidad > 0 && cantidad <= saldo && cantidad < LIMITE_RETIRADA) {
                                    cantidadCorrecta = true;
                                    operacionesValidas++;

                                    saldo -= cantidad;
                                    System.out.println("\n[√] Cantidad retirada: " + cantidad);
                                    System.out.println("\n[i] Saldo actual: " + saldo + "€.");

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
                            } while (!cantidadCorrecta);

                            numRetiradas++;

                            break;

                        // 2.5. Resumen de la sesión y finalización del programa    
                        case 4:
                            System.out.println("\n- RESUMEN DE LA SESIÓN -");
                            System.out.println("· Saldo final: " + saldo + "€ | "
                                    + "Ingresos: " + numIngresos + " | "
                                    + "Retiradas: " + numRetiradas);

                            System.out.println("· Entradas erróneas interceptadas: " + operacionesErroneas);
                            System.out.println("· Operaciones válidas: " + operacionesValidas);

                            System.out.println("\n¡Gracias por usar este cajero!");
                            System.out.println("¡Hasta pronto!");
                            break;

                        default:
                            System.out.println("[!] No has elegido una opción válida.");
                            System.out.println(" · Por favor, selecciona una opción entre 1 y 4.");
                    }

                } catch(InputMismatchException e) {
                    System.out.println("Error: Has introducido un dato incorrecto. "
                            + "Selecciona una opción válida.");
                }
                
            } while (opcion != 4);  // FIN DEL MENÚ

        }


    }

}
