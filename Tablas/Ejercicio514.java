package Tablas;

import javax.swing.JOptionPane;

public class Ejercicio514 {

    public static void main(String[] args) {

        /*
        5.14. Función que compara dos apuestas de 6 números y devuelve aciertos.
        */

        int[] apuesta = new int[6];
        int[] ganadora = new int[6];

        for (int i = 0; i < 6; i++) {
            apuesta[i] = Integer.parseInt(
                JOptionPane.showInputDialog("Apuesta número " + (i + 1))
            );
        }

        for (int i = 0; i < 6; i++) {
            ganadora[i] = Integer.parseInt(
                JOptionPane.showInputDialog("Ganadora número " + (i + 1))
            );
        }

        int aciertos = contarAciertos(apuesta, ganadora);

        JOptionPane.showMessageDialog(null, "Aciertos: " + aciertos);
    }

    public static int contarAciertos(int[] a, int[] b) {

        int cont = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (a[i] == b[j]) {
                    cont++;
                    break;
                }
            }
        }

        return cont;
    }
}