package com.ashok.csv.header;

import com.ashok.csv.typeinference.InferType;
import com.ashok.csv.typeinference.InferTypeImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HeaderImpl implements Header {

    Map<Integer, ColSchema> csvColumnHeaders = new ConcurrentHashMap<>();

    private final String [] headerRow;
    private final String [] firstDataRow;
    private final InferType inferType;


    public HeaderImpl(String [] headerRow , String [] firstDataRow , InferType inferType) {
        this.headerRow = headerRow;
        this.firstDataRow = firstDataRow;
        this.inferType = inferType;

        makeMap();
    }

    private void makeMap () {
        if (csvColumnHeaders.isEmpty()) {
            for (int i = 0; i < headerRow.length; i++) {
                csvColumnHeaders.put(new Integer(i), new ColSchema( headerRow[i] , getType(firstDataRow[i])));
            }
        }
    }

    public ColSchema getColSchema( int colPosition ) {
        return csvColumnHeaders.get ( new Integer( colPosition)) ;
    }
    public String getColName( int colPosition ) {
        return getColSchema(colPosition).getName();
    }
    public String getColType( int colPosition ) {
        return getColSchema(colPosition).getType();
    }

    public String getType ( String data ) {
        return inferType.inferType( data ) ;
    }
}
