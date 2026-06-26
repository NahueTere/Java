package Funciones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio6_Funciones extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public Ejercicio6_Funciones() {

        setTitle("Ejercicio 6 - Vocal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(5);
        JButton button = new JButton("Verificar");
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        button.addActionListener(e -> {
            char c = inputField.getText().charAt(0);

            if (esVocal(c)) {
                outputArea.append(c + " es vocal\n\n");
            } else {
                outputArea.append(c + " no es vocal\n\n");
            }
        });

        JPanel p = new JPanel();
        p.add(new JLabel("Carácter:"));
        p.add(inputField);
        p.add(button);

        add(p, "North");
        add(new JScrollPane(outputArea), "Center");

        pack();
        setLocationRelativeTo(null);
    }

    public boolean esVocal(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new Ejercicio6_Funciones().setVisible(true));
    }
}