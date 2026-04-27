import javax.swing.*;
import java.awt.*;

public class Ejercicio_G extends JFrame {

    public Ejercicio_G() {
        setTitle("Ejercicio G");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField txtN = new JTextField(10);
        JButton btn = new JButton("Procesar");
        JTextArea res = new JTextArea();

        btn.addActionListener(e -> {
            try {
                int n = Integer.parseInt(txtN.getText().trim());
                if (n > 9999 && n < 100000) {
                    res.setText((n/10000) + "\n" + (n/1000) + "\n" + 
                                (n/100) + "\n" + (n/10) + "\n" + n);
                } else {
                    res.setText("Número inválido");
                }
            } catch (Exception ex) {
                res.setText("Error");
            }
        });

        setLayout(new BorderLayout());
        JPanel pInput = new JPanel();
        pInput.add(new JLabel("N:")); pInput.add(txtN);
        
        add(pInput, BorderLayout.NORTH);
        add(new JScrollPane(res), BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        setSize(250, 250);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio_G().setVisible(true));
    }
}