import javax.swing.*;
import java.awt.*;

public class Ejercicio_E extends JFrame {

    public Ejercicio_E() {
        setTitle("Ejercicio E");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField txtA = new JTextField(5);
        JTextField txtB = new JTextField(5);
        JTextField txtC = new JTextField(5);
        JButton btn = new JButton("Calcular Área");
        JLabel res = new JLabel("Resultado: ");

        btn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(txtA.getText().trim());
                double b = Double.parseDouble(txtB.getText().trim());
                double c = Double.parseDouble(txtC.getText().trim());
                double p = (a + b + c) / 2.0;
                double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                
                if (area > 0) res.setText("Área: " + String.format("%.2f", area));
                else res.setText("Triángulo no válido.");
            } catch (Exception ex) {
                res.setText("Dato inválido.");
            }
        });

        JPanel pnl = new JPanel(new GridLayout(5, 2));
        pnl.add(new JLabel("Lado A:")); pnl.add(txtA);
        pnl.add(new JLabel("Lado B:")); pnl.add(txtB);
        pnl.add(new JLabel("Lado C:")); pnl.add(txtC);
        pnl.add(btn); pnl.add(res);

        add(pnl);
        pack();
        setSize(300, 250);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio_E().setVisible(true));
    }
}