package ru.ssau.tk.ildar.Practice;

public class Matrices {

    public static Matrix sum(Matrix matrixOne, Matrix matrixTwo) {
        if (matrixOne.getColumns() != matrixTwo.getColumns() || matrixOne.getRows() != matrixTwo.getRows()) {
            return null;
        }
        Matrix newMatrix = new Matrix(matrixOne.getColumns(), matrixOne.getRows());
        for (int column = 0; column < newMatrix.getColumns(); column++) {
            for (int row = 0; row < newMatrix.getRows(); row++) {
                newMatrix.setAt(column, row, matrixOne.getAt(column, row) + matrixTwo.getAt(column, row));
            }
        }
        return newMatrix;
    }

    public static Matrix multiplication(Matrix matrixOne, Matrix matrixTwo) {
        if (matrixOne.getColumns() != matrixTwo.getRows()) {
            return null;
        }
        Matrix newMatrix = new Matrix(matrixOne.getRows(), matrixTwo.getColumns());
        for (int row = 0; row < newMatrix.getColumns(); row++) {
            for (int column = 0; column < newMatrix.getColumns(); column++) {
                newMatrix.setAt(column, row, multiplyMatricesCell(matrixOne, matrixTwo, row, column));
            }
        }
        return newMatrix;
    }

    public static double multiplyMatricesCell(Matrix matrixOne, Matrix matrixTwo, int row, int column) {
        double cell = 0;
        for (int element = 0; element < matrixTwo.getColumns(); element++) {
            cell += matrixOne.getAt(element, row) * matrixTwo.getAt(column, element);
        }
        return cell;
    }

    public static Matrix multiplicationByANumber(Matrix matrix, double number) {
        Matrix newMatrix = new Matrix(matrix.getColumns(), matrix.getRows());
        for (int column = 0; column < newMatrix.getColumns(); column++) {
            for (int row = 0; row < newMatrix.getRows(); row++) {
                newMatrix.setAt(column, row, number * matrix.getAt(column, row));
            }
        }
        return newMatrix;
    }
}
