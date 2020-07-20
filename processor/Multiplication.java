package processor;

import java.util.Scanner;
// умножение матриц

public class Multiplication {
    public static void multiplication() {
        // считываем два числа создаем матрицу
//        и еще раз то же действие
        System.out.print("Enter size of first matrix: ");
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        ExampleOfMatrix firstMatrix = new ExampleOfMatrix(r, c);
        System.out.println("Enter first matrix:");
        firstMatrix.enterMatrix();
        System.out.print("Enter size of second matrix: ");
        r = scanner.nextInt();
        c = scanner.nextInt();
        ExampleOfMatrix secondMatrix = new ExampleOfMatrix(r, c);
        System.out.println("Enter second matrix:");
        secondMatrix.enterMatrix();
        if (firstMatrix.getColumns() != secondMatrix.getRows()) {
//            если размеры не совпадают
            System.out.println("ERROR");
        } else {
            ExampleOfMatrix resultMatrix = new ExampleOfMatrix(firstMatrix.getRows(),
                    secondMatrix.getColumns());

            for (int i = 0; i < resultMatrix.getRows(); i++) {
                double[] bufferRows;
                bufferRows = firstMatrix.getRowsInArrayView(i);
                for (int j = 0; j < resultMatrix.getColumns(); j++) {
                    double[] bufferColumns;
                    bufferColumns = secondMatrix.getColumnsInArrayView(j);
                    resultMatrix.setElement(i, j, getProcessOfTwoArrays(bufferColumns, bufferRows));
                }
            }
            System.out.println("The multiplication result is:");
            resultMatrix.printMatrix();
        }
    }

    public static double getProcessOfTwoArrays(double[] first, double[] second) {
        double value = 0;
        for (int i = 0; i < first.length; i++) {
            value += (first[i] * second[i]);
        }
        return value;
    }
}
