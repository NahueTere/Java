package Funciones;

import javax.swing.*;

public class Ejercicio9_Funciones extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public Ejercicio9_Funciones() {

        setTitle("Ejercicio 9 - Divisores primos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        JButton button = new JButton("Mostrar");
        outputArea = new JTextArea(12, 30);
        outputArea.setEditable(false);

        button.addActionListener(e -> {

            int n = Integer.parseInt(inputField.getText());

            outputArea.append("Divisores primos de " + n + ":\n");
            divisoresPrimos(n);
            outputArea.append("\n");
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

    public void divisoresPrimos(int n) {

        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && esPrimo(i)) {
                outputArea.append(i + "\n");
            }
        }
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
                new Ejercicio9_Funciones().setVisible(true));
    }
}