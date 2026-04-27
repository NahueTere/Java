import javax.swing.*;
import java.awt.*;

public class Ejercicio_F extends JFrame {

    public Ejercicio_F() {
        setTitle("Ejercicio F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField txtN = new JTextField(10);
        JButton btn = new JButton("Separar");
        JLabel res = new JLabel("Cifras separadas:");

        btn.addActionListener(e -> {
            try {
                int n = Integer.parseInt(txtN.getText().trim());
                int c = n / 100;
                int d = (n / 10) % 10;
                int u = n % 10;
                res.setText("Cifras: " + c + " , " + d + " , " + u);
            } catch (Exception ex) {
                res.setText("Dato inválido.");
            }
        });

        JPanel p = new JPanel(new GridLayout(4, 1));
        p.add(new JLabel("Ingrese número (3 cifras):"));
        p.add(txtN);
        p.add(btn);
        p.add(res);

        add(p);
        setSize(300, 200);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio_F().setVisible(true));
    }
}