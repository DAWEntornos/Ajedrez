package tableroajedez;

import java.util.Scanner;

/**
 * Metodo de ejecucion de un tablero de Ajedrez para el ejercicio.
 * @author Marisa Ruiz Garcia
 */
public class TableroAjedrez {

    /**
     * @param args Argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        int fil, col, pieza;
        Ajedrez ajedrez = new Ajedrez();
        
        // Relleno el tablero con 15 piezas
        ajedrez.rellenarTablero(15);
        ajedrez.mostrarTablero();

        System.out.print("Figuras ajedrez\n"
                + "Rey     --> 1\n"
                + "Dama    --> 2\n"
                + "Torre   --> 3\n"
                + "Alfil   --> 4\n"
                + "Caballo --> 5\n"
                + "Peon    --> 6\n");
        pieza = leerInt(1, 6, "Introduzca la figura: ");
        
        // Introducir posicion de fichas
        System.out.println("Introduzca posicion de la pieza");
        fil = leerInt(1, 8, "Introduzca fila : ");
        col = leerInt(1, 8, "Introduzca columna : ");
        while (ajedrez.hayPieza(fil - 1, col - 1) == true) {
            System.out.println("Ya hay una pieza");
            fil = leerInt(1, 8, "Introduzca fila : ");
            col = leerInt(1, 8, "Introduzca columna : ");
        }

        // Convertimos a posiciones de array
        int x = fil-1;
        int y = col-1;

        ajedrez.ponerPieza(x, y, 8);
        //ajedrez.mostrarTablero();
        
        switch (pieza) {
            case 1: // Rey
                System.out.println("Movemos el rey:");
                if (ajedrez.moverRey(x, y) == false) {
                    System.out.println("No hay movimientos");
                }
                ajedrez.mostrarMovimientos();
                break;

            case 2: // Dama
                System.out.println("Movemos la dama");
                if (ajedrez.moverDama(x, y) == false) {
                    System.out.println("No hay movimientos");
                }
                ajedrez.mostrarMovimientos();
                break;

            case 3: // Torre
                System.out.println("Movemos la torre");
                if (ajedrez.moverTorre(x, y) == false) {
                    System.out.println("No hay movimientos");
                }
                ajedrez.mostrarMovimientos();
                break;

            case 4: // Alfil
                System.out.println("Movemos el alfil");
                if (ajedrez.moverAlfil(x, y) == false) {
                    System.out.println("No hay movimientos");
                }
                ajedrez.mostrarMovimientos();
                break;

            case 5: // Caballo
                System.out.println("Movemos el caballo");
                if (ajedrez.moverCaballo(x, y) == false) {
                    System.out.println("No hay movimientos");
                }
                ajedrez.mostrarMovimientos();
                break;

            case 6: // Peon
                System.out.println("Movemos el peon");
                if (ajedrez.moverPeon(x, y) == false) {
                    System.out.println("No hay movimientos");
                }
                ajedrez.mostrarMovimientos();
                break;
        }
    }

    /**
     * Método para leer número entero de teclado y validar rango válido.
     * @param min Número minimo válido (inclusive).
     * @param max Número máximo válido (inclusive).
     * @param mesaje String con el mensaje a mostrar para solicitar los valores.
     * @return Número leido por teclado.
     */
    public static int leerInt(int min, int max, String mesaje) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.print(mesaje);
            while (!sc.hasNextInt()) {
                System.out.println("Error. No has introducido un entero.");
                sc.next(); // Leo el siguiente
                System.out.print(mesaje);
            }
            number = sc.nextInt();
        } while (number < min || number > max);
        return number;
    }
}
