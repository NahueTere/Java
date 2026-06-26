package Funciones;

import javax.swing.*;

public class Ejercicio10_Funciones extends JFrame {

    private JTextField aField;
    private JTextField bField;
    private JTextArea outputArea;

    public Ejercicio10_Funciones() {

        setTitle("Ejercicio 10 - Números amigos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        aField = new JTextField(5);
        bField = new JTextField(5);
        JButton button = new JButton("Verificar");
        outputArea = new JTextArea(12, 30);
        outputArea.setEditable(false);

        button.addActionListener(e -> {

            try {
                int a = Integer.parseInt(aField.getText());
                int b = Integer.parseInt(bField.getText());

                if (sonAmigos(a, b)) {
                    outputArea.append(a + " y " + b + " SON amigos\n\n");
                } else {
                    outputArea.append(a + " y " + b + " NO son amigos\n\n");
                }

            } catch (NumberFormatException ex) {
                outputArea.append("Error: datos inválidos\n\n");
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

    // 🔥 función principal del ejercicio
    public boolean sonAmigos(int a, int b) {
        return sumaDivisoresPropios(a) == sumaDivisoresPropios(b);
    }

    // ✔ clave del ejercicio: NO incluye el número
    public int sumaDivisoresPropios(int n) {

        int suma = 0;

        for (int i = 1; i < n; i++) { // 👈 IMPORTANTE: < n
            if (n % i == 0) {
                suma += i;
            }
        }

        return suma;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new Ejercicio10_Funciones().setVisible(true));
    }
}