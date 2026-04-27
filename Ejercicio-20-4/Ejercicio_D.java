import javax.swing.*;
import java.awt.*;

// El nombre de la clase debe coincidir con el archivo Ejercicio_D.java
public class Ejercicio_D extends JFrame {

    public Ejercicio_D() {
        // Configuración de la ventana principal
        setTitle("Ejercicio D - Volumen de la Esfera");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Componentes: entrada de texto, botón y etiqueta de resultado
        JTextField txtRadio = new JTextField(10);
        JButton btnCalcular = new JButton("Calcular Volumen");
        JLabel lblResultado = new JLabel("Resultado: ");

        // Acción que ocurre al pulsar el botón
        btnCalcular.addActionListener(e -> {
            try {
                // 1. Obtenemos el radio como número decimal (double)
                double radio = Double.parseDouble(txtRadio.getText().trim());

                /* 2. Aplicamos la fórmula: v = (4/3) * PI * r³
                 * Usamos 4.0 / 3.0 para que Java no trunque los decimales.
                 * Math.pow(radio, 3) eleva el radio al cubo.
                 */
                double volumen = (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);

                // 3. Mostramos el resultado limitado a 2 decimales
                lblResultado.setText(String.format("El volumen es: %.2f", volumen));
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Ingrese un valor numérico.");
            }
        });

        // Diseño: Panel con GridLayout (4 filas, 1 columna)
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.add(new JLabel("Ingrese el radio de la esfera:"));
        panel.add(txtRadio);
        panel.add(btnCalcular);
        panel.add(lblResultado);

        add(panel);
        setSize(300, 200);
        setLocationRelativeTo(null); // Centra la ventana
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio_D().setVisible(true);
        });
    }
}