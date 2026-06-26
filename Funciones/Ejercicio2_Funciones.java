package Funciones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio2_Funciones extends JFrame {

    private JTextField aField;
    private JTextField bField;
    private JTextArea outputArea;

    public Ejercicio2_Funciones() {

        setTitle("Ejercicio 2 - Intervalo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        aField = new JTextField(5);
        bField = new JTextField(5);
        JButton button = new JButton("Mostrar");

        outputArea = new JTextArea(12, 30);
        outputArea.setEditable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int a = Integer.parseInt(aField.getText());
                    int b = Integer.parseInt(bField.getText());

                    mostrarIntervalo(a, b);

                } catch (NumberFormatException ex) {
                    outputArea.append("Error: números inválidos\n");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("A:"));
        panel.add(aField);
        panel.add(new JLabel("B:"));
        panel.add(bField);
        panel.add(button);

        add(panel, "North");
        add(new JScrollPane(outputArea), "Center");

        pack();
        setLocationRelativeTo(null);
    }

    public void mostrarIntervalo(int a, int b) {

        outputArea.append("Intervalo:\n");

        for (int i = a; i <= b; i++) {
            outputArea.append(i + "\n");
        }

        outputArea.append("\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new Ejercicio2_Funciones().setVisible(true));
    }
}