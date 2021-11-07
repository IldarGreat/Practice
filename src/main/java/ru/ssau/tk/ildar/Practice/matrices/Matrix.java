package ru.ssau.tk.ildar.Practice.matrices;

public class Matrix {
    private final double[][] matrix;
    private final int rows; // Строки
    private final int columns;

    public Matrix(int columns, int rows) {
        matrix = new double[columns][rows];
        this.rows = rows;
        this.columns = columns;
    }

    public double getAt(int columnElement, int rowElement) {
        if (rowElement > this.rows || columnElement > this.columns) {
            return 0;
        }
        return matrix[columnElement][rowElement];
    }

    public void setAt(int columnElement, int rowElement, double number) {
        if (rowElement > this.rows || columnElement > this.columns) {
            return;
        }
        matrix[columnElement][rowElement] = number;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    @Override
    public String toString(){
        StringBuilder stringMatrix= new StringBuilder();
        for(int columns=0;columns<this.columns;columns++){
            for(int rows=0;rows<this.rows;rows++){
                stringMatrix.append(getAt(columns, rows)).append(",");
            }
            stringMatrix.append(";\n");
        }
        return stringMatrix.toString();
    }

}
