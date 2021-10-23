package ru.ssau.tk.ildar.Practice.functions;


import org.testng.Assert;
import org.testng.annotations.Test;

public class ResettableIntGeneratorTest {

    @Test
    public void testNextInt(){
        IntGenerator objectResettableIntGenerator = new ResettableIntGenerator();
        Assert.assertEquals(objectResettableIntGenerator.nextInt(),0);
        Assert.assertEquals(objectResettableIntGenerator.nextInt(),1);
        Assert.assertEquals(objectResettableIntGenerator.nextInt(),2);
    }

    @Test
    public void testReset(){
        ResettableIntGenerator objectResettableIntGenerator = new ResettableIntGenerator();
        Assert.assertEquals(objectResettableIntGenerator.nextInt(),0);
        Assert.assertEquals(objectResettableIntGenerator.nextInt(),1);
        objectResettableIntGenerator.reset();
        Assert.assertEquals(objectResettableIntGenerator.nextInt(),0);
        objectResettableIntGenerator.reset();
        Assert.assertEquals(objectResettableIntGenerator.nextInt(),0);
    }
}