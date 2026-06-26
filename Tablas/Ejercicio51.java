package Tablas;

import javax.swing.JOptionPane;

public class Ejercicio51 {

    public static void main(String[] args) {

        /*
        5.1. Solicitar 5 números decimales y mostrarlos en el mismo orden.
        */

        double[] numeros = new double[5];

        for (int i = 0; i < 5; i++) {
            String input = JOptionPane.showInputDialog("Ingrese un número decimal:");
            numeros[i] = Double.parseDouble(input);
        }

        String resultado = "Números ingresados:\n";

        for (int i = 0; i < 5; i++) {
            resultado += numeros[i] + "\n";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}