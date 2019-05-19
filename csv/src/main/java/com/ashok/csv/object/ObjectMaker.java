package com.ashok.csv.object;

import com.ashok.csv.header.Header;
import com.ashok.csv.header.HeaderImpl;

import java.lang.reflect.Field;

public class ObjectMaker<T> {

    Header header;

    public ObjectMaker(Header header) {
        this.header = header;
    }

    public void setField (Class cls, T obj , String colName, String colType, String data ) throws NoSuchFieldException , IllegalAccessException {
        Field f = cls.getDeclaredField(colName);
        f.setAccessible(true);
        if ( colType.equals( "Double" ))
            f.setDouble(obj, Double.valueOf(data));
        else if ( colType.equals( "String" ))
            f.set(obj, data);
    }

    public void setFields(Class cls, T obj, String[] data) throws NoSuchFieldException, IllegalAccessException {
        for (int i = 0; i < data.length; i++)
            setField(cls, obj, header.getColName(i) , header.getColType(i) , data[i]);
    }
}

