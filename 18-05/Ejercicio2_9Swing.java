import javax.swing.*;

public class Ejercicio2_9Swing extends JFrame {

    public Ejercicio2_9Swing() {
        setTitle("Ejercicio 2.9 - Contar Cifras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Calcular");
        JLabel resultLabel = new JLabel("Cifras: ");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText().trim());

                // Validamos primero que el número esté dentro del rango permitido
                if (num < 0 || num > 99999) {
                    resultLabel.setText("Error: El número debe estar entre 0 y 99.999.");
                } else {
                    // Evaluamos los rangos de menor a mayor
                    if (num < 10) {
                        resultLabel.setText("El número tiene 1 cifra.");
                    } else if (num < 100) {
                        resultLabel.setText("El número tiene 2 cifras.");
                    } else if (num < 1000) {
                        resultLabel.setText("El número tiene 3 cifras.");
                    } else if (num < 10000) {
                        resultLabel.setText("El número tiene 4 cifras.");
                    } else {
                        resultLabel.setText("El número tiene 5 cifras.");
                    }
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número entero.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número (0-99999):"));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);

        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio2_9Swing ejercicio = new Ejercicio2_9Swing();
            ejercicio.setVisible(true);
        });
    }
}