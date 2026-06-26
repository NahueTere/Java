package Bucles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio13_Swing extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    private int aprobados = 0;
    private int condicionados = 0;
    private int desaprobados = 0;
    private int contador = 0;

    public Ejercicio13_Swing() {

        setTitle("Ejercicio 13 - Estadísticas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        JButton button = new JButton("Ingresar nota");
        outputArea = new JTextArea(12, 35);
        outputArea.setEditable(false);

        button.addActionListener(e -> {

            try {
                int nota = Integer.parseInt(inputField.getText());

                if (nota < 0 || nota > 10) {
                    outputArea.append("Nota inválida\n");
                    return;
                }

                contador++;

                if (nota >= 6) {
                    aprobados++;
                } else if (nota == 4) {
                    condicionados++;
                } else {
                    desaprobados++;
                }

                outputArea.append("Nota: " + nota + "\n");

                if (contador == 6) {

                    outputArea.append("\n=== RESULTADOS ===\n");
                    outputArea.append("Aprobados: " + aprobados + "\n");
                    outputArea.append("Condicionados: " + condicionados + "\n");
                    outputArea.append("Desaprobados: " + desaprobados + "\n");

                    button.setEnabled(false);
                }

                inputField.setText("");

            } catch (Exception ex) {
                outputArea.append("Error\n");
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
        SwingUtilities.invokeLater(() -> new Ejercicio13_Swing().setVisible(true));
    }
}