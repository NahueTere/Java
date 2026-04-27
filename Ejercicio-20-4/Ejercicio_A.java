import javax.swing.*;
import java.awt.*;

public class Ejercicio_A extends JFrame {

    public Ejercicio_A() {
        setTitle("Ejercicio A");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField txtC = new JTextField(10);
        JButton btn = new JButton("Convertir");
        JLabel res = new JLabel("Resultado: ");

        btn.addActionListener(e -> {
            try {
                double c = Double.parseDouble(txtC.getText().trim());
                double f = 32 + (9 * c / 5);
                res.setText("Fahrenheit: " + String.format("%.2f", f));
            } catch (Exception ex) {
                res.setText("Dato inválido.");
            }
        });

        JPanel p = new JPanel(new GridLayout(4, 1));
        p.add(new JLabel("Ingrese Celsius:"));
        p.add(txtC);
        p.add(btn);
        p.add(res);

        add(p);
        setSize(300, 200);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio_A().setVisible(true));
    }
}