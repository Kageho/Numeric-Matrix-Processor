package processor;

import java.util.Scanner;

public class MultiplyToAConst {
    public static void multiply() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the matrix's size ");
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        ExampleOfMatrix myMatrix = new ExampleOfMatrix(r, c);
        System.out.println("Enter the matrix");
        myMatrix.enterMatrix();
        System.out.print("Enter the constant ");
        int constant = scanner.nextInt();

        System.out.println("The result of multiplication the matrix by const: ");
        giveResultOfMultiply(constant, myMatrix).printMatrix();
    }

    public static ExampleOfMatrix giveResultOfMultiply(double constant, ExampleOfMatrix myMatrix) {
        for (int i = 0; i < myMatrix.getRows(); i++) {
            for (int j = 0; j < myMatrix.getColumns(); j++) {
//                this is cool! Умножение матрицы на число
                myMatrix.setElement(i, j, myMatrix.getElement(i, j) * constant);
            }
        }
        return myMatrix;
    }
}
