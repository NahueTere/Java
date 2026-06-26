package Funciones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio4_Funciones extends JFrame {

    private JTextField aField;
    private JTextField bField;
    private JTextArea outputArea;

    public Ejercicio4_Funciones() {

        setTitle("Ejercicio 4 - Máximo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        aField = new JTextField(5);
        bField = new JTextField(5);
        JButton button = new JButton("Calcular");

        outputArea = new JTextArea(12, 30);
        outputArea.setEditable(false);

        button.addActionListener(e -> {
            int a = Integer.parseInt(aField.getText());
            int b = Integer.parseInt(bField.getText());
            outputArea.append("Máximo: " + maximo(a, b) + "\n\n");
        });

        JPanel panel = new JPanel();
        panel.add(aField);
        panel.add(bField);
        panel.add(button);

        add(panel, "North");
        add(new JScrollPane(outputArea), "Center");

        pack();
        setLocationRelativeTo(null);
    }

    public int maximo(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new Ejercicio4_Funciones().setVisible(true));
    }
}