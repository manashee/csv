package com.ashok;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

import com.ashok.csv.header.ColSchema;
import com.ashok.csv.header.HeaderImpl;
import com.ashok.csv.object.ObjectMaker;
import com.ashok.csv.typeinference.InferTypeImpl;
import com.ashok.entity.Stock;
import com.ashok.entity.Stock2;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple Csv.
 */
public class CsvTest {
    /**
     * Rigorous Test :-)
     */


    @Test
    public void readMillionRows()
    {
        String fileName = "/home/ashok/trading/spark/TCS_Million.csv";
        File input = new File ( fileName);
        Csv<Stock> csv = new Csv<>();
        try {
            Collection<Stock> stocks = csv.parse(input, Stock.class);
            Assert.assertTrue(stocks.size() == 1000000);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }


    @Test
    public void readMillionRowsStock2()
    {
        String fileName = "/home/ashok/trading/spark/TCS_MillionWithStockName.csv";
        File input = new File ( fileName);
        Csv<Stock2> csv = new Csv<>();
        try {
            Collection<Stock2> stocks = csv.parse(input, Stock2.class);
            Assert.assertTrue(stocks.size() == 1000000);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    @Test
    public void removeDuplicatesTestOnMillionRows()
    {
        String fileName = "/home/ashok/trading/spark/TCS_Million.csv";
        File input = new File ( fileName);
        Csv<Stock> csv = new Csv<>();
        try {
            Collection<Stock> stocks = csv.parseDeDup(input, Stock.class);
            Assert.assertTrue(stocks.size() == 2);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    @Test
    public void removeDuplicatesTest()
    {
        String fileName = "/home/ashok/trading/spark/TCS5.csv";
        File input = new File ( fileName);
        Csv<Stock> csv = new Csv<>();
        try {
            Collection<Stock> stocks = csv.parseDeDup(input, Stock.class);

            Assert.assertTrue(stocks.size() == 1);

            for (Stock s : stocks) {
                Assert.assertEquals(s.getDisplayDate(), "2019-05-15");
                Assert.assertEquals(new Double(s.getOpen()), new Double(2105));
                Assert.assertEquals(new Double(s.getHigh()), new Double(2125.55));
                Assert.assertEquals(new Double(s.getLow()), new Double(2084.6));
                Assert.assertEquals(new Double(s.getClose()), new Double(2090.2));
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }


    @Test
    public void parseTest2()
    {
        String fileName = "/home/ashok/trading/spark/TCS4.csv";
        File input = new File ( fileName);
        Csv<Stock> csv = new Csv<>();
        try {
            Collection<Stock> stocks = csv.parse(input, Stock.class);

            for (Stock s : stocks) {
                Assert.assertEquals(s.getDisplayDate(), "2019-05-15");
                Assert.assertEquals(new Double(s.getOpen()), new Double(2105));
                Assert.assertEquals(new Double(s.getHigh()), new Double(2125.55));
                Assert.assertEquals(new Double(s.getLow()), new Double(2084.6));
                Assert.assertEquals(new Double(s.getClose()), new Double(2090.2));
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }


    @Test
    public void parseTest3()
    {
        String fileName = "/home/ashok/trading/spark/TCS5.csv";
        File input = new File ( fileName);
        Csv<Stock> csv = new Csv<>();
        try {
            Collection<Stock> stocks = csv.parse(input, Stock.class);
            Stock s = new Stock ("2019-05-15",2105d,2125.55d,2084.6d,2090.2d);
            Stock s1 = new Stock ("2019-05-14",2137.5d,2158.2d,2074.5d,2094.35d);
            Assert.assertTrue(stocks.contains(s));
            Assert.assertTrue(stocks.contains(s1));


        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    @Test
    public void parseTest()
    {
        String fileName = "/home/ashok/trading/spark/TCS4.csv";
        File input = new File ( fileName);
        Csv<Stock> csv = new Csv<>();
        try {
            Collection<Stock> stocks = csv.parse(input, Stock.class);

            for (Stock s : stocks) {
                Assert.assertEquals(s.getDisplayDate(), "2019-05-15");
                Assert.assertEquals(new Double(s.getOpen()), new Double(2105));
                Assert.assertEquals(new Double(s.getHigh()), new Double(2125.55));
                Assert.assertEquals(new Double(s.getLow()), new Double(2084.6));
                Assert.assertEquals(new Double(s.getClose()), new Double(2090.2));
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }


    @Test
    public void toObjTest() throws Exception {
        String[] headerRow = {"DisplayDate", "Open", "High", "Low", "Close"};
        String[] firstDataRow = {"2019-05-15 09:15:02", "2105", "2125.55", "2084.6", "2090.2"};

        HeaderImpl headerImpl = new HeaderImpl(headerRow, firstDataRow, new InferTypeImpl());
        ObjectMaker<Stock> objectMaker = new ObjectMaker<>(headerImpl);
        Csv<Stock> csv = new Csv<>();
        Stock stock = csv.toObj(Stock.class, objectMaker, firstDataRow);

        Assert.assertEquals(stock.getDisplayDate(), "2019-05-15 09:15:02");
        Assert.assertEquals(new Double(stock.getOpen()), new Double(2105d));
        Assert.assertEquals(new Double(stock.getHigh()), new Double(2125.55d));
        Assert.assertEquals(new Double(stock.getLow()), new Double(2084.6d));
        Assert.assertEquals(new Double(stock.getClose()), new Double(2090.2d));
    }

}
