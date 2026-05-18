import javax.swing.*;

public class Ejercicio2_10Swing extends JFrame {

    public Ejercicio2_10Swing() {
        setTitle("Ejercicio 2.10 - Capicúa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Verificar");
        JLabel resultLabel = new JLabel("Resultado: ");

        submitButton.addActionListener(e -> {
            try {
                // 1. Tomamos el texto limpio y lo convertimos a número para validar rango
                String textoOriginal = inputField.getText().trim();
                int num = Integer.parseInt(textoOriginal);

                if (num < 0 || num > 9999) {
                    resultLabel.setText("Error: El número debe estar entre 0 y 9.999.");
                } else {
                    // 2. Usamos StringBuilder para dar vuelta la cadena de texto
                    String textoInvertido = new StringBuilder(textoOriginal).reverse().toString();

                    // 3. Si el texto al derecho es igual al texto al revés, es capicúa
                    if (textoOriginal.equals(textoInvertido)) {
                        resultLabel.setText("El número " + num + " es CAPICÚA.");
                    } else {
                        resultLabel.setText("El número " + num + " NO es capicúa.");
                    }
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número entero.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número (0-9999):"));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);

        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio2_10Swing ejercicio = new Ejercicio2_10Swing();
            ejercicio.setVisible(true);
        });
    }
}