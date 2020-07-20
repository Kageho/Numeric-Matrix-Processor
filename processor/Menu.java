package processor;

import java.util.Scanner;

public class Menu {
    public static boolean chooseAction() {
        Scanner scanner = new Scanner(System.in);
        int n; // it's my action
        System.out.println("1. Add matrices\n" +
                "2. Multiply matrix to a constant\n" +
                "3. Multiply matrices\n" +
                "4. Transpose matrix\n" +
                "5. Calculate a determinant\n" +
                "6. Inverse matrix\n" +
                "0. Exit");
        System.out.print("Your choice: ");
        n = scanner.nextInt();
        // scanner.close();
        switch (n) {
            case 1:
                AddMatrix.addMatrix(); // складываем матрицы
                return true;
            case 2:
                MultiplyToAConst.multiply(); //  умножаем матрицу на const
                return true;
            case 3:
                Multiplication.multiplication(); // умножаем две матрицы
                return true;
            case 4:
                TransposeMatrix.MainAction();
                return true;
            case 5:
                Determined.findDetermined();
                return true;
            case 6:
                InverseMatrix.inverseMatrix();
                return true;
            default:
                return false;
        }
    }
}
