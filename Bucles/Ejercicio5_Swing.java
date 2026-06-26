package Bucles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio5_Swing extends JFrame {

    private JTextField minField;
    private JTextField maxField;
    private JTextField numField;
    private JTextArea outputArea;

    public Ejercicio5_Swing() {

        setTitle("Ejercicio 5 - Validación de rango");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        minField = new JTextField(5);
        maxField = new JTextField(5);
        numField = new JTextField(5);

        JButton submitButton = new JButton("Validar");
        outputArea = new JTextArea(12, 35);
        outputArea.setEditable(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int min = Integer.parseInt(minField.getText());
                    int max = Integer.parseInt(maxField.getText());
                    int num = Integer.parseInt(numField.getText());

                    if (min > max) {
                        outputArea.append("Error: el mínimo no puede ser mayor que el máximo\n\n");
                        return;
                    }

                    // while de validación
                    while (num < min || num > max) {
                        outputArea.append("❌ Fuera de rango: " + num + "\n");
                        outputArea.append("Ingresá otro número...\n\n");
                        return; // en Swing se hace iterativo por eventos
                    }

                    outputArea.append("✔ Número válido: " + num + "\n\n");

                    minField.setText("");
                    maxField.setText("");
                    numField.setText("");

                } catch (NumberFormatException ex) {
                    outputArea.append("Error: ingresá números válidos\n\n");
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Min:"));
        inputPanel.add(minField);
        inputPanel.add(new JLabel("Max:"));
        inputPanel.add(maxField);
        inputPanel.add(new JLabel("Num:"));
        inputPanel.add(numField);
        inputPanel.add(submitButton);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(inputPanel);
        mainPanel.add(scrollPane);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio5_Swing().setVisible(true);
        });
    }
}