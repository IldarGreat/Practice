package ru.ssau.tk.ildar.Practice.clone;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CloneWithCloneableTest {

    @Test
    public void testClone() {
        try {
            CloneWithCloneable object = new CloneWithCloneable(0);
            CloneWithCloneable cloneObject = object.clone();
            Assert.assertEquals(object.number, cloneObject.number);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}