import javax.swing.*;
import java.awt.*;

public class Ejercicio2_16Swing extends JFrame {

    public Ejercicio2_16Swing() {
        setTitle("Ejercicio 2.16 - Número en Letras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputNum = new JTextField(5);
        JButton btnConvertir = new JButton("Convertir a Letras");
        JLabel resultLabel = new JLabel("Resultado: esperando número...");

        btnConvertir.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputNum.getText().trim());

                if (num < 1 || num > 99) {
                    resultLabel.setText("Error: El número debe estar entre 1 y 99.");
                    return;
                }

                String[] unidades = {"", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
                String[] especiales = {"diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"};
                String[] decenas = {"", "", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};

                String resultado = "";

                if (num >= 10 && num <= 19) {
                    resultado = especiales[num - 10];
                } else if (num >= 20 && num <= 29) {
                    if (num == 20) resultado = "veinte";
                    else resultado = "veinti" + unidades[num % 10];
                } else {
                    int dec = num / 10;
                    int uni = num % 10;

                    if (dec == 0) {
                        resultado = unidades[uni];
                    } else if (uni == 0) {
                        resultado = decenas[dec];
                    } else {
                        resultado = decenas[dec] + " y " + unidades[uni];
                    }
                }

                resultLabel.setText("Resultado: " + resultado);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Ingrese un número entero.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número (1-99):"));
        panel.add(inputNum);
        panel.add(btnConvertir);

        panel.add(Box.createHorizontalStrut(500));
        panel.add(resultLabel);

        add(panel);
        setSize(450, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio2_16Swing().setVisible(true);
        });
    }
}