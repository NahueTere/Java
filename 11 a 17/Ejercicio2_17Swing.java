import javax.swing.*;
import java.awt.*;

public class Ejercicio2_17Swing extends JFrame {

    public Ejercicio2_17Swing() {
        setTitle("Ejercicio 2.17 - Control de Alimento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputComida = new JTextField(5);
        JTextField inputAnimales = new JTextField(5);
        JTextField inputKilos = new JTextField(5);
        JButton btnCalcular = new JButton("Calcular");
        JLabel resultLabel = new JLabel("Resultado: esperando datos...");

        btnCalcular.addActionListener(e -> {
            try {
                double comidaDiaria = Double.parseDouble(inputComida.getText().trim());
                int numAnimales = Integer.parseInt(inputAnimales.getText().trim());
                double kilosPorAnimal = Double.parseDouble(inputKilos.getText().trim());

                if (numAnimales == 0) {
                    resultLabel.setText("Error: El número de animales no puede ser cero.");
                    return;
                }

                if (numAnimales < 0 || comidaDiaria < 0 || kilosPorAnimal < 0) {
                    resultLabel.setText("Error: Los valores no pueden ser negativos.");
                    return;
                }

                double comidaNecesaria = numAnimales * kilosPorAnimal;

                if (comidaDiaria >= comidaNecesaria) {
                    resultLabel.setText("Resultado: Alimento suficiente para todos los animales.");
                } else {
                    double racionReal = comidaDiaria / numAnimales;
                    resultLabel.setText(String.format("Resultado: Alimento INSUFICIENTE. Ración asignada: %.2f kg por animal.", racionReal));
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Ingrese números válidos.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Comida Total (kg):")); panel.add(inputComida);
        panel.add(new JLabel("Cant. Animales:")); panel.add(inputAnimales);
        panel.add(new JLabel("Kg por Animal:")); panel.add(inputKilos);
        panel.add(btnCalcular);

        panel.add(Box.createHorizontalStrut(500));
        panel.add(resultLabel);

        add(panel);
        setSize(550, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio2_17Swing().setVisible(true);
        });
    }
}