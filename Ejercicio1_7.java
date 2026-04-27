import javax.swing.*;

public class Ejercicio1_7 extends JFrame {

    public Ejercicio1_7() {
        setTitle("Ejercicio 1.7");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField txtDecimal = new JTextField(10);
        JButton btnRedondear = new JButton("Redondear");
        JLabel lblResultado = new JLabel("Ingrese un número decimal");

        btnRedondear.addActionListener(e -> {
            try {
                double num = Double.parseDouble(txtDecimal.getText().trim());
                long resultado = Math.round(num);
                lblResultado.setText("Redondeado: " + resultado);
            } catch (NumberFormatException ex) {
                lblResultado.setText("Entrada no válida.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Decimal:"));
        panel.add(txtDecimal);
        panel.add(btnRedondear);
        panel.add(lblResultado);

        add(panel);
        setSize(400, 130);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio1_7().setVisible(true);
        });
    }
}