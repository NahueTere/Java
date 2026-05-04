import javax.swing.*;
import java.awt.*;

public class Ejercicio_2_1 extends JFrame {

    public Ejercicio_2_1() {
        setTitle("Ejercicio 2.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JTextField txtN = new JTextField(10);
        JButton btn = new JButton("Verificar");
        JLabel res = new JLabel("Resultado: ");

        btn.addActionListener(e -> {
            try {
                int n = Integer.parseInt(txtN.getText().trim());
                
                if (n % 2 == 0) {
                    res.setText("El número " + n + " es PAR");
            
                } else {
                    res.setText("El número " + n + " es IMPAR");
        
                }
            } catch (NumberFormatException ex) {
                res.setText("Error: Ingrese un entero");
                res.setForeground(Color.BLACK);
            }
        });

        JPanel p = new JPanel(new GridLayout(4, 1, 10, 10));
        p.add(new JLabel("Número:"));
        p.add(txtN);
        p.add(btn);
        p.add(res);

        add(p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio_2_1().setVisible(true));
    }
}