import javax.swing.*;

public class Ejercicio2_8Swing extends JFrame {

    public Ejercicio2_8Swing() {
        setTitle("Ejercicio 2.8 - Ecuación 2° Grado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tres cajas de texto para los coeficientes a, b y c
        JTextField inputA = new JTextField(4);
        JTextField inputB = new JTextField(4);
        JTextField inputC = new JTextField(4);
        JButton submitButton = new JButton("Calcular");
        JLabel resultLabel = new JLabel("Resultado: ");

        submitButton.addActionListener(e -> {
            try {
                double a = Double.parseDouble(inputA.getText().trim());
                double b = Double.parseDouble(inputB.getText().trim());
                double c = Double.parseDouble(inputC.getText().trim());

                // Controlar que 'a' no sea 0, porque no sería de segundo grado y dividiría por cero
                if (a == 0) {
                    resultLabel.setText("El coeficiente 'a' no puede ser 0.");
                    return;
                }

                // Calculamos el discriminante (lo de adentro de la raíz)
                double discriminante = (b * b) - (4 * a * c);

                if (discriminante < 0) {
                    resultLabel.setText("No existen soluciones reales (raíz negativa).");
                } else {
                    // Calculamos las dos soluciones usando Math.sqrt (Raíz cuadrada)
                    double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                    double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);

                    if (x1 == x2) {
                        resultLabel.setText("Solución única: X = " + x1);
                    } else {
                        resultLabel.setText("Soluciones: X1 = " + String.format("%.2f", x1) + " | X2 = " + String.format("%.2f", x2));
                    }
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce números válidos.");
            }
        });

        // Metemos todo en tu panel lineal
        JPanel panel = new JPanel();
        panel.add(new JLabel("a:"));
        panel.add(inputA);
        panel.add(new JLabel("b:"));
        panel.add(inputB);
        panel.add(new JLabel("c:"));
        panel.add(inputC);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);

        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio2_8Swing ejercicio = new Ejercicio2_8Swing();
            ejercicio.setVisible(true);
        });
    }
}