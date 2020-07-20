package processor;

import java.util.Scanner;
// it's class for working with matrix
public class ExampleOfMatrix {
    Scanner scanner = new Scanner(System.in);
    private int columns;
    private int rows;
    double[][] matrix;

    ExampleOfMatrix(int rows, int columns) {
        this.columns = columns;
        this.rows = rows;
        matrix = new double[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setElement(int row, int column, double value) {
        matrix[row][column] = value;
    }

    public double[] getRowsInArrayView(int row) { // отдаю строку
        double[] gift = new double[columns];
//                одаю одномерный массив
        for (int i = 0; i < columns; i++) {
            gift[i] = matrix[row][i];
        }
        return gift;
    }
// here i get array from certain column
    public double[] getColumnsInArrayView(int column) {
        double[] anotherGift = new double[rows];
        for (int i = 0; i < rows; i++) {
            anotherGift[i] = matrix[i][column];
        }
        return anotherGift;
    }
// enter matrix
    public void enterMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%.4f%c", matrix[i][j], ' ');
            }
            System.out.println();
        }
    }

    public double getElement(int r, int c) {
        return matrix[r][c];
    }
}
