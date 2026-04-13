import javax.swing.*;

public class EjercicioFrutero extends JFrame {

    public EjercicioFrutero() {
        setTitle("Ejercicio Frutero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField[] m = {new JTextField(3), new JTextField(3), new JTextField(3), new JTextField(3)};
        JTextField[] p = {new JTextField(3), new JTextField(3), new JTextField(3), new JTextField(3)};
        JButton btn = new JButton("Calcular");
        JLabel res = new JLabel("Total: ");

        btn.addActionListener(e -> {
            try {
                double kgM = 0, kgP = 0;
                for(int i=0; i<4; i++) {
                    kgM += Double.parseDouble(m[i].getText());
                    kgP += Double.parseDouble(p[i].getText());
                }
                double total = (kgM * 2.35) + (kgP * 1.95);
                res.setText("Importe Total: " + String.format("%.2f", total) + "€");
            } catch (Exception ex) {
                res.setText("Error en los datos.");
            }
        });

        JPanel panel = new JPanel(new GridLayout(4, 1));
        JPanel f1 = new JPanel(); f1.add(new JLabel("Manzanas (T1-T4):")); for(JTextField f : m) f1.add(f);
        JPanel f2 = new JPanel(); f2.add(new JLabel("Peras (T1-T4):")); for(JTextField f : p) f2.add(f);
        
        panel.add(f1);
        panel.add(f2);
        panel.add(btn);
        panel.add(res);

        add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EjercicioFrutero().setVisible(true));
    }
}