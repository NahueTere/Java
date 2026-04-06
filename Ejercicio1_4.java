import javax.swing.*;


public class Ejercicio1_4 extends JFrame {

    public Ejercicio1_4() {
        setTitle("Ejercicio 1.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton btnCalcular = new JButton("Comprobar Rango");
        JLabel lblResultado = new JLabel("Ingrese un valor (ej: 32767)");

        btnCalcular.addActionListener(e -> {
            try {
                short valorActual = (short) Integer.parseInt(inputField.getText().trim());
                short suma = (short) (valorActual + 1);
                short resta = (short) (valorActual - 1);

                lblResultado.setText("<html>Valor Short: " + valorActual + 
                                   "<br>Siguiente (+1): " + suma + 
                                   "<br>Anterior (-1): " + resta + "</html>");
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Ingrese un número válido.");
            }
        });

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.add(new JLabel("Número:"));
        panelPrincipal.add(inputField);
        panelPrincipal.add(btnCalcular);
        panelPrincipal.add(lblResultado);

        add(panelPrincipal);
        setSize(450, 180);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio1_4().setVisible(true);
        });
    }
}