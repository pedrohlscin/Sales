package com.pedroso.sales.model;

import java.util.stream.Stream;

public enum TaxTypes {
    BASIC("basicTax", 10), IMPORTED("imported", 5), MUSIC("music", 20);

    private String description;
    private double value;

    TaxTypes(String desc, double val){
        this.description = desc;
        this.value = val;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    public static Stream<TaxTypes> stream() {
        return Stream.of(TaxTypes.values());
    }
}

