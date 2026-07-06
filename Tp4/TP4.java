package Tp4;

import javax.swing.*;
import java.awt.*;

public class TP4 extends JFrame {

    public TP4() {

        setTitle("TP4 - Funciones y Métodos");
        setSize(600, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(11, 1));

        JButton b41 = new JButton("Eco (repetir texto)");
        JButton b42 = new JButton("Números entre dos valores");
        JButton b43 = new JButton("Cilindro (área y volumen)");
        JButton b44 = new JButton("Mayor de dos números");
        JButton b45 = new JButton("Mayor de tres números");
        JButton b46 = new JButton("Es vocal");
        JButton b47 = new JButton("Número primo");
        JButton b48 = new JButton("Divisores primos (cantidad)");
        JButton b49 = new JButton("Divisores primos (listar)");
        JButton b410 = new JButton("Números amigos");
        JButton b411 = new JButton("Potencia");

        add(b41); add(b42); add(b43); add(b44); add(b45);
        add(b46); add(b47); add(b48); add(b49); add(b410);
        add(b411);

        b41.addActionListener(e -> ejercicio41());
        b42.addActionListener(e -> ejercicio42());
        b43.addActionListener(e -> ejercicio43());
        b44.addActionListener(e -> ejercicio44());
        b45.addActionListener(e -> ejercicio45());
        b46.addActionListener(e -> ejercicio46());
        b47.addActionListener(e -> ejercicio47());
        b48.addActionListener(e -> ejercicio48());
        b49.addActionListener(e -> ejercicio49());
        b410.addActionListener(e -> ejercicio410());
        b411.addActionListener(e -> ejercicio411());
    }

    public static void main(String[] args) {
        new TP4().setVisible(true);
    }

    // =========================
    // 4.1 ECO
    void ejercicio41() {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Número"));

        String r = "";
        for (int i = 0; i < n; i++) r += "Eco...\n";

        JOptionPane.showMessageDialog(null, r);
    }

    // =========================
    // 4.2 intervalos
    void ejercicio42() {
        int a = Integer.parseInt(JOptionPane.showInputDialog("Número 1"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("Número 2"));

        String r = "";

        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            r += i + "\n";
        }

        JOptionPane.showMessageDialog(null, r);
    }

    // =========================
    // 4.3 cilindro
    void ejercicio43() {
        double r = Double.parseDouble(JOptionPane.showInputDialog("Radio"));
        double h = Double.parseDouble(JOptionPane.showInputDialog("Altura"));

        double area = 2 * Math.PI * r * (r + h);
        double volumen = Math.PI * r * r * h;

        JOptionPane.showMessageDialog(null,
                "Área: " + area + "\nVolumen: " + volumen);
    }

    // =========================
    void ejercicio44() {
        int a = Integer.parseInt(JOptionPane.showInputDialog("A"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("B"));

        JOptionPane.showMessageDialog(null,
                "Mayor: " + Math.max(a, b));
    }

    // =========================
    void ejercicio45() {
        int a = Integer.parseInt(JOptionPane.showInputDialog("A"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("B"));
        int c = Integer.parseInt(JOptionPane.showInputDialog("C"));

        JOptionPane.showMessageDialog(null,
                "Mayor: " + Math.max(a, Math.max(b, c)));
    }

    // =========================
    void ejercicio46() {
        char c = JOptionPane.showInputDialog("Letra").charAt(0);

        boolean vocal =
                c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';

        JOptionPane.showMessageDialog(null,
                vocal ? "Es vocal" : "No es vocal");
    }

    // =========================
    void ejercicio47() {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Número"));

        JOptionPane.showMessageDialog(null,
                esPrimo(n) ? "Es primo" : "No es primo");
    }

    boolean esPrimo(int n) {
        if (n < 2) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // =========================
    void ejercicio48() {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Número"));

        JOptionPane.showMessageDialog(null,
                "Cantidad divisores primos: " + contarDivPrimos(n));
    }

    int contarDivPrimos(int n) {
        int c = 0;

        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && esPrimo(i)) c++;
        }

        return c;
    }

    // =========================
    void ejercicio49() {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Número"));

        String r = "";

        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && esPrimo(i)) r += i + "\n";
        }

        JOptionPane.showMessageDialog(null, r);
    }

    // =========================
    void ejercicio410() {
        int a = Integer.parseInt(JOptionPane.showInputDialog("A"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("B"));

        JOptionPane.showMessageDialog(null,
                sonAmigos(a, b) ? "Son amigos" : "No son amigos");
    }

    boolean sonAmigos(int a, int b) {
        return sumaDiv(a) == b && sumaDiv(b) == a;
    }

    int sumaDiv(int n) {
        int s = 0;

        for (int i = 1; i < n; i++) {
            if (n % i == 0) s += i;
        }

        return s;
    }

    // =========================
    void ejercicio411() {
        double base = Double.parseDouble(JOptionPane.showInputDialog("Base"));
        int exp = Integer.parseInt(JOptionPane.showInputDialog("Exponente"));

        double res = Math.pow(base, exp);

        JOptionPane.showMessageDialog(null, "Resultado: " + res);
    }
}