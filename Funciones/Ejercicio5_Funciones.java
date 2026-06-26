package Funciones;

import javax.swing.*;

public class Ejercicio5_Funciones extends JFrame {

    private JTextField aField;
    private JTextField bField;
    private JTextField cField;
    private JTextArea outputArea;

    public Ejercicio5_Funciones() {

        setTitle("Ejercicio 5 - Máximo de 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        aField = new JTextField(5);
        bField = new JTextField(5);
        cField = new JTextField(5);

        JButton button = new JButton("Calcular");
        outputArea = new JTextArea(12, 30);
        outputArea.setEditable(false);

        button.addActionListener(e -> {

            int a = Integer.parseInt(aField.getText());
            int b = Integer.parseInt(bField.getText());
            int c = Integer.parseInt(cField.getText());

            outputArea.append("Máximo: " + maximo(a, b, c) + "\n\n");
        });

        JPanel panel = new JPanel();
        panel.add(aField);
        panel.add(bField);
        panel.add(cField);
        panel.add(button);

        add(panel, "North");
        add(new JScrollPane(outputArea), "Center");

        pack();
        setLocationRelativeTo(null);
    }

    public int maximo(int a, int b, int c) {

        int m = a;
        if (b > m) m = b;
        if (c > m) m = c;
        return m;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new Ejercicio5_Funciones().setVisible(true));
    }
}