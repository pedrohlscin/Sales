package com.pedroso.sales.model;

import java.math.BigDecimal;
import java.util.List;

public class ProductsTax {
    List<Product> products;
    BigDecimal totalPay;
    BigDecimal totalTax;

    public ProductsTax(){
        totalTax = new BigDecimal("0");
        totalPay = new BigDecimal("0");
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        for(Product p : products){
            p.setValue(new BigDecimal(p.getTax().add(p.getValue())+""));
            totalTax = new BigDecimal(totalTax.add(p.getTax()) + "");
            totalPay = new BigDecimal(totalPay.add(p.getValue())+"");
        }
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }
}
