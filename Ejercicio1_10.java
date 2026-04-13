import javax.swing.*;

public class EjercicioCircunferencia extends JFrame {

    public EjercicioCircunferencia() {
        setTitle("Ejercicio Circunferencia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField txtRadio = new JTextField(10);
        JButton btn = new JButton("Calcular");
        JLabel resL = new JLabel("Longitud: ");
        JLabel resA = new JLabel("Área: ");

        btn.addActionListener(e -> {
            try {
                double r = Double.parseDouble(txtRadio.getText().trim());
                double l = 2 * Math.PI * r;
                double a = Math.PI * Math.pow(r, 2);

                resL.setText("Longitud: " + String.format("%.2f", l));
                resA.setText("Área: " + String.format("%.2f", a));
            } catch (Exception ex) {
                resL.setText("Error en los datos.");
            }
        });

        JPanel p = new JPanel(new GridLayout(4, 1));
        JPanel inputP = new JPanel();
        inputP.add(new JLabel("Radio:"));
        inputP.add(txtRadio);

        p.add(inputP);
        p.add(btn);
        p.add(resL);
        p.add(resA);

        add(p);
        setSize(300, 200);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EjercicioCircunferencia().setVisible(true));
    }
}