package ru.ssau.tk.ildar.Practice.matrices;

import java.util.*;
import java.util.stream.*;


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
    public String toString() {
        StringBuilder stringMatrix = new StringBuilder();
        for (int columns = 0; columns < this.columns; columns++) {
            for (int rows = 0; rows < this.rows; rows++) {
                stringMatrix.append(getAt(columns, rows)).append(",");
            }
            stringMatrix.append(";\n");
        }
        return stringMatrix.toString();
    }

    public Stream<Double> columnStream() {
        List<Double> columnStream = new ArrayList<>();
        for (int column = 0; column < this.columns; column++) {
            for (int row = 0; row < this.rows; row++) {
                columnStream.add(getAt(column, row));
            }
        }
        return columnStream.stream();
    }

    public Stream<Double> rawStream() {
        List<Double> rawStream = new ArrayList<>();
        for (int row = 0; row < getRows(); row++) {
            for (int column = 0; row < getColumns(); column++) {
                rawStream.add(getAt(row, column));
                System.out.println(rawStream);
            }
        }
        return rawStream.stream();
    }

}
