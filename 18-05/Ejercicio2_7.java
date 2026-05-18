import java.util.Arrays;
import javax.swing.*;

public class Ejercicio2_7 extends JFrame {

    public Ejercicio2_7() {
        setTitle("Ejercicio 2.7");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField1 = new JTextField(5);
        JTextField inputField2 = new JTextField(5);
        JTextField inputField3 = new JTextField(5);
        JButton submitButton = new JButton("Ordenar");
        JLabel resultLabel = new JLabel("Orden: ");

        submitButton.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(inputField1.getText().trim());
                double n2 = Double.parseDouble(inputField2.getText().trim());
                double n3 = Double.parseDouble(inputField3.getText().trim());

                double[] numeros = {n1, n2, n3};
                Arrays.sort(numeros);

                resultLabel.setText("Orden: " + numeros[2] + " >= " + numeros[1] + " >= " + numeros[0]);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce números válidos.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("N1:"));
        panel.add(inputField1);
        panel.add(new JLabel("N2:"));
        panel.add(inputField2);
        panel.add(new JLabel("N3:"));
        panel.add(inputField3);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        
        setSize(650, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio2_7 ejercicio = new Ejercicio2_7();
            ejercicio.setVisible(true);
        });
    }
}