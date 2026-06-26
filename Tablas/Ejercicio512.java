package Tablas;

import javax.swing.JOptionPane;

public class Ejercicio512 {

    public static void main(String[] args) {

        /*
        5.12. Matriz 5x5 donde cada posición [n][m] = n + m.
        Mostrar contenido.
        */

        int[][] m = new int[5][5];

        String res = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                m[i][j] = i + j;
                res += m[i][j] + " ";
            }
            res += "\n";
        }

        JOptionPane.showMessageDialog(null, res);
    }
}