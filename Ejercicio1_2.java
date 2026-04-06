import javax.swing.*;

public class Ejercicio1_2 extends JFrame {

    public Ejercicio1_2() {
        setTitle("Ejercicio 1.2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("El año que viene tendras: ");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());
                int edad = num+1;
                resultLabel.setText("El año que viene tendras: " + edad);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba su edad: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio1_2 ejercicio = new Ejercicio1_2();
            ejercicio.setVisible(true);
        });
    }
}
