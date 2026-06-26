package Bucles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio15_Swing extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public Ejercicio15_Swing() {

        setTitle("Ejercicio 15 - Primos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        JButton button = new JButton("Calcular");
        outputArea = new JTextArea(15, 35);
        outputArea.setEditable(false);

        button.addActionListener(e -> {

            try {
                int n = Integer.parseInt(inputField.getText());

                int primos = 0;

                for (int i = 1; i <= n; i++) {

                    boolean esPrimo = true;

                    if (i < 2) esPrimo = false;

                    for (int j = 2; j < i; j++) {
                        if (i % j == 0) {
                            esPrimo = false;
                            break;
                        }
                    }

                    if (esPrimo) {
                        primos++;
                        outputArea.append(i + " -> primo\n");
                    } else {
                        outputArea.append(i + " -> no primo\n");
                    }
                }

                outputArea.append("\nTotal primos: " + primos + "\n\n");

            } catch (Exception ex) {
                outputArea.append("Error\n");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("n:"));
        panel.add(inputField);
        panel.add(button);

        add(panel, "North");
        add(new JScrollPane(outputArea), "Center");

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio15_Swing().setVisible(true));
    }
}