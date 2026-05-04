import javax.swing.*;
import java.awt.*;

public class Ejercicio_2_2 extends JFrame {

    public Ejercicio_2_2() {
        setTitle("Ejercicio 2.2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);

        JTextField txtN1 = new JTextField(10);
        JTextField txtN2 = new JTextField(10);
        JButton btn = new JButton("Comparar");
        JLabel res = new JLabel("Resultado: ");

        btn.addActionListener(e -> {
            try {
                int n1 = Integer.parseInt(txtN1.getText().trim());
                int n2 = Integer.parseInt(txtN2.getText().trim());

                if (n1 == n2) {
                    res.setText("Los números son IGUALES");
                    res.setForeground(new Color(0, 150, 0)); // Verde
                } else {
                    res.setText("Los números son DIFERENTES");
                    res.setForeground(Color.RED);
                }
            } catch (NumberFormatException ex) {
                res.setText("Error: Ingrese números enteros");
                res.setForeground(Color.BLACK);
            }
        });

        JPanel p = new JPanel(new GridLayout(6, 1, 5, 5));
        p.add(new JLabel("Primer número:"));
        p.add(txtN1);
        p.add(new JLabel("Segundo número:"));
        p.add(txtN2);
        p.add(btn);
        p.add(res);

        add(p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio_2_2().setVisible(true));
    }
}