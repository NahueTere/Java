package Bucles;

import javax.swing.*;

public class Ejercicio6_Swing extends JFrame {

    private JTextArea outputArea;

    public Ejercicio6_Swing() {

        setTitle("Ejercicio 6 - Múltiplos de 7");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        outputArea = new JTextArea(15, 30);
        outputArea.setEditable(false);

        outputArea.append("Múltiplos de 7 menores a 100:\n\n");

        for (int i = 7; i < 100; i += 7) {
            outputArea.append(i + "\n");
        }

        add(new JScrollPane(outputArea));

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio6_Swing().setVisible(true));
    }
}