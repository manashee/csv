package com.ashok.csv.header;

public class ColSchema {
    private final String name;
    private final String type;

    public ColSchema(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ColSchema{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
