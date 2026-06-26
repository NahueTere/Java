package Tablas;

import javax.swing.JOptionPane;

public class Ejercicio510 {

    public static void main(String[] args) {

        /*
        5.10. Leer n números enteros y separarlos en dos tablas:
        una con pares y otra con impares.
        */

        int n = Integer.parseInt(
            JOptionPane.showInputDialog("Cantidad de números:")
        );

        int[] original = new int[n];

        int paresCount = 0;
        int imparesCount = 0;

        for (int i = 0; i < n; i++) {
            original[i] = Integer.parseInt(
                JOptionPane.showInputDialog("Número " + (i + 1))
            );
        }

        for (int i = 0; i < n; i++) {
            if (original[i] % 2 == 0) {
                paresCount++;
            } else {
                imparesCount++;
            }
        }

        int[] pares = new int[paresCount];
        int[] impares = new int[imparesCount];

        int p = 0, im = 0;

        for (int i = 0; i < n; i++) {
            if (original[i] % 2 == 0) {
                pares[p++] = original[i];
            } else {
                impares[im++] = original[i];
            }
        }

        String res = "PARES:\n";

        for (int x : pares) res += x + "\n";

        res += "\nIMPARES:\n";

        for (int x : impares) res += x + "\n";

        JOptionPane.showMessageDialog(null, res);
    }
}