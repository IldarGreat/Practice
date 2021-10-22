package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CloneWithCloneableTest {

    @Test
    public void testClone()  {
        try{
            CloneWithCloneable object = new CloneWithCloneable(0);
            Object cloneObject = object.clone();
            Assert.assertEquals(object,cloneObject);
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }

}