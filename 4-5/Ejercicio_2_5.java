import javax.swing.*;
import java.awt.*;

public class Ejercicio_2_5 extends JFrame {

    public Ejercicio_2_5() {
        setTitle("Ejercicio 2.5 - Casi-Cero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JTextField txtN = new JTextField(10);
        JButton btn = new JButton("¿Es casi-cero?");
        JLabel res = new JLabel("Resultado: ");

        btn.addActionListener(e -> {
            try {
   
                double n = Double.parseDouble(txtN.getText().trim());


                if (n > -1 && n < 1 && n != 0) {
                    res.setText(n + " es un número CASI-CERO");
                    res.setForeground(new Color(0, 150, 0));
                } else {
                    res.setText(n + " NO es casi-cero");
                    res.setForeground(Color.RED);
                }
            } catch (Exception ex) {
                res.setText("Error: Ingrese un decimal");
            }
        });

        JPanel p = new JPanel(new GridLayout(4, 1, 10, 10));
        p.add(new JLabel("Ingrese un número decimal:"));
        p.add(txtN);
        p.add(btn);
        p.add(res);

        add(p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio_2_5().setVisible(true));
    }
}