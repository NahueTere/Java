package Tablas;

import javax.swing.JOptionPane;

public class Ejercicio53 {

    public static void main(String[] args) {

        /*
        5.3. Media de positivos, negativos y contar ceros.
        */

        int n = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de números:"));

        double sumaPos = 0, sumaNeg = 0;
        int contPos = 0, contNeg = 0, contCeros = 0;

        for (int i = 0; i < n; i++) {

            int num = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese número:")
            );

            if (num > 0) {
                sumaPos += num;
                contPos++;
            } else if (num < 0) {
                sumaNeg += num;
                contNeg++;
            } else {
                contCeros++;
            }
        }

        String resultado =
            "Media positivos: " + (contPos == 0 ? 0 : sumaPos / contPos) + "\n" +
            "Media negativos: " + (contNeg == 0 ? 0 : sumaNeg / contNeg) + "\n" +
            "Ceros: " + contCeros;

        JOptionPane.showMessageDialog(null, resultado);
    }
}