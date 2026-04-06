import javax.swing.*;


public class Ejercicio1_5 extends JFrame {

    public Ejercicio1_5() {
        setTitle("Ejercicio 1.5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField txtNota1 = new JTextField(5);
        JTextField txtNota2 = new JTextField(5);
        JButton btnCalcular = new JButton("Calcular Media");
        JLabel lblResultado = new JLabel("Resultado: ");

        btnCalcular.addActionListener(e -> {
            try {
                int n1 = Integer.parseInt(txtNota1.getText().trim());
                int n2 = Integer.parseInt(txtNota2.getText().trim());
                double media = (n1 + n2) / 2.0;
                lblResultado.setText("La media aritmética es: " + media);
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Use números enteros.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nota 1:"));
        panel.add(txtNota1);
        panel.add(new JLabel("Nota 2:"));
        panel.add(txtNota2);
        panel.add(btnCalcular);
        panel.add(lblResultado);

        add(panel);
        setSize(500, 120);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio1_5().setVisible(true));
    }
}