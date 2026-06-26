package Bucles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio4_Swing extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public Ejercicio4_Swing() {

        setTitle("Ejercicio 4 - Contar hasta n");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        JButton submitButton = new JButton("Contar");
        outputArea = new JTextArea(12, 35);
        outputArea.setEditable(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int n = Integer.parseInt(inputField.getText());

                    if (n <= 0) {
                        outputArea.append("Ingresá un número mayor a 0\n\n");
                        inputField.setText("");
                        return;
                    }

                    outputArea.append("Contando del 1 al " + n + ":\n");

                    for (int i = 1; i <= n; i++) {
                        outputArea.append(i + "\n");
                    }

                    outputArea.append("\n");

                    inputField.setText("");

                } catch (NumberFormatException ex) {
                    outputArea.append("Error: ingresá un número válido\n\n");
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("n:"));
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
            new Ejercicio4_Swing().setVisible(true);
        });
    }
}