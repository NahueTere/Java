import javax.swing.*;
import java.awt.*;

public class Ejercicio_H extends JFrame {

    public Ejercicio_H() {
        setTitle("Ejercicio_H");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField tD = new JTextField(2), tM = new JTextField(2), tA = new JTextField(4);
        JButton btn = new JButton("Calcular");
        JLabel res = new JLabel("Número de la suerte: ");

        btn.addActionListener(e -> {
            try {
                int s = Integer.parseInt(tD.getText()) + Integer.parseInt(tM.getText()) + Integer.parseInt(tA.getText());
                int suerte = (s/1000) + (s/100%10) + (s/10%10) + (s%10);
                res.setText("Suma " + s + " | Suerte: " + suerte);
            } catch (Exception ex) {
                res.setText("Error en datos");
            }
        });

        JPanel p = new JPanel(new GridLayout(4, 1));
        JPanel inputs = new JPanel();
        inputs.add(new JLabel("F. Nac (D/M/A):")); inputs.add(tD); inputs.add(tM); inputs.add(tA);
        p.add(inputs); p.add(btn); p.add(res);

        add(p);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejercicio_H().setVisible(true));
    }
}