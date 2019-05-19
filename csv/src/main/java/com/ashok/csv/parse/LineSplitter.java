package com.ashok.csv.parse;

public class LineSplitter {

    public static String [] split ( String row , String delimiter ) {
        return row.split(delimiter );
    }
}
