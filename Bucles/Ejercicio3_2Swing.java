package Bucles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio3_2Swing extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    private int suma = 0;
    private int cantidad = 0;
    private int mayores = 0;

    public Ejercicio3_2Swing() {

        setTitle("Ejercicio 2 - Estadísticas de edades");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        JButton submitButton = new JButton("Ingresar edad");
        outputArea = new JTextArea(12, 35);
        outputArea.setEditable(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int edad = Integer.parseInt(inputField.getText());

                    // condición de corte
                    if (edad < 0) {

                        if (cantidad == 0) {
                            outputArea.append("No se ingresaron edades.\n\n");
                        } else {
                            double media = (double) suma / cantidad;

                            outputArea.append("=== RESULTADOS FINALES ===\n");
                            outputArea.append("Suma total: " + suma + "\n");
                            outputArea.append("Cantidad de alumnos: " + cantidad + "\n");
                            outputArea.append("Media: " + media + "\n");
                            outputArea.append("Mayores de edad: " + mayores + "\n\n");
                        }

                        // reiniciar por si sigue usando la app
                        suma = 0;
                        cantidad = 0;
                        mayores = 0;

                        inputField.setText("");
                        return;
                    }

                    // procesamiento
                    suma += edad;
                    cantidad++;

                    if (edad >= 18) {
                        mayores++;
                    }

                    outputArea.append("Edad ingresada: " + edad + "\n");

                    inputField.setText("");

                } catch (NumberFormatException ex) {
                    outputArea.append("Error: ingresá un número válido\n\n");
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Edad:"));
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
            new Ejercicio3_2Swing().setVisible(true);
        });
    }
}