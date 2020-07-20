package processor;

import java.util.Scanner;

public class AddMatrix {
    public static void addMatrix() {
        System.out.print("Enter size of first matrix: ");
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println("Enter first matrix");
        ExampleOfMatrix firstMatrix = new ExampleOfMatrix(r, c);
        firstMatrix.enterMatrix();
        // считывание второй матрицы
        System.out.print("Enter size of second matrix: ");
        r = scanner.nextInt();
        c = scanner.nextInt();
        System.out.println("Enter second matrix:");
        ExampleOfMatrix secondMatrix = new ExampleOfMatrix(r, c);
        secondMatrix.enterMatrix();
        if (secondMatrix.getRows() != firstMatrix.getRows() && secondMatrix.getColumns()
                != firstMatrix.getColumns()) {
            System.out.println("ERROR");
        } else {
            ExampleOfMatrix resultMatrix = new ExampleOfMatrix(firstMatrix.getRows(), firstMatrix.getColumns());
            for (int i = 0; i < firstMatrix.getRows(); i++) {
                for (int j = 0; j < firstMatrix.getColumns(); j++) {
//                    adding matrix
                    resultMatrix.setElement(i, j, firstMatrix.getElement(i, j) +
                            secondMatrix.getElement(i, j));
                }
            }
            System.out.println("The result of adding");
            resultMatrix.printMatrix();
        }
//
    }
}
