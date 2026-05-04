import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio2_1 extends JFrame {
    private JTextField txtNumero;
    private JLabel lblResultado;
    private JButton btnCalcular;

    public Ejercicio2_1() {
        setTitle("Verificador Par/Impar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        txtNumero = new JTextField(10);
        btnCalcular = new JButton("Verificar");
        lblResultado = new JLabel("Ingrese un número");

        add(new JLabel("Número:"));
        add(txtNumero);
        add(btnCalcular);
        add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(txtNumero.getText());
                    if (numero % 2 == 0) {
                        lblResultado.setText("Resultado: Es PAR");
                    } else {
                        lblResultado.setText("Resultado: Es IMPAR");
                    }
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Error: Ingrese solo números");
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ejercicio2_1().setVisible(true);
        });
    }
}