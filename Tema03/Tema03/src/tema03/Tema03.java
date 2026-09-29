package tema03;

/**
 * En este tema vamos a aprender a usar estructuras de control de flujo:
 *
 * - Condicionales: if, if-else, switch
 *
 * - Bucles: for, while, do-while
 *
 * - Control de excepciones: try-catch
 *
 * Estas estructuras nos dan mayor control sobre lo que sucede en nuestro
 * programa.
 *
 * @author d3stroya
 */
public class Tema03 {

    final static int NUM_TAQUILLAS = 4;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int taquillaAna = 1, taquillaBruno, taquillaCarla, taquillaDiego;
        boolean enc = false;

        while (taquillaAna <= NUM_TAQUILLAS && !enc) {

            taquillaBruno = 1;
            while (taquillaBruno <= NUM_TAQUILLAS && !enc) {

                taquillaCarla = 1;
                while (taquillaCarla <= NUM_TAQUILLAS && !enc) {

                    taquillaDiego = 1;
                    while (taquillaDiego <= NUM_TAQUILLAS && !enc) {

                        if (taquillaAna != taquillaBruno && taquillaAna != taquillaCarla && taquillaAna != taquillaDiego
                                && taquillaBruno != taquillaCarla && taquillaBruno != taquillaDiego
                                && taquillaDiego != taquillaCarla) {

                            if (taquillaAna % 2 == 0
                                    && taquillaBruno > taquillaAna
                                    && taquillaCarla != 1 && taquillaCarla != 4
                                    && taquillaDiego < taquillaBruno && taquillaDiego % 2 != 0) {

                                enc = true;

                                System.out.println("¡Solución encontrada!");
                                System.out.println("Taquilla de Ana: " + taquillaAna);
                                System.out.println("Taquilla de Bruno: " + taquillaBruno);
                                System.out.println("Taquilla de Carla: " + taquillaCarla);
                                System.out.println("Taquilla de Diego: " + taquillaDiego);
                            }
                        }

                        taquillaDiego++;
                    }

                    taquillaCarla++;
                }

                taquillaBruno++;
            }

            taquillaAna++;
        }

    }
}
