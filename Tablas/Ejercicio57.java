package Tablas;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class Ejercicio57 {

    public static void main(String[] args) {

        /*
        5.7. Leer 6 enteros, ordenarlos. Leer otros 6 enteros, ordenarlos.
        Luego fusionarlos en una tercera tabla manteniendo el orden sin volver a ordenar.
        */

        int[] a = new int[6];
        int[] b = new int[6];

        for (int i = 0; i < 6; i++) {
            a[i] = Integer.parseInt(JOptionPane.showInputDialog("Array A - número " + (i + 1)));
        }

        for (int i = 0; i < 6; i++) {
            b[i] = Integer.parseInt(JOptionPane.showInputDialog("Array B - número " + (i + 1)));
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int[] c = new int[12];

        int i = 0, j = 0, k = 0;

        while (i < 6 && j < 6) {

            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < 6) c[k++] = a[i++];
        while (j < 6) c[k++] = b[j++];

        String res = "Resultado fusionado ordenado:\n";

        for (int x : c) {
            res += x + "\n";
        }

        JOptionPane.showMessageDialog(null, res);
    }
}