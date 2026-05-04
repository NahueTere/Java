import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VerificadorParidad extends JFrame {
    private JTextField campoNumero;
    private JLabel etiquetaResultado;
    private JButton botonVerificar;

    public VerificadorParidad() {
        // 1. Configuración de la ventana (JFrame)
        setTitle("Detector de Pares e Impares");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); // Distribución simple

        // 2. Creación de componentes
        add(new JLabel("Introduce un número:"));
        campoNumero = new JTextField(10);
        botonVerificar = new JButton("¿Es par?");
        etiquetaResultado = new JLabel("Resultado: ---");

        // 3. Añadir componentes al panel de contenido
        add(campoNumero);
        add(botonVerificar);
        add(etiquetaResultado);

        // 4. Manejo de Eventos (Lógica)
        botonVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarNumero();
            }
        });
    }

    private void verificarNumero() {
        try {
            int num = Integer.parseInt(campoNumero.getText());
            if (num % 2 == 0) {
                etiquetaResultado.setText("Resultado: Es PAR");
            } else {
                etiquetaResultado.setText("Resultado: Es IMPAR");
            }
        } catch (NumberFormatException ex) {
            etiquetaResultado.setText("Error: Ingresa un número válido");
        }
    }

    public static void main(String[] args) {
        // Ejecución segura en el Event Dispatch Thread[cite: 1]
        SwingUtilities.invokeLater(() -> {
            new VerificadorParidad().setVisible(true);
        });
    }
}