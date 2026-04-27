import javax.swing.*;
import java.awt.*;

public class Ejercicio1_9 extends JFrame {

    public Ejercicio1_9() {
        setTitle("Ejercicio 1.8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField txtPM = new JTextField(4);
        JTextField txtPP = new JTextField(4);
        JTextField[] m = {new JTextField(3), new JTextField(3), new JTextField(3), new JTextField(3)};
        JTextField[] p = {new JTextField(3), new JTextField(3), new JTextField(3), new JTextField(3)};
        JButton btn = new JButton("Calcular Total");
        JLabel res = new JLabel("Resultado: ");

        btn.addActionListener(e -> {
            try {
                double pM = Double.parseDouble(txtPM.getText());
                double pP = Double.parseDouble(txtPP.getText());
                double kM = 0, kP = 0;
                for(int i=0; i<4; i++) {
                    kM += Double.parseDouble(m[i].getText());
                    kP += Double.parseDouble(p[i].getText());
                }
                double total = (kM * pM) + (kP * pP);
                res.setText("Total Anual: " + String.format("%.2f", total));
            } catch (Exception ex) {
                res.setText("Error en los datos.");
            }
        });

        JPanel main = new JPanel(new GridLayout(5, 1));
        JPanel r1 = new JPanel(); r1.add(new JLabel("Precios M/P:")); r1.add(txtPM); r1.add(txtPP);
        JPanel r2 = new JPanel(); r2.add(new JLabel("Manzanas:")); for(JTextField f : m) r2.add(f);
        JPanel r3 = new JPanel(); r3.add(new JLabel("Peras:")); for(JTextField f : p) r3.add(f);
        
        main.add(r1); main.add(r2); main.add(r3); main.add(btn); main.add(res);
        add(main);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio1_9().setVisible(true));
    }
}