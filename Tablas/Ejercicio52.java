package Tablas;

import javax.swing.JOptionPane;

public class Ejercicio52 {

    public static void main(String[] args) {

        /*
        5.2. Pedir cantidad de números, ingresarlos y mostrarlos al revés.
        */

        int n = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos números vas a ingresar?"));

        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            numeros[i] = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese número:")
            );
        }

        String resultado = "Orden inverso:\n";

        for (int i = n - 1; i >= 0; i--) {
            resultado += numeros[i] + "\n";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}