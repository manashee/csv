package com.ashok.csv.typeinference;

public class InferTypeImpl implements InferType{

    public  String inferType (String data) {
        if ( null != data ) {
            try {
                double d = Double.parseDouble(data);
                return "Double";
            } catch ( NumberFormatException e ) {
                return "String";
            }
        }
        return null;
    }



}
