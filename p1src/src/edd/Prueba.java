
package edd;

import edd.lineales.Matrix;
import edd.colors.Colors;

public class Prueba {

    public static double[][] ej1() {
        double matrix[][] = new double[3][];

        matrix[0] = new double[]{0.0, 3.0, 2.0, 2.0, 4.0};
        matrix[1] = new double[]{3.0, 0.0, 2.0, 3.0, 4.0};
        matrix[2] = new double[]{2.0, 3.0, 1.0, 2.0, 3.0};

        return matrix;
    }

    public static double[][] ej2() {
        double matrix[][] = new double[5][];

        matrix[0] = new double[]{1.0, 1.0, 0.0, 8.0};
        matrix[1] = new double[]{2.0, 2.0, 1.0, 3.0};
        matrix[2] = new double[]{1.0, 2.0, 1.0, 8.0};
        matrix[3] = new double[]{3.0, 3.0, 2.0, 1.0};
        matrix[4] = new double[]{4.0, 6.0, 7.0, 0.0};

        return matrix;
    }

    public static void main(String args[]) {
        // Suma
        System.out.println();
        Colors.println("Suma:",Colors.RED + Colors.HIGH_INTENSITY);
        Matrix.printArray(ej1());
        System.out.println();
        Matrix.printArray(ej1());
        System.out.println();
        Matrix.printArray(Matrix.sum(ej1(), ej1()));

        // Producto escalar
        System.out.println();
        Colors.println("Producto escalar:",Colors.RED + Colors.HIGH_INTENSITY);
        Matrix.printArray(ej1());
        System.out.println();
        System.out.println(5 + "\n");
        Matrix.printArray(Matrix.scalarProduct(ej1(), 5));

        // Producto cruz
        System.out.println();
        Colors.println("Producto cruz:",Colors.RED + Colors.HIGH_INTENSITY);
        Matrix.printArray(ej1());
        System.out.println();
        Matrix.printArray(ej2());
        System.out.println();
        Matrix.printArray(Matrix.crossProduct(ej1(), ej2()));
    }
}
