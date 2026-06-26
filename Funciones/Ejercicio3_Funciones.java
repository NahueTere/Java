package Funciones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio3_Funciones extends JFrame {

    private JTextField opcionField;
    private JTextField radioField;
    private JTextField alturaField;
    private JTextArea outputArea;

    public Ejercicio3_Funciones() {

        setTitle("Ejercicio 3 - Cilindro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        opcionField = new JTextField(5);
        radioField = new JTextField(5);
        alturaField = new JTextField(5);

        JButton button = new JButton("Calcular");
        outputArea = new JTextArea(12, 35);
        outputArea.setEditable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int op = Integer.parseInt(opcionField.getText());
                    double r = Double.parseDouble(radioField.getText());
                    double h = Double.parseDouble(alturaField.getText());

                    calcularCilindro(op, r, h);

                } catch (NumberFormatException ex) {
                    outputArea.append("Error: datos inválidos\n");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Opción (1 área / 2 volumen):"));
        panel.add(opcionField);
        panel.add(new JLabel("Radio:"));
        panel.add(radioField);
        panel.add(new JLabel("Altura:"));
        panel.add(alturaField);
        panel.add(button);

        add(panel, "North");
        add(new JScrollPane(outputArea), "Center");

        pack();
        setLocationRelativeTo(null);
    }

    public void calcularCilindro(int opcion, double radio, double altura) {

        double pi = Math.PI;

        if (opcion == 1) {
            outputArea.append("Área: " + (2 * pi * radio * (altura + radio)) + "\n\n");
        } else if (opcion == 2) {
            outputArea.append("Volumen: " + (pi * radio * radio * altura) + "\n\n");
        } else {
            outputArea.append("Opción inválida\n\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new Ejercicio3_Funciones().setVisible(true));
    }
}