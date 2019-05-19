package com.ashok;

import com.ashok.csv.header.ColSchema;
import com.ashok.csv.header.HeaderImpl;
import com.ashok.csv.object.ObjectMaker;
import com.ashok.csv.typeinference.InferTypeImpl;
import com.ashok.entity.Stock;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Hello world!
 *
 */
public class Csv<T>
{

    Class<T> cls;

    String[] headerRow ;
    String[] firstDataRow ;
    HeaderImpl headerImpl;

    public static void main( String[] args )
    {
        String fileName = args[0];
        File input = new File ( fileName);
        Csv<Stock> csv = new Csv<>();
        try {
            Collection<Stock> stocks = csv.parse(input, Stock.class);

            for (Stock s : stocks) {
                System.out.println(s.getDisplayDate() + " " + s.getOpen() + " " + s.getHigh() + " "  + s.getLow() + " " + s.getClose());
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }


    public Collection<T> parse(File csv, Class<T> cls) throws IOException, InstantiationException, NoSuchFieldException, IllegalAccessException {
        List<T> list = new ArrayList<>();
        return parseImpl(csv, cls, list);
    }


    public Collection<T> parseDeDup(File csv, Class<T> cls) throws IOException, InstantiationException, NoSuchFieldException, IllegalAccessException {
        Set<T> set = new HashSet<>();
        return parseImpl(csv, cls, set);
    }

    public Collection<T> parseImpl(File csv, Class<T> cls, Collection<T> collection) throws IOException, InstantiationException, NoSuchFieldException, IllegalAccessException {
        this.cls = cls;

        FileReader fileReader = new FileReader(csv);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        headerRow = readALine(bufferedReader);
        firstDataRow = readALine(bufferedReader);

        HeaderImpl headerImpl = new HeaderImpl(headerRow, firstDataRow, new InferTypeImpl());
        ObjectMaker<T> objectMaker = new ObjectMaker<>(headerImpl);
        T firstObj = toObj(cls, objectMaker, firstDataRow);
        collection.add (firstObj);

        String row ;
        while ((row = bufferedReader.readLine()) != null) {
            T obj = toObj(cls, objectMaker,  row.split(","));
            collection.add (obj);
        }

        return collection;
    }



    private String [] readALine ( BufferedReader bufferedReader) throws IOException {
        String row = bufferedReader.readLine();
        if ( null != row ) {
            return row.split(",");
        }
        return null;
    }


    public T toObj (Class<T> cls, ObjectMaker<T> objectMaker , String [] dataRow ) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        T instance = cls.newInstance();
        objectMaker.setFields(cls, instance, dataRow);
        return instance;
    }
}
