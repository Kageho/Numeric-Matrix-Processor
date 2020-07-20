package processor;

import java.util.Scanner;

public class Determined {
    static Scanner scanner = new Scanner(System.in);

    public static void findDetermined() {
        System.out.printf("%s", "Enter matrix size: ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        if (columns != rows) {
            System.out.println("Are you fool? Columns not equal rows");
        } else {
            System.out.printf("%s\n", "Enter Matrix: ");
            ExampleOfMatrix matrix = new ExampleOfMatrix(rows, columns);
            matrix.enterMatrix();
            System.out.printf("%s\n", "The result is:");
            if (rows == 2 && columns == 2) {
                // Если матрица 2 на 2 то все легко
                System.out.printf("%f\n", findMinor(matrix));
            } else {
                System.out.printf("%f\n", findDeterminant(matrix));
            }
        }
    }
// code below i use for get determinant by recursion algorithm
    public static double findDeterminant(ExampleOfMatrix matrix) {
        // if i get matrix 2 by 2
        double answer = 0;
        if (matrix.getColumns() == 2 || matrix.getRows() == 2) {
            return findMinor(matrix);
        } else if (matrix.getColumns() < 1) {
            System.out.println("Определитель невозможно посчиатать");
        } else if (matrix.getColumns() == 1) {
            return matrix.getElement(0, 0);
        } else { // if i get matrix more than 2 by 2

            for (int i = 0; i < matrix.getColumns(); i++) {
                double minor = matrix.getElement(0, i);
                if (i % 2 == 1) {
                    minor *= -1;
                }
               /* System.out.println(minor);*/
                ExampleOfMatrix subMatrix = makeSubMatrix(matrix, 0, i);

                answer += minor * findDeterminant(subMatrix);
                //return answer;
            }
        }
        return answer;
    }

    // применяю метод только для матриц 2 на 2
    private static double findMinor(ExampleOfMatrix matrix) {
        return matrix.getElement(0, 0) * matrix.getElement(1, 1) -
                (matrix.getElement(1, 0) * matrix.getElement(0, 1));
    }
// here i get sub Matrix
    public static ExampleOfMatrix makeSubMatrix(ExampleOfMatrix matrix,
                                                 int notInclusiveRow, int notInclusiveColumn) {
        ExampleOfMatrix resultMatrix = new ExampleOfMatrix(matrix.getRows() - 1,
                matrix.getColumns() - 1);
        double[] bufferMatrix = new double[(matrix.getColumns() - 1)
                * (matrix.getColumns() - 1)];
        int index = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                if (!(i == notInclusiveRow || j == notInclusiveColumn)) {
                    bufferMatrix[index++] = matrix.getElement(i, j); // создаем подматрицу
                }
//                I mean here i create subMatrix
            }
        }

        index = 0;
        for (int i = 0; i < resultMatrix.getRows(); i++) {
            for (int j = 0; j < resultMatrix.getColumns(); j++) {
                resultMatrix.setElement(i, j, bufferMatrix[index++]);
            }
        }
        /*resultMatrix.printMatrix();
        System.out.println();*/
        return resultMatrix;
    }

}
