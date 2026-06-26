package Bucles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio8_Swing extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public Ejercicio8_Swing() {

        setTitle("Ejercicio 8 - Factorial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        JButton button = new JButton("Calcular");
        outputArea = new JTextArea(12, 30);
        outputArea.setEditable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int n = Integer.parseInt(inputField.getText());

                    if (n < 0) {
                        outputArea.append("El factorial no existe para negativos\n\n");
                        return;
                    }

                    long fact = 1;

                    for (int i = 1; i <= n; i++) {
                        fact *= i;
                    }

                    outputArea.append("Factorial de " + n + " = " + fact + "\n\n");

                } catch (NumberFormatException ex) {
                    outputArea.append("Error: número inválido\n\n");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número:"));
        panel.add(inputField);
        panel.add(button);

        add(panel, "North");
        add(new JScrollPane(outputArea), "Center");

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio8_Swing().setVisible(true));
    }
}