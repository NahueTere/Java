package Bucles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Ejercicio3_Swing extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    private int numeroSecreto;

    public Ejercicio3_Swing() {

        setTitle("Ejercicio 3 - Número secreto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        JButton submitButton = new JButton("Probar número");
        outputArea = new JTextArea(12, 35);
        outputArea.setEditable(false);

        Random rand = new Random();
        numeroSecreto = rand.nextInt(100) + 1;

        outputArea.append("🎮 Adiviná el número entre 1 y 100\n");
        outputArea.append("(-1 para rendirse)\n\n");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int intento = Integer.parseInt(inputField.getText());

                    if (intento == -1) {
                        outputArea.append("Te rendiste 😅 El número era: " + numeroSecreto + "\n\n");
                        inputField.setText("");
                        submitButton.setEnabled(false);
                        return;
                    }

                    if (intento == numeroSecreto) {
                        outputArea.append("🎉 ¡Correcto! Adivinaste el número\n\n");
                        submitButton.setEnabled(false);
                        return;
                    }

                    if (intento < numeroSecreto) {
                        outputArea.append("📈 El número es MAYOR\n");
                    } else {
                        outputArea.append("📉 El número es MENOR\n");
                    }

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
            new Ejercicio3_Swing().setVisible(true);
        });
    }
}