package Bucles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio10_Swing extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public Ejercicio10_Swing() {

        setTitle("Ejercicio 10 - Tabla de multiplicar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        JButton button = new JButton("Generar");
        outputArea = new JTextArea(12, 35);
        outputArea.setEditable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int n = Integer.parseInt(inputField.getText());

                    if (n < 1 || n > 10) {
                        outputArea.append("El número debe estar entre 1 y 10\n\n");
                        return;
                    }

                    outputArea.append("Tabla del " + n + ":\n\n");

                    for (int i = 1; i <= 10; i++) {
                        outputArea.append(n + " x " + i + " = " + (n * i) + "\n");
                    }

                    outputArea.append("\n");

                } catch (NumberFormatException ex) {
                    outputArea.append("Error: número inválido\n\n");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número (1-10):"));
        panel.add(inputField);
        panel.add(button);

        add(panel, "North");
        add(new JScrollPane(outputArea), "Center");

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio10_Swing().setVisible(true));
    }
}