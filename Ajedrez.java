package tableroajedez;

import java.util.Random;

/**
 * Clase de ajedrez.
 * @author Marisa Ruiz Garcia
 */
public class Ajedrez {

    /**
     * Array bidemensional de entero para el tablero 8x8.
     */
    private final int[][] tablero;
    
    /**
    * Constructor de la clase
    */
    public Ajedrez() {
        // Creamos el tablero
        tablero = new int[8][8];

        // Inicializamos a cero todas las casillas
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = 0;
            }
        }
    }
    
    /**
    * Método para rellenar el tablero con n Piezas
    * @param numPiezas Número de piezas
    */
    public void rellenarTablero(int numPiezas) {
        Random r = new Random();
        int rx, ry;
        for (int i = 0; i < numPiezas; i++) {
            rx = r.nextInt(8);
            ry = r.nextInt(8);
            if (tablero[rx][ry] == 0) {
                tablero[rx][ry] = 1;
            } else {
                i--;
            }
        }
    }
    
    /**
    * Método que imprime por pantalla el tablero de ajedrez
    */
    public void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(" " + tablero[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
    * Metodo para mostrar los posibles movimientos.
    * Posicion de array con valor 2.
    */
    public void mostrarMovimientos() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 2) {
                    System.out.println("Podemos mover a: " + (i + 1) + "," + (j + 1));
                }
            }
        }
    }

    /**
    * Método para poner una pieza en el tablero.
    * @param x Número de fila del tablero.
    * @param y Número de columna del tablero.
    * @param fig Número de la figura.
    */
    public void ponerPieza(int x, int y, int fig) {
        tablero[x][y] = fig;
    }

    /**
    * Método que comprueba si existe una pieza en una posición.
    * @param x Número de fila del tablero.
    * @param y Número de columna del tablero.
    * @return True si hay una ficha en la posicion, falso si la posicion esta libre.
    */
    public boolean hayPieza(int x, int y) {
        boolean casilla = false;
        if (tablero[x][y] != 0) {
            casilla = true;
        }
        return casilla;
    }

    /**
     * Método para mover la figura rey.
     * @param x Número de fila del tablero.
     * @param y Número de columna del tablero.
     * @return True si hay movimientos disponibles, falso si no se puede mover.
     */
    public boolean moverRey(int x, int y) {
        boolean mov = false;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                try {
                    if (tablero[i][j] == 0) {
                        tablero[i][j] = 2;
                        mov = true;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {}
            }
        }
        return mov;
    }

    /**
     * Método para mover la figura dama.
     * @param x Número de fila del tablero.
     * @param y Número de columna del tablero.
     * @return True si hay movimientos disponibles, falso si no se puede mover.
     */
    public boolean moverDama(int x, int y) {
        boolean mov = false;
        boolean movA = moverAlfil(x, y);
        boolean movT = moverTorre(x, y);
        if (movA == false && movT == false) {
            mov = false;
        } else {
            mov = true;
        }
        return mov;
    }

    /**
     * Método para mover la figura torre.
     * @param x Número de fila del tablero.
     * @param y Número de columna del tablero.
     * @return True si hay movimientos disponibles, falso si no se puede mover.
     */
    public boolean moverTorre(int x, int y) {
        boolean mov = false;
        
        // Derecha
        for (int i = x; i < tablero.length; i++) {
            try {
                if (tablero[i][y] == 1) {
                    break;
                } else if (tablero[i][y] == 0) {
                    tablero[i][y] = 2;
                    mov = true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
        }
        

        // Abajo
        for (int j = y; j < tablero.length; j++) {
            try {
                if (tablero[x][j] == 1) {
                    break;
                } else if (tablero[x][j] == 0) {
                    tablero[x][j] = 2;
                    mov = true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
        }
        
        // Izquierda
        for (int i = x; i >= 0; i--) {
            try {
                if (tablero[i][y] == 1) {
                    break;
                } else if (tablero[i][y] == 0) {
                    tablero[i][y] = 2;
                    mov = true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
        }
        
        // Arriba
        for (int j = y; j >= 0; j--) {
            try {
                if (tablero[x][j] == 1) {
                    break;
                } else if (tablero[x][j] == 0) {
                    tablero[x][j] = 2;
                    mov = true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
        }
        
        return mov;
    }

    /**
     * Método para mover la figura alfil.
     * @param x Número de fila del tablero.
     * @param y Número de columna del tablero.
     * @return True si hay movimientos disponibles, falso si no se puede mover.
     */
    public boolean moverAlfil(int x, int y) {
        boolean mov = false;
        
        // Movimiento abajo derecha
        for (int i = x + 1, j = y + 1; i < tablero.length || j < tablero.length; i++, j++) {
            try {
                if (tablero[i][j] == 1) {
                    break;
                } else if (tablero[i][j] == 0) {
                    tablero[i][j] = 2;
                    mov = true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
        }
        
        // Movimiento abajo izquierda
        for (int i = x + 1, j = y - 1; i < tablero.length || j >= 0; i++, j--) {
            try {
                if (tablero[i][j] == 1) {
                    break;
                } else if (tablero[i][j] == 0) {
                    tablero[i][j] = 2;
                    mov = true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
        }
        
        // Movimiento arriba derecha
        for (int i = x - 1, j = y + 1; i >= 0 || j < tablero.length; i--, j++) {
            try {
                if (tablero[i][j] == 1) {
                    break;
                } else if (tablero[i][j] == 0) {
                    tablero[i][j] = 2;
                    mov = true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
        }

        // Movimiento arriba izquierda
        for (int i = x - 1, j = y - 1; i >= 0 || j >= 0; i--, j--) {
            try {
                if (tablero[i][j] == 1) {
                    break;
                } else if (tablero[i][j] == 0) {
                    tablero[i][j] = 2;
                    mov = true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
        }
        
        return mov;
    }

    /**
     * Método para mover la figura caballo.
     * @param x Número de fila del tablero.
     * @param y Número de columna del tablero.
     * @return True si hay movimientos disponibles, falso si no se puede mover.
     */
    public boolean moverCaballo(int x, int y) {
        boolean mov = false;
        
        // Vertical largo, horizontal corto
        for (int k1 = 0, i = x - 2; k1 < 2; k1++, i = i + 4) {
            for (int k2 = 0, j = y - 1; k2 < 2; k2++, j = j + 2) {
                try {
                    if (tablero[i][j] == 0) {
                        tablero[i][j] = 2;
                        mov = true;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {}
            }
        } 

        // Horizontal largo, vertical corto
        for (int k1 = 0, i = x - 1; k1 < 2; k1++, i = i + 2) {
            for (int k2 = 0, j = y - 2; k2 < 2; k2++, j = j + 4) {
                try {
                    if (tablero[i][j] == 0) {
                        tablero[i][j] = 2;
                        mov = true;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {}
            } 
        }
        

        return mov;
    }

    /**
     * Método para mover la figura peon.
     * @param x Número de fila del tablero.
     * @param y Número de columna del tablero.
     * @return True si hay movimientos disponibles, falso si no se puede mover.
     */
    public boolean moverPeon(int x, int y) {
        boolean mov = false;
        try {
            if (tablero[x + 1][y] == 0) {
                tablero[x + 1][y] = 2;
                mov = true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {}
        return mov;
    }
}
