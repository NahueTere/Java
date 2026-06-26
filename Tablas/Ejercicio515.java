package Tablas;

import javax.swing.JOptionPane;

public class Ejercicio515 {

    public static void main(String[] args) {

        /*
        5.15. Función rellenaPares:
        llena tabla solo con pares, ignora impares.
        Devuelve cantidad de impares descartados.
        */

        int[] tabla = new int[10]; // podés cambiar tamaño
        int descartados = rellenaPares(tabla);

        String res = "Tabla de pares:\n";

        for (int x : tabla) {
            res += x + "\n";
        }

        res += "\nImpares descartados: " + descartados;

        JOptionPane.showMessageDialog(null, res);
    }

    public static int rellenaPares(int[] tabla) {

        int i = 0;
        int descartados = 0;

        while (i < tabla.length) {

            int num = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese número:")
            );

            if (num % 2 == 0) {
                tabla[i++] = num;
            } else {
                descartados++;
            }
        }

        return descartados;
    }
}