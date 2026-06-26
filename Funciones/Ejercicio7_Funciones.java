package Funciones;

import javax.swing.*;

public class Ejercicio7_Funciones extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public Ejercicio7_Funciones() {

        setTitle("Ejercicio 7 - Primo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        JButton button = new JButton("Verificar");
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        button.addActionListener(e -> {

            int n = Integer.parseInt(inputField.getText());

            if (esPrimo(n)) {
                outputArea.append(n + " es primo\n\n");
            } else {
                outputArea.append(n + " no es primo\n\n");
            }
        });

        JPanel p = new JPanel();
        p.add(new JLabel("Número:"));
        p.add(inputField);
        p.add(button);

        add(p, "North");
        add(new JScrollPane(outputArea), "Center");

        pack();
        setLocationRelativeTo(null);
    }

    public boolean esPrimo(int n) {

        if (n < 2) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new Ejercicio7_Funciones().setVisible(true));
    }
}