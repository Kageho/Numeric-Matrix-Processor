package processor;

import java.util.Scanner;

public class InverseMatrix {
    static Scanner scanner = new Scanner(System.in);

    public static void inverseMatrix() {
//        получаем матрицу, т.е. ее параметры
        System.out.print("Enter matrix size: ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        if (rows != columns) {
            System.out.printf("%s", "Man, you made mistake. I can't inverse not square matrix");
            return;
        }
        ExampleOfMatrix matrix = new ExampleOfMatrix(rows, columns);
        System.out.println("Enter matrix");
        matrix.enterMatrix();
        double determinant = Determined.findDeterminant(matrix);
//       here i try to find determinant
        if (determinant == 0) {
            System.out.println("Sorry, i can't find inverse matrix");
            return;
        }
        ExampleOfMatrix bufferMatrix = new ExampleOfMatrix(matrix.getRows(), matrix.getColumns());
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                ExampleOfMatrix subMatrix = Determined.makeSubMatrix(matrix, i, j);
                double value = Determined.findDeterminant(subMatrix);
//                находим определитель для каждой позиции
                if ((i + j) % 2 == 1) { // if coordinates of minor even, then i
//                    change sign
                    value *= -1;
                }
                bufferMatrix.setElement(i, j, value);
                // System.out.println(value);
                // subMatrix.printMatrix();
            }
        }
//        here i transpose matrix which i get above
        ExampleOfMatrix aHalfAnswer = TransposeMatrix.tMainDiagonal(bufferMatrix);

        MultiplyToAConst.giveResultOfMultiply(1 / determinant, aHalfAnswer).printMatrix();
    }
}
