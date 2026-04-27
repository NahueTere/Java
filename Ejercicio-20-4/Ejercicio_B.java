import javax.swing.*;
import java.awt.*;

public class Ejercicio_B extends JFrame {

    public Ejercicio_B() {
        setTitle("Ejercicio B");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField txtKmH = new JTextField(10);
        JButton btn = new JButton("Convertir");
        JLabel res = new JLabel("Resultado: ");

        btn.addActionListener(e -> {
            try {
                double v = Double.parseDouble(txtKmH.getText().trim());
                res.setText("m/s: " + String.format("%.2f", v / 3.6));
            } catch (Exception ex) {
                res.setText("Dato no válido.");
            }
        });

        JPanel p = new JPanel(new GridLayout(4, 1));
        p.add(new JLabel("Kilómetros por hora:"));
        p.add(txtKmH);
        p.add(btn);
        p.add(res);

        add(p);
        setSize(300, 200);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio_B().setVisible(true));
    }
}