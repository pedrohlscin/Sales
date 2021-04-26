package com.pedroso.sales.model;

import java.math.BigDecimal;

public class Product {
    private int quantity;
    private boolean imported;
    private boolean hasBasicTax;
    private String description;
    private BigDecimal value;

    public Product(){
    }

    public boolean isHasBasicTax() {
        return hasBasicTax;
    }

    public void setHasBasicTax(boolean hasBasicTax) {
        this.hasBasicTax = hasBasicTax;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.contains("imported")){
            setImported(true);
        }
        if(isTaxable(description)){
            this.hasBasicTax = true;
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
}

