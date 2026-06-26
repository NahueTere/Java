package Bucles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio3_1Swing extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public Ejercicio3_1Swing() {
        setTitle("Ejercicio 1 - Bucles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        JButton submitButton = new JButton("Introducir número");
        outputArea = new JTextArea(12, 30);
        outputArea.setEditable(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int num = Integer.parseInt(inputField.getText());

                    // condición de corte
                    if (num == 0) {
                        outputArea.append("Proceso finalizado (ingresaste 0)\n\n");
                        inputField.setText("");
                        return;
                    }

                    boolean esPar = num % 2 == 0;
                    boolean esPositivo = num > 0;
                    int cuadrado = num * num;

                    outputArea.append("Número: " + num + "\n");
                    outputArea.append("¿Es par?: " + esPar + "\n");
                    outputArea.append("¿Es positivo?: " + esPositivo + "\n");
                    outputArea.append("Cuadrado: " + cuadrado + "\n\n");

                    inputField.setText("");

                } catch (NumberFormatException ex) {
                    outputArea.append("Error: ingresá un número válido\n\n");
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Número:"));
        inputPanel.add(inputField);
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
            new Ejercicio3_1Swing().setVisible(true);
        });
    }
}