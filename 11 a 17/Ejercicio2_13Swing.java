import javax.swing.*;
import java.awt.*;

public class Ejercicio2_13Swing extends JFrame {

    public Ejercicio2_13Swing() {
        setTitle("Ejercicio 2.13 - Hora +1 Segundo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputH = new JTextField(3);
        JTextField inputM = new JTextField(3);
        JTextField inputS = new JTextField(3);
        JButton btnCalcular = new JButton("Calcular");
        JLabel resultLabel = new JLabel("Resultado: esperando hora...");

        btnCalcular.addActionListener(e -> {
            try {
                int h = Integer.parseInt(inputH.getText().trim());
                int m = Integer.parseInt(inputM.getText().trim());
                int s = Integer.parseInt(inputS.getText().trim());

                if (h >= 0 && h < 24 && m >= 0 && m < 60 && s >= 0 && s < 60) {
                    s++;
                    if (s == 60) {
                        s = 0;
                        m++;
                        if (m == 60) {
                            m = 0;
                            h++;
                            if (h == 24) {
                                h = 0;
                            }
                        }
                    }
                    resultLabel.setText(String.format("Hora +1s: [%02d:%02d:%02d]", h, m, s));
                } else {
                    resultLabel.setText("Error: Formato de hora inválido.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Ingrese números enteros.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("H:")); panel.add(inputH);
        panel.add(new JLabel("M:")); panel.add(inputM);
        panel.add(new JLabel("S:")); panel.add(inputS);
        panel.add(btnCalcular);

        panel.add(Box.createHorizontalStrut(500));
        panel.add(resultLabel);

        add(panel);
        setSize(450, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio2_13Swing().setVisible(true);
        });
    }
}