package com.ashok.csv.object;

import com.ashok.csv.header.ColSchema;
import com.ashok.csv.header.HeaderImpl;
import com.ashok.csv.parse.LineSplitter;
import com.ashok.csv.typeinference.InferTypeImpl;
import com.ashok.entity.Stock;
import org.junit.Assert;
import org.junit.Test;

public class ObjectMakerTest {

    @Test
    public void setFieldTest() throws Exception {
        Stock s = new Stock();
        ColSchema colSchema = new ColSchema("Open", "Double");

        String[] headerRow = {"DisplayDate", "Open", "High", "Low", "Close"};
        String[] firstDataRow = {"2019-05-15 09:15:02", "2105", "2125.55", "2084.6", "2090.2"};

        HeaderImpl headerImpl = new HeaderImpl(headerRow, firstDataRow, new InferTypeImpl());


        ObjectMaker<Stock> objectMaker = new ObjectMaker<>(headerImpl);
        objectMaker.setField(Stock.class, s, colSchema.getName(), colSchema.getType(), "1.2345");
        Assert.assertEquals(new Double(s.getOpen()), new Double(1.2345d));
    }

    @Test
    public void setFieldTest2() throws Exception {
        Stock s = new Stock();
        ColSchema colSchema = new ColSchema("DisplayDate", "String");

        String[] headerRow = {"DisplayDate", "Open", "High", "Low", "Close"};
        String[] firstDataRow = {"2019-05-15 09:15:02", "2105", "2125.55", "2084.6", "2090.2"};

        HeaderImpl headerImpl = new HeaderImpl(headerRow, firstDataRow, new InferTypeImpl());


        ObjectMaker<Stock> objectMaker = new ObjectMaker<>(headerImpl);
        objectMaker.setField(Stock.class, s, colSchema.getName(), colSchema.getType(), "2019-05-06 15:30:00");
        Assert.assertEquals(s.getDisplayDate(), "2019-05-06 15:30:00");
    }


    @Test
    public void setFieldsTest() throws Exception {
        Stock s = new Stock();
        ColSchema colSchema = new ColSchema("DisplayDate", "String");

        String[] headerRow = {"DisplayDate", "Open", "High", "Low", "Close"};
        String[] firstDataRow = {"2019-05-15 09:15:02", "2105", "2125.55", "2084.6", "2090.2"};

        HeaderImpl headerImpl = new HeaderImpl(headerRow, firstDataRow, new InferTypeImpl());


        ObjectMaker<Stock> objectMaker = new ObjectMaker<>(headerImpl);
        objectMaker.setFields(Stock.class, s, firstDataRow);
        Assert.assertEquals(s.getDisplayDate(), "2019-05-15 09:15:02");
        Assert.assertEquals(new Double(s.getOpen()), new Double(2105d));
        Assert.assertEquals(new Double(s.getHigh()), new Double(2125.55d));
        Assert.assertEquals(new Double(s.getLow()), new Double(2084.6d));
        Assert.assertEquals(new Double(s.getClose()), new Double(2090.2d));
    }
}
