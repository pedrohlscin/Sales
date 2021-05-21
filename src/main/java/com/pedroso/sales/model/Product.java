package com.pedroso.sales.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Product {
    private int quantity;
    private String description;
    private BigDecimal value;
    private BigDecimal tax;
    private List<TaxTypes> taxes;

    public Product(){
        this.value = new BigDecimal("0");
        this.tax = new BigDecimal("0");
        this.taxes = new ArrayList<>();
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String compare = description.toLowerCase();
        for(TaxTypes type : TaxTypes.values()){
            if(compare.contains(type.getDescription())){
                taxes.add(type);
            }
        }
        if(isTaxable(description)){
            this.taxes.add(TaxTypes.BASIC);
        }
        this.description = description;
    }

    private boolean isTaxable(String description) {
        String descriptionLowerCase = description.toLowerCase();
        if(descriptionLowerCase.contains("pill") || descriptionLowerCase.contains("book") || descriptionLowerCase.contains("chocolate")){
            return false;
        }
        return true;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public List<TaxTypes> getTaxes() {
        return taxes;
    }
}

