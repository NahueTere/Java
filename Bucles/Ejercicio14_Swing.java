package Bucles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio14_Swing extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public Ejercicio14_Swing() {

        setTitle("Ejercicio 14 - Triángulo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        JButton button = new JButton("Dibujar");
        outputArea = new JTextArea(20, 35);
        outputArea.setEditable(false);

        button.addActionListener(e -> {

            try {
                int n = Integer.parseInt(inputField.getText());

                for (int i = n; i >= 1; i--) {

                    for (int j = 1; j <= i; j++) {
                        outputArea.append("* ");
                    }

                    outputArea.append("\n");
                }

                outputArea.append("\n");

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
        SwingUtilities.invokeLater(() -> new Ejercicio14_Swing().setVisible(true));
    }
}