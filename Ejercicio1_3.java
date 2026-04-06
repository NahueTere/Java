import javax.swing.*;

public class Ejercicio1_3 extends JFrame {

    public Ejercicio1_3() {
        setTitle("Ejercicio 1.3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JTextField añoactualField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("tienes: ");

        submitButton.addActionListener(e -> {
            try {
                int añonacimiento = Integer.parseInt(inputField.getText());
                int añoactual = Integer.parseInt(añoactualField.getText());
                int edad = añoactual-añonacimiento;
                resultLabel.setText("tienes: " + edad + " años");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba su año de nacimiento: "));
        panel.add(inputField);
        panel.add(new JLabel("Escriba el año actual: "));
        panel.add(añoactualField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio1_3 ejercicio = new Ejercicio1_3();
            ejercicio.setVisible(true);
        });
    }
}
