package Funciones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio1_Funciones extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public Ejercicio1_Funciones() {

        setTitle("Ejercicio 1 - Eco");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        JButton button = new JButton("Ejecutar");
        outputArea = new JTextArea(12, 30);
        outputArea.setEditable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int n = Integer.parseInt(inputField.getText());
                    eco(n);
                } catch (NumberFormatException ex) {
                    outputArea.append("Error: número inválido\n");
                }
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

    public void eco(int n) {
        outputArea.append("Resultado:\n");
        for (int i = 0; i < n; i++) {
            outputArea.append("Eco\n");
        }
        outputArea.append("\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new Ejercicio1_Funciones().setVisible(true));
    }
}