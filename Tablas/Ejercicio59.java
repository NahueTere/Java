package Tablas;

import javax.swing.JOptionPane;

public class Ejercicio59 {

    public static void main(String[] args) {

        /*
        5.9. Notas de un grupo de 5 alumnos en 3 trimestres.
        Mostrar promedio por trimestre y promedio de un alumno en posición "pos".
        */

        int[][] notas = new int[5][3];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                notas[i][j] = Integer.parseInt(
                    JOptionPane.showInputDialog("Alumno " + i + " trimestre " + (j + 1))
                );
            }
        }

        double[] sumaTrimestres = new double[3];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                sumaTrimestres[j] += notas[i][j];
            }
        }

        String res = "Promedio por trimestre:\n";

        for (int j = 0; j < 3; j++) {
            res += "Trimestre " + (j + 1) + ": " + (sumaTrimestres[j] / 5) + "\n";
        }

        int pos = Integer.parseInt(
            JOptionPane.showInputDialog("Ingrese posición del alumno (0 a 4):")
        );

        double sumaAlumno = 0;

        for (int j = 0; j < 3; j++) {
            sumaAlumno += notas[pos][j];
        }

        res += "\nPromedio del alumno " + pos + ": " + (sumaAlumno / 3);

        JOptionPane.showMessageDialog(null, res);
    }
}