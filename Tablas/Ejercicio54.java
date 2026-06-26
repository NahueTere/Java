package Tablas;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Ejercicio54 {

    public static void main(String[] args) {

        /*
        5.4. Eliminar elementos por índice hasta salir o vaciar la tabla.
        */

        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(10);
        numeros.add(25);
        numeros.add(7);
        numeros.add(99);
        numeros.add(42);

        while (true) {

            String texto = "Lista actual:\n";

            for (int i = 0; i < numeros.size(); i++) {
                texto += i + ": " + numeros.get(i) + "\n";
            }

            int indice = Integer.parseInt(
                JOptionPane.showInputDialog(texto + "\nIngrese índice (-1 para salir):")
            );

            if (indice < 0) break;

            if (indice >= 0 && indice < numeros.size()) {
                numeros.remove(indice);
            } else {
                JOptionPane.showMessageDialog(null, "Índice inválido");
            }

            if (numeros.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No quedan elementos");
                break;
            }
        }
    }
}