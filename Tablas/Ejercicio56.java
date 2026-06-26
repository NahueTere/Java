package Tablas;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio56 {

    public static void main(String[] args) {

        /*
        5.6. Campeonato de programación con ordenamiento.
        */

        ArrayList<Integer> puntos = new ArrayList<>();

        JOptionPane.showMessageDialog(null, "Ingrese 5 puntajes iniciales");

        for (int i = 0; i < 5; i++) {
            puntos.add(Integer.parseInt(
                JOptionPane.showInputDialog("Puntaje programador " + (i + 1))
            ));
        }

        int extras = 0;

        while (extras < 3) {

            int p = Integer.parseInt(
                JOptionPane.showInputDialog("Extra (-1 para terminar)")
            );

            if (p == -1) break;

            puntos.add(p);
            extras++;
        }

        Collections.sort(puntos);

        String resultado = "Puntajes ordenados:\n";

        for (int p : puntos) {
            resultado += p + "\n";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}