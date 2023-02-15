
package edd.lineales;

import java.text.DecimalFormat;

import edd.colors.Colors;

public class Matrix {

    public static int[] dimension(double[][] a) {
        int filas = a.length;
        int columnas = a[0].length;
        int[] arr = { filas, columnas };
        return arr;
    }

    public static double productoVectoresMatriciales(int i, int j, double[][] a, double[][] b) {
        double acum = 0.0;
        int n = a[0].length;
        for (int k = 0; k < n; k++) { /////
            acum += a[i][k] * b[k][j];
        }
        return acum;
    }

    public static double[][] crossProduct(double[][] a, double[][] b) {
        // Notemos que para que esta funcion este bien definida debera cumplir que si
        // dim(a) = (n,m)
        // dim(b) = (o,p)
        // entonces, para que a*b este bien definido debera suceder que m sea
        // necesariamente igual a o
        int[] dimA = dimension(a);
        int[] dimB = dimension(b);
        if ((dimA[1] != dimB[0])) {
            throw new UnsupportedOperationException(
                    "No podemos multiplicar las matrices pues la segunda dimension de la primera matriz es distinta a la primera dimension de la segunda matriz.");
        }
        double[][] multiplicacion = new double[dimA[0]][dimB[1]];
        // Validado lo anterior, se sabe que:
        // (a*b)ij = Suma_{k = 0}^{m=o=n}[(a)in*(b)nj]
        for (int i = 0; i < dimA[0]; i++) {
            for (int j = 0; j < dimB[1]; j++) {
                multiplicacion[i][j] = productoVectoresMatriciales(i, j, a, b);
            }
        }
        return multiplicacion;
    }

    public static double[][] scalarProduct(double[][] a, double b) {
        int[] dimA = dimension(a);
        double[][] prod = new double[dimA[0]][dimA[1]];
        for (int i = 0; i < dimA[0]; i++) {
            for (int j = 0; j < dimA[1]; j++) {
                prod[i][j] = b * a[i][j];
            }
        }
        return prod;
    }

    public static double[][] sum(double[][] a, double[][] b) {
        int[] dimA = dimension(a);
        int[] dimB = dimension(b);
        if ((dimA[0] != dimB[0]) || (dimA[1] != dimB[1])) {
            throw new UnsupportedOperationException(
                    "No podemos sumar las matrices pues la dimensiones de cada una de ellas son dimensiones distintas.");
        }
        double[][] suma = new double[dimA[0]][dimB[1]];
        // Validado lo anterior, se sabe que:
        // (a*b)ij = Suma_{k = 0}^{m=o=n}[(a)in*(b)nj]
        for (int i = 0; i < dimA[0]; i++) {
            for (int j = 0; j < dimB[1]; j++) {
                suma[i][j] = a[i][j] + b[i][j];
            }
        }
        return suma;
    }

    public static void printArray(double[][] matrix) {
        DecimalFormat pattern = new DecimalFormat("0.0##");

        for (int i = 0; i < matrix.length; i++) {
            Colors.print("|", Colors.HIGH_INTENSITY);
            for (int j = 0; j < matrix[0].length; j++) {
                if (isAlmostZero(matrix[i][j])) {
                    matrix[i][j] = 0.0;
                    Colors.print(pattern.format(matrix[i][j]), Colors.HIGH_INTENSITY);
                } else {
                    Colors.print(pattern.format(matrix[i][j]), Colors.CYAN + Colors.HIGH_INTENSITY);
                }
                if (j < matrix[0].length - 1) {
                    Colors.print(", ", Colors.HIGH_INTENSITY);
                }
            }
            Colors.print("|", Colors.HIGH_INTENSITY);
            System.out.println();
        }
    }

    public static boolean isAlmostZero(double d) {
        return -0.01 < d && d < 0.01;
    }
}
