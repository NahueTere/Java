import javax.swing.*;
import java.awt.*;

public class Ejercicio2_11Swing extends JFrame {

    public Ejercicio2_11Swing() {
        // Configuración de la ventana principal
        setTitle("Ejercicio 2.11 - Clasificación de Notas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Componentes de la interfaz
        JTextField inputNota = new JTextField(5);
        JButton btnVerificar = new JButton("Clasificar Nota");
        JLabel resultLabel = new JLabel("Resultado: esperando nota...");

        // Acción del botón al hacer clic
        btnVerificar.addActionListener(e -> {
            try {
                // Leemos el número ingresado en la caja de texto
                int nota = Integer.parseInt(inputNota.getText().trim());

                // Estructura condicional para evaluar los rangos de las notas
                if (nota < 0 || nota > 10) {
                    resultLabel.setText("Error: La nota debe estar entre 0 y 10.");
                } else if (nota >= 0 && nota <= 4) {
                    resultLabel.setText("Resultado: Insuficiente");
                } else if (nota == 5) {
                    resultLabel.setText("Resultado: Suficiente");
                } else if (nota == 6) {
                    resultLabel.setText("Resultado: Bien");
                } else if (nota == 7 || nota == 8) {
                    resultLabel.setText("Resultado: Notable");
                } else if (nota == 9 || nota == 10) {
                    resultLabel.setText("Resultado: Sobresaliente");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Ingrese un número entero válido.");
            }
        });

        // Armado del panel con la distribución de los componentes
        JPanel panel = new JPanel();
        panel.add(new JLabel("Nota (0-10):"));
        panel.add(inputNota);
        panel.add(btnVerificar);
        
        // Separador para mandar el resultado a una nueva línea de forma prolija
        panel.add(Box.createHorizontalStrut(500)); 
        panel.add(resultLabel);

        add(panel);
        
        // Tamaño clásico de la ventana
        setSize(450, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio2_11Swing().setVisible(true);
        });
    }
}