package Bucles;

import javax.swing.*;

public class Ejercicio11_Swing extends JFrame {

    private JTextArea outputArea;

    public Ejercicio11_Swing() {

        setTitle("Ejercicio 11 - Tablas 1 al 10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        outputArea = new JTextArea(20, 35);
        outputArea.setEditable(false);

        for (int i = 1; i <= 10; i++) {

            outputArea.append("Tabla del " + i + "\n");

            for (int j = 1; j <= 10; j++) {
                outputArea.append(i + " x " + j + " = " + (i * j) + "\n");
            }

            outputArea.append("\n");
        }

        add(new JScrollPane(outputArea));

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio11_Swing().setVisible(true));
    }
}