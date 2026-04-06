import javax.swing.*;

public class Ejercicio1_6 extends JFrame {

    public Ejercicio1_6() {
        setTitle("Ejercicio 1.6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField txt1 = new JTextField(4);
        JTextField txt2 = new JTextField(4);
        JTextField txt3 = new JTextField(4);
        JButton btn = new JButton("Calcular");
        JLabel res = new JLabel("Resultado: ");

        btn.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(txt1.getText().trim());
                double n2 = Double.parseDouble(txt2.getText().trim());
                double n3 = Double.parseDouble(txt3.getText().trim());
                
                int parteEntera = (int) ((n1 + n2 + n3) / 3.0);
                
                res.setText("Parte entera: " + parteEntera);
            } catch (NumberFormatException ex) {
                res.setText("Error en los datos.");
            }
        });

        JPanel p = new JPanel();
        p.add(new JLabel("N1:")); p.add(txt1);
        p.add(new JLabel("N2:")); p.add(txt2);
        p.add(new JLabel("N3:")); p.add(txt3);
        p.add(btn);
        p.add(res);

        add(p);
        setSize(550, 120);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio1_6().setVisible(true);
        });
    }
}