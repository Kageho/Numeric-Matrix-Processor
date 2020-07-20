package processor;

import java.util.Scanner;

public class TransposeMatrix {
    private static int rows;
    private static int columns;
    private static ExampleOfMatrix transMatrix;
    private static ExampleOfMatrix answerMatrix; // answer

    static Scanner scanner = new Scanner(System.in);

    // создаем нашу матрицу
    public static void MainAction() { // статический блок получаем данные о матрице
        int n;
        System.out.printf("%s", "1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n" + "Your choice: ");
        n = scanner.nextInt();
        System.out.print("Enter matrix size ");
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        transMatrix = new ExampleOfMatrix(rows, columns);
        System.out.println("Enter matrix: ");
        transMatrix.enterMatrix();

//        Здесь же будем выбирать метод действия
        //                здесь будет транспонирование
        boolean doIHaveToPrint = true;
//        защита от дурака, применяется в default ниже
        switch (n) {
            case 1:
                answerMatrix = TransposeMatrix.tMainDiagonal(transMatrix);

                break;
            case 2:
                answerMatrix = TransposeMatrix.tSideDiagonal(transMatrix);

                break;
            case 3:
                answerMatrix = TransposeMatrix.tVerticalLine(transMatrix);

                break;
            case 4:
                answerMatrix = TransposeMatrix.tHorizontalLine(transMatrix);

                break;
            default:
                doIHaveToPrint = false;
                break;
        }
        if (doIHaveToPrint) {
            TransposeMatrix.printMatrix();
        }
    }

    // транспонирование относительно главной диагонали
    public static ExampleOfMatrix tMainDiagonal(ExampleOfMatrix transMatrix) {
        ExampleOfMatrix editMatrix = new ExampleOfMatrix(transMatrix.getColumns(),
                transMatrix.getRows());
        for (int i = 0; i < transMatrix.getRows(); i++) {
            for (int j = 0; j < transMatrix.getColumns(); j++) {
                editMatrix.setElement(j, i, transMatrix.getElement(i, j));
            }
        }
        return editMatrix;
    }

    // транспонирование относительно побочной диагонали
    private static ExampleOfMatrix tSideDiagonal(ExampleOfMatrix transMatrix) {
        return tHorizontalLine(tMainDiagonal(tHorizontalLine(transMatrix)));
    }

    // верткальное транспонирование
    private static ExampleOfMatrix tVerticalLine(ExampleOfMatrix transMatrix) {
        ExampleOfMatrix editMatrix = new ExampleOfMatrix(transMatrix.getRows(),
                transMatrix.getColumns());
        for (int i = 0; i < transMatrix.getRows(); i++) {
            for (int j = 0; j < transMatrix.getColumns(); j++) {
                editMatrix.setElement(i, transMatrix.getColumns() - j - 1,
                        transMatrix.getElement(i, j));
            }
        }
        return editMatrix;
    }

    //горизонтальное транспонирование
    private static ExampleOfMatrix tHorizontalLine(ExampleOfMatrix transMatrix) {
        ExampleOfMatrix editMatrix = new ExampleOfMatrix(transMatrix.getRows(),
                transMatrix.getColumns());
        for (int i = 0; i < transMatrix.getRows(); i++) {
            for (int j = 0; j < transMatrix.getColumns(); j++) {
                editMatrix.setElement(transMatrix.getRows() - i - 1, j,
                        transMatrix.getElement(i, j));
            }
        }
        return editMatrix;
    }

    private static void printMatrix() {
        answerMatrix.printMatrix();
    }
}
