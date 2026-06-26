package Bucles;

import javax.swing.*;

public class Ejercicio7_Swing extends JFrame {

    private JTextArea outputArea;

    public Ejercicio7_Swing() {

        setTitle("Ejercicio 7 - Producto impares");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        outputArea = new JTextArea(15, 30);
        outputArea.setEditable(false);

        long producto = 1;
        int contador = 0;
        int num = 1;

        while (contador < 10) {

            if (num % 2 != 0) {
                producto *= num;
                contador++;
            }

            num++;
        }

        outputArea.append("Producto de los 10 primeros impares:\n\n");
        outputArea.append(String.valueOf(producto));

        add(new JScrollPane(outputArea));

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio7_Swing().setVisible(true));
    }
}