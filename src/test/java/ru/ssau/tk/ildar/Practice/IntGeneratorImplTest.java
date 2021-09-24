package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class IntGeneratorImplTest {

    @Test
    public void testNextInt(){
        IntGenerator objectIntGeneratorImpl = new IntGeneratorImpl();
        Assert.assertEquals(objectIntGeneratorImpl.nextInt(),0);
        Assert.assertEquals(objectIntGeneratorImpl.nextInt(),1);
        Assert.assertEquals(objectIntGeneratorImpl.nextInt(),2);
        IntGenerator objectIntGeneratorImplTwo = new IntGeneratorImpl();
        Assert.assertEquals(objectIntGeneratorImplTwo.nextInt(),0);
    }

}