package Funciones;

import javax.swing.*;

public class Ejercicio8_Funciones extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public Ejercicio8_Funciones() {

        setTitle("Ejercicio 8 - Divisores primos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(10);
        JButton button = new JButton("Calcular");
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        button.addActionListener(e -> {

            int n = Integer.parseInt(inputField.getText());

            int res = contarDivisoresPrimos(n);

            outputArea.append("Divisores primos: " + res + "\n\n");
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

    public int contarDivisoresPrimos(int n) {

        int cont = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && esPrimo(i)) {
                cont++;
            }
        }

        return cont;
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
                new Ejercicio8_Funciones().setVisible(true));
    }
}