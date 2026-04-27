import javax.swing.*;
import java.awt.*;

public class Ejercicio_C extends JFrame {

    public Ejercicio_C() {
        setTitle("Ejercicio C");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField txtA = new JTextField(10);
        JTextField txtB = new JTextField(10);
        JButton btn = new JButton("Calcular");
        JLabel res = new JLabel("Hipotenusa: ");

        btn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(txtA.getText().trim());
                double b = Double.parseDouble(txtB.getText().trim());
                double h = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                res.setText("Resultado: " + String.format("%.2f", h));
            } catch (Exception ex) {
                res.setText("Datos inválidos.");
            }
        });

        JPanel p = new JPanel(new GridLayout(6, 1));
        p.add(new JLabel("Cateto A:"));
        p.add(txtA);
        p.add(new JLabel("Cateto B:"));
        p.add(txtB);
        p.add(btn);
        p.add(res);

        add(p);
        setSize(300, 250);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio_C().setVisible(true));
    }
}