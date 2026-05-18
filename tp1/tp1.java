import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class tp1 extends JFrame {

    public tp1() {
        setTitle("Trabajo Práctico 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cajas de texto para ingresar los datos
        JTextField input1 = new JTextField(5);
        JTextField input2 = new JTextField(5);
        JTextField input3 = new JTextField(5);
        JTextField input4 = new JTextField(5);

        // Botones para ejecutar cada uno de los ejercicios
        JButton btn1 = new JButton("Ej 1: Redondear");
        JButton btn2 = new JButton("Ej 2: Ventas Fijas");
        JButton btn3 = new JButton("Ej 3: Ventas Var");
        JButton btn4 = new JButton("Ej 4: Círculo");
        JButton btn5 = new JButton("Ej 5: Celsius");
        JButton btn6 = new JButton("Ej 6: Velocidad");
        JButton btn7 = new JButton("Ej 7: Hipotenusa");
        JButton btn8 = new JButton("Ej 8: Herón");
        JButton btn9 = new JButton("Ej 9: Descomponer");
        JButton btn10 = new JButton("Ej 10: Suerte");

        // Etiqueta para mostrar la salida del cálculo
        JLabel resultLabel = new JLabel("Resultado: esperando operación...");

        // 1. Redondeo de número decimal
        btn1.addActionListener(e -> {
            try {
                double num = Double.parseDouble(input1.getText().trim());
                long redondeado = Math.round(num); // Redondea al entero más cercano
                resultLabel.setText("Resultado Redondeo: " + redondeado);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Ingrese un decimal en la caja 1.");
            }
        });

        // 2. Cálculo de ventas con precios fijos
        btn2.addActionListener(e -> {
            try {
                double precioManzana = 2.5; 
                double precioPera = 3.0;
                double m1 = Double.parseDouble(input1.getText().trim());
                double m2 = Double.parseDouble(input2.getText().trim());
                double p1 = Double.parseDouble(input3.getText().trim());
                double p2 = Double.parseDouble(input4.getText().trim());

                // Suma de cantidades y cálculo del importe total
                double total = (m1 + m2) * precioManzana + (p1 + p2) * precioPera;
                resultLabel.setText("Total Ventas Fijas: $" + String.format("%.2f", total));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Llene las 4 cajas con números válidos.");
            }
        });

        // 3. Cálculo de ventas con precios variables
        btn3.addActionListener(e -> {
            try {
                // Lectura de precios y cantidades ingresados por el usuario
                double pManzana = Double.parseDouble(input1.getText().trim());
                double kManzana = Double.parseDouble(input2.getText().trim());
                double pPera = Double.parseDouble(input3.getText().trim());
                double kPera = Double.parseDouble(input4.getText().trim());

                double total = (pManzana * kManzana) + (pPera * kPera);
                resultLabel.setText("Total Ventas Variables: $" + String.format("%.2f", total));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Llene las 4 cajas con valores válidos.");
            }
        });

        // 4. Longitud y Área de una circunferencia
        btn4.addActionListener(e -> {
            try {
                double radio = Double.parseDouble(input1.getText().trim());
                
                // Fórmulas estándar utilizando la constante matemática PI
                double longitud = 2 * Math.PI * radio;
                double area = Math.PI * Math.pow(radio, 2); // Eleva el radio al cuadrado
                
                resultLabel.setText("Longitud: " + String.format("%.2f", longitud) + " | Área: " + String.format("%.2f", area));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Ingrese el radio en la caja 1.");
            }
        });

        // 5. Conversión de Celsius a Fahrenheit
        btn5.addActionListener(e -> {
            try {
                double celsius = Double.parseDouble(input1.getText().trim());
                double fahrenheit = (celsius * 9 / 5) + 32; // Ecuación directa de conversión
                resultLabel.setText(celsius + " °C = " + fahrenheit + " °F");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Ingrese los grados en la caja 1.");
            }
        });

        // 6. Conversión de Km/h a metros por segundo
        btn6.addActionListener(e -> {
            try {
                double kmh = Double.parseDouble(input1.getText().trim());
                double ms = kmh / 3.6; // Factor de conversión directo
                resultLabel.setText(kmh + " Km/h = " + String.format("%.2f", ms) + " m/s");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Ingrese la velocidad en la caja 1.");
            }
        });

        // 7. Cálculo de la hipotenusa
        btn7.addActionListener(e -> {
            try {
                double c1 = Double.parseDouble(input1.getText().trim());
                double c2 = Double.parseDouble(input2.getText().trim());
                
                // Calculates la raíz cuadrada de la suma de los catetos al cuadrado
                double hipotenusa = Math.hypot(c1, c2); 
                resultLabel.setText("La hipotenusa es: " + String.format("%.2f", hipotenusa));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Ingrese catetos en cajas 1 y 2.");
            }
        });

        // 8. Área de un triángulo mediante la Fórmula de Herón
        btn8.addActionListener(e -> {
            try {
                double a = Double.parseDouble(input1.getText().trim());
                double b = Double.parseDouble(input2.getText().trim());
                double c = Double.parseDouble(input3.getText().trim());
                
                double s = (a + b + c) / 2; // Cálculo del semiperímetro
                double area = Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Raíz cuadrada del producto
                
                resultLabel.setText("Área (Herón): " + String.format("%.2f", area));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Llene cajas 1, 2 y 3 con lados válidos.");
            }
        });

        // 9. Descomposición de un número de 3 cifras
        btn9.addActionListener(e -> {
            try {
                int num = Integer.parseInt(input1.getText().trim());
                
                // Extracción posicional mediante operadores de división y residuo
                int primera = num / 100;         
                int central = (num / 10) % 10;   
                int ultima = num % 10;           
                
                resultLabel.setText("Primera: " + primera + " | Central: " + central + " | Última: " + ultima);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Ingrese número de 3 cifras en la caja 1.");
            }
        });

        // 10. Número de la suerte mediante fecha de nacimiento
        btn10.addActionListener(e -> {
            try {
                int fecha = Integer.parseInt(input1.getText().trim());
                
                // Extracción sucesiva de cada dígito de forma lineal desde las unidades
                int d8 = fecha % 10; fecha /= 10;
                int d7 = fecha % 10; fecha /= 10;
                int d6 = fecha % 10; fecha /= 10;
                int d5 = fecha % 10; fecha /= 10;
                int d4 = fecha % 10; fecha /= 10;
                int d3 = fecha % 10; fecha /= 10;
                int d2 = fecha % 10; fecha /= 10;
                int d1 = fecha; 

                // Suma total de los dígitos
                int sumaTotal = d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8;
                
                // Simplificación del resultado a un solo dígito
                int suerte = (sumaTotal % 10) + (sumaTotal / 10);
                
                resultLabel.setText("Tu Número de la Suerte es: " + suerte);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Ingrese formato DDMMAAAA en la caja 1.");
            }
        });

        // --- ARMADO DEL PANEL ---
        JPanel panel = new JPanel();
        
        panel.add(new JLabel("Caja 1:")); panel.add(input1);
        panel.add(new JLabel("Caja 2:")); panel.add(input2);
        panel.add(new JLabel("Caja 3:")); panel.add(input3);
        panel.add(new JLabel("Caja 4:")); panel.add(input4);
        
        // Separador para ordenar los componentes en la interfaz
        panel.add(Box.createHorizontalStrut(500)); 

        panel.add(btn1); panel.add(btn2); panel.add(btn3); panel.add(btn4); panel.add(btn5);
        panel.add(btn6); panel.add(btn7); panel.add(btn8); panel.add(btn9); panel.add(btn10);

        panel.add(Box.createHorizontalStrut(500)); 
        panel.add(resultLabel);

        add(panel);
        
        setSize(700, 200);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new tp1().setVisible(true);
        });
    }
}