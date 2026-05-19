import javax.swing.*;
import java.awt.*;

public class Ejercicio2_15Swing extends JFrame {

    public Ejercicio2_15Swing() {
        setTitle("Ejercicio 2.15 - Día de la Semana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputDia = new JTextField(5);
        JButton btnVerificar = new JButton("Ver nombre");
        JLabel resultLabel = new JLabel("Resultado: esperando número...");

        btnVerificar.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(inputDia.getText().trim());
                String nombreDia;

                switch (numero) {
                    case 1: nombreDia = "Lunes"; break;
                    case 2: nombreDia = "Martes"; break;
                    case 3: nombreDia = "Miércoles"; break;
                    case 4: nombreDia = "Jueves"; break;
                    case 5: nombreDia = "Viernes"; break;
                    case 6: nombreDia = "Sábado"; break;
                    case 7: nombreDia = "Domingo"; break;
                    default: nombreDia = "Número inválido (debe ser de 1 a 7)"; break;
                }

                resultLabel.setText("Resultado: " + nombreDia);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Ingrese un número entero.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número (1-7):"));
        panel.add(inputDia);
        panel.add(btnVerificar);

        panel.add(Box.createHorizontalStrut(500));
        panel.add(resultLabel);

        add(panel);
        setSize(450, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio2_15Swing().setVisible(true);
        });
    }
}