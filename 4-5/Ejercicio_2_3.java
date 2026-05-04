import javax.swing.*;
import java.awt.*;

public class Ejercicio_2_3 extends JFrame {

    public Ejercicio_2_3() {
        setTitle("Ejercicio 2.3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);

        JTextField txtN1 = new JTextField(10);
        JTextField txtN2 = new JTextField(10);
        JButton btn = new JButton("¿Cuál es mayor?");
        JLabel res = new JLabel("Resultado: ");

        btn.addActionListener(e -> {
            try {
                int n1 = Integer.parseInt(txtN1.getText().trim());
                int n2 = Integer.parseInt(txtN2.getText().trim());

                if (n1 > n2) {
                    res.setText("El mayor es: " + n1);
                } else if (n2 > n1) {
                    res.setText("El mayor es: " + n2);
                } else {
                    res.setText("Son iguales.");
                }
                res.setForeground(new Color(0, 100, 200));
            } catch (NumberFormatException ex) {
                res.setText("Error: Ingrese números válidos");
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
        SwingUtilities.invokeLater(() -> new Ejercicio_2_3().setVisible(true));
    }
}