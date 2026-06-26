package Bucles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio9_Swing extends JFrame {

    private JTextField alturaField;
    private JTextArea outputArea;

    private int id = 0;
    private int maxAltura = 0;
    private int idMax = -1;

    public Ejercicio9_Swing() {

        setTitle("Ejercicio 9 - Árbol más alto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        alturaField = new JTextField(10);
        JButton button = new JButton("Ingresar árbol");
        outputArea = new JTextArea(12, 35);
        outputArea.setEditable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int altura = Integer.parseInt(alturaField.getText());

                    if (altura == -1) {

                        outputArea.append("\n=== RESULTADO FINAL ===\n");
                        outputArea.append("Árbol más alto ID: " + idMax + "\n");
                        outputArea.append("Altura: " + maxAltura + " cm\n\n");

                        button.setEnabled(false);
                        return;
                    }

                    if (altura > maxAltura) {
                        maxAltura = altura;
                        idMax = id;
                    }

                    outputArea.append("Árbol ID " + id + " - altura: " + altura + "\n");

                    id++;

                    alturaField.setText("");

                } catch (NumberFormatException ex) {
                    outputArea.append("Error: número inválido\n\n");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Altura (cm):"));
        panel.add(alturaField);
        panel.add(button);

        add(panel, "North");
        add(new JScrollPane(outputArea), "Center");

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio9_Swing().setVisible(true));
    }
}