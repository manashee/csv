package com.ashok.csv.typeinference;

import org.junit.Assert;
import org.junit.Test;

public class InferTypeImplTest {

    @Test
    public void inferTypeTest() throws Exception {
        String [] firstDataRow = {"2019-05-15 09:15:02","2105","2125.55","2084.6","2090.2"};

        InferType inferType = new InferTypeImpl();
        Assert.assertEquals(inferType.inferType(firstDataRow[0]),"String");
        Assert.assertEquals(inferType.inferType(firstDataRow[1]),"Double");
        Assert.assertEquals(inferType.inferType(firstDataRow[2]),"Double");
        Assert.assertEquals(inferType.inferType(firstDataRow[3]),"Double");
        Assert.assertEquals(inferType.inferType(firstDataRow[4]),"Double");
    }

}
