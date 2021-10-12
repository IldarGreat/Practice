package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MatrixTest {

    @Test
    public static void testGettersAndSetters() {
        Matrix matrix = new Matrix(2, 3);
        Assert.assertEquals(matrix.getColumns(), 2);
        Assert.assertEquals(matrix.getRows(), 3);
        matrix.setAt(0, 0, 50);
        matrix.setAt(0, 1, 32); /* 50 23 */
        matrix.setAt(0, 2, 47); /* 32 12 */
        matrix.setAt(1, 0, 23); /* 47 67 */
        matrix.setAt(1, 1, 12);
        matrix.setAt(1, 2, 67);
        Assert.assertEquals(matrix.getAt(0, 0), 50.0);
        Assert.assertEquals(matrix.getAt(0, 1), 32.0);
        Assert.assertEquals(matrix.getAt(0, 2), 47.0);
        Assert.assertEquals(matrix.getAt(1, 0), 23.0);
        Assert.assertEquals(matrix.getAt(1, 1), 12.0);
        Assert.assertEquals(matrix.getAt(1, 2), 67.0);

    }

}