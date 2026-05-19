import javax.swing.*;
import java.awt.*;

public class Ejercicio2_14Swing extends JFrame {

    public Ejercicio2_14Swing() {
        setTitle("Ejercicio 2.14 - Día Siguiente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputDia = new JTextField(3);
        JTextField inputMes = new JTextField(3);
        JTextField inputAnio = new JTextField(4);
        JButton btnCalcular = new JButton("Siguiente Día");
        JLabel resultLabel = new JLabel("Resultado: esperando fecha...");

        btnCalcular.addActionListener(e -> {
            try {
                int dia = Integer.parseInt(inputDia.getText().trim());
                int mes = Integer.parseInt(inputMes.getText().trim());
                int anio = Integer.parseInt(inputAnio.getText().trim());

                if (anio > 0 && mes >= 1 && mes <= 12) {
                    int diasDelMes = 0;
                    switch (mes) {
                        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                            diasDelMes = 31;
                            break;
                        case 4: case 6: case 9: case 11:
                            diasDelMes = 30;
                            break;
                        case 2:
                            diasDelMes = 28;
                            break;
                    }

                    if (dia >= 1 && dia <= diasDelMes) {
                        dia++;
                        if (dia > diasDelMes) {
                            dia = 1;
                            mes++;
                            if (mes > 12) {
                                mes = 1;
                                anio++;
                            }
                        }
                        resultLabel.setText(String.format("Día Siguiente: %02d/%02d/%04d", dia, mes, anio));
                    } else {
                        resultLabel.setText("Error: Día incorrecto para ese mes.");
                    }
                } else {
                    resultLabel.setText("Error: Mes o año inválido.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Ingrese números enteros.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Día:")); panel.add(inputDia);
        panel.add(new JLabel("Mes:")); panel.add(inputMes);
        panel.add(new JLabel("Año:")); panel.add(inputAnio);
        panel.add(btnCalcular);

        panel.add(Box.createHorizontalStrut(500));
        panel.add(resultLabel);

        add(panel);
        setSize(450, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio2_14Swing().setVisible(true);
        });
    }
}