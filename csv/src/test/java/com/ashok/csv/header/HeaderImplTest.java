package com.ashok.csv.header;

import com.ashok.csv.typeinference.InferTypeImpl;
import org.junit.Assert;
import org.junit.Test;

public class HeaderImplTest {

    @Test
    public void headerTest() throws Exception {
        String [] headerRow = {"DisplayDate","Open","High","Low","Close"};
        String [] firstDataRow = {"2019-05-15 09:15:02","2105","2125.55","2084.6","2090.2"};

        HeaderImpl headerImpl = new HeaderImpl( headerRow, firstDataRow , new InferTypeImpl());

        Assert.assertEquals(headerImpl.getColSchema(0).getName(),"DisplayDate");
        Assert.assertEquals(headerImpl.getColSchema(1).getName(),"Open");
        Assert.assertEquals(headerImpl.getColSchema(2).getName(),"High");
        Assert.assertEquals(headerImpl.getColSchema(3).getName(),"Low");
        Assert.assertEquals(headerImpl.getColSchema(4).getName(),"Close");
    }

    @Test
    public void inferTypeTest() throws Exception {
        String [] headerRow = {"DisplayDate","Open","High","Low","Close"};
        String [] firstDataRow = {"2019-05-15 09:15:02","2105","2125.55","2084.6","2090.2"};

        HeaderImpl headerImpl = new HeaderImpl( headerRow, firstDataRow, new InferTypeImpl());

        Assert.assertEquals(headerImpl.getType(firstDataRow[0]),"String");
        Assert.assertEquals(headerImpl.getType(firstDataRow[1]),"Double");
        Assert.assertEquals(headerImpl.getType(firstDataRow[2]),"Double");
        Assert.assertEquals(headerImpl.getType(firstDataRow[3]),"Double");
        Assert.assertEquals(headerImpl.getType(firstDataRow[4]),"Double");
    }

}