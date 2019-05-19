package com.ashok.csv.parse;

import org.junit.Assert;
import org.junit.Test;

public class LineSplitterTest {
    @Test
    public void splitTest() throws Exception {
        String unsplit = "2019-05-15 09:15:02,2105,2125.55,2084.6,2090.2";
        String [] firstDataRow = {"2019-05-15 09:15:02","2105","2125.55","2084.6","2090.2"};

        Assert.assertArrayEquals(LineSplitter.split(unsplit, ","), firstDataRow);
    }

}
