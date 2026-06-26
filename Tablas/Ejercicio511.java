package Tablas;

import javax.swing.JOptionPane;

public class Ejercicio511 {

    public static void main(String[] args) {

        /*
        5.11. Leer matriz 4x4 y determinar si es mágica:
        suma de filas y columnas igual.
        */

        int[][] m = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                m[i][j] = Integer.parseInt(
                    JOptionPane.showInputDialog("Elemento [" + i + "][" + j + "]")
                );
            }
        }

        int sumaRef = 0;

        for (int j = 0; j < 4; j++) {
            sumaRef += m[0][j];
        }

        boolean magica = true;

        for (int i = 1; i < 4; i++) {
            int sumaFila = 0;

            for (int j = 0; j < 4; j++) {
                sumaFila += m[i][j];
            }

            if (sumaFila != sumaRef) {
                magica = false;
            }
        }

        for (int j = 0; j < 4; j++) {
            int sumaCol = 0;

            for (int i = 0; i < 4; i++) {
                sumaCol += m[i][j];
            }

            if (sumaCol != sumaRef) {
                magica = false;
            }
        }

        JOptionPane.showMessageDialog(null,
            magica ? "Es matriz mágica" : "No es matriz mágica"
        );
    }
}