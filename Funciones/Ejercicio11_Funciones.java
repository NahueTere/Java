package Funciones;

import javax.swing.*;

public class Ejercicio11_Funciones extends JFrame {

    private JTextField aField;
    private JTextField nField;
    private JTextArea outputArea;

    public Ejercicio11_Funciones() {

        setTitle("Ejercicio 11 - Potencia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        aField = new JTextField(5);
        nField = new JTextField(5);
        JButton button = new JButton("Calcular");
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        button.addActionListener(e -> {

            double a = Double.parseDouble(aField.getText());
            int n = Integer.parseInt(nField.getText());

            outputArea.append("Resultado: " + potencia(a, n) + "\n\n");
        });

        JPanel p = new JPanel();
        p.add(new JLabel("a:"));
        p.add(aField);
        p.add(new JLabel("n:"));
        p.add(nField);
        p.add(button);

        add(p, "North");
        add(new JScrollPane(outputArea), "Center");

        pack();
        setLocationRelativeTo(null);
    }

    public double potencia(double a, int n) {

        double res = 1;

        for (int i = 0; i < n; i++) {
            res *= a;
        }

        return res;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new Ejercicio11_Funciones().setVisible(true));
    }
}