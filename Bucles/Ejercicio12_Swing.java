package Bucles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio12_Swing extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    private int contador = 0;
    private boolean hayDesaprobado = false;

    public Ejercicio12_Swing() {

        setTitle("Ejercicio 12 - Desaprobados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        JButton button = new JButton("Ingresar nota");
        outputArea = new JTextArea(12, 35);
        outputArea.setEditable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int nota = Integer.parseInt(inputField.getText());

                    if (nota < 0 || nota > 10) {
                        outputArea.append("Nota inválida\n");
                        return;
                    }

                    contador++;

                    if (nota < 4) {
                        hayDesaprobado = true;
                    }

                    outputArea.append("Nota ingresada: " + nota + "\n");

                    if (contador == 5) {

                        if (hayDesaprobado) {
                            outputArea.append("\nHay al menos un desaprobado (<4)\n");
                        } else {
                            outputArea.append("\nNo hay desaprobados\n");
                        }

                        button.setEnabled(false);
                    }

                    inputField.setText("");

                } catch (NumberFormatException ex) {
                    outputArea.append("Error\n");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nota:"));
        panel.add(inputField);
        panel.add(button);

        add(panel, "North");
        add(new JScrollPane(outputArea), "Center");

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio12_Swing().setVisible(true));
    }
}