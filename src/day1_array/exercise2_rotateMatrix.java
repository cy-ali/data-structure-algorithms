package day1_array;

import java.util.Arrays;

public class exercise2_rotateMatrix {
    //            Assignments
//            1. Reverse order of an array of unordered integers.  (Easy-Warm up.)
//            2. Rotate an (n x n) matrix  90 degrees right in place. (Medium Level)

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12},
                          {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24},
                          {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}};

        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(rotate90(matrix)));

        printMatrix(matrix);

        System.out.println("******ROTATION*******");
        printMatrix(rotate90(matrix));

        System.out.println("******ROTATION*******");
        printMatrix(alternativeRotate90(matrix));
    }

    public static int[][] rotate90(int[][] matrix) {
        int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                rotatedMatrix[j][matrix.length - (i + 1)] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    public static int[][] alternativeRotate90(int[][] matrix) {
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length - (i + 1); j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - (j + 1)][i];
                matrix[matrix.length - (j + 1)][i] = matrix[matrix.length - (i + 1)][matrix.length - (j + 1)];
                matrix[matrix.length - (i + 1)][matrix.length - (j + 1)] = matrix[j][matrix.length - (i + 1)];
                matrix[j][matrix.length - (i + 1)] = temp;
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
