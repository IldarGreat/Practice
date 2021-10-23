package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CloneWithoutCloneableTest {

    @Test
    public void testClone() {
        try {
            CloneWithoutCloneable object = new CloneWithoutCloneable(0);
            CloneWithoutCloneable cloneObject = object.clone();
            Assert.assertEquals(object.number, cloneObject.number);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}