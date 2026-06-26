package Tablas;

import javax.swing.JOptionPane;
import java.util.Random;

public class Ejercicio55 {

    public static void main(String[] args) {

        /*
        5.5. Cámara secreta con pistas mayor/menor/igual.
        */

        int n = Integer.parseInt(
            JOptionPane.showInputDialog("Longitud de la combinación:")
        );

        int[] secreta = new int[n];
        int[] intento = new int[n];

        Random r = new Random();

        for (int i = 0; i < n; i++) {
            secreta[i] = r.nextInt(5) + 1;
        }

        boolean ok = false;

        while (!ok) {

            String input = JOptionPane.showInputDialog("Ingrese combinación separada por espacios:");

            String[] partes = input.split(" ");

            ok = true;

            String pista = "";

            for (int i = 0; i < n; i++) {

                intento[i] = Integer.parseInt(partes[i]);

                if (intento[i] < secreta[i]) {
                    pista += "Pos " + i + ": mayor\n";
                    ok = false;
                } else if (intento[i] > secreta[i]) {
                    pista += "Pos " + i + ": menor\n";
                    ok = false;
                } else {
                    pista += "Pos " + i + ": igual\n";
                }
            }

            JOptionPane.showMessageDialog(null, pista);
        }

        JOptionPane.showMessageDialog(null, "¡Ganaste!");
    }
}