import javax.swing.*;
import java.awt.*;

public class Ejercicio_2_6 extends JFrame {

    public Ejercicio_2_6() {
        setTitle("Ejercicio 2.6 - Orden Decreciente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);

        JTextField txtN1 = new JTextField(10);
        JTextField txtN2 = new JTextField(10);
        JButton btn = new JButton("Ordenar");
        JLabel res = new JLabel("Resultado: ");

        btn.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(txtN1.getText().trim());
                double n2 = Double.parseDouble(txtN2.getText().trim());

                if (n1 >= n2) {
                    res.setText("Orden: " + n1 + " , " + n2);
                } else {
                    res.setText("Orden: " + n2 + " , " + n1);
                }
                res.setForeground(new Color(0, 100, 0));
            } catch (Exception ex) {
                res.setText("Error: Ingrese números");
                res.setForeground(Color.RED);
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
        SwingUtilities.invokeLater(() -> new Ejercicio_2_6().setVisible(true));
    }
}