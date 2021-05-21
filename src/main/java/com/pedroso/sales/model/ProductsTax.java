package com.pedroso.sales.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
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
            BigDecimal quantity = new BigDecimal(p.getQuantity());
            BigDecimal value = roundPointOFive(new BigDecimal(p.getTax().add(p.getValue())+""));
            for(TaxTypes t : p.getTaxes()){
                totalTax = totalTax.add(new BigDecimal((float)t.getValue()/(float)100+"").multiply(p.getValue()).multiply(quantity));
            }
            p.setValue(value);
                totalPay = new BigDecimal(totalPay.add(p.getValue()).multiply(quantity)+"");

        }
    }

    public BigDecimal roundPointOFive(BigDecimal number){
        BigDecimal pointOFive = new BigDecimal("0.05");
        if(number.remainder(pointOFive).compareTo(BigDecimal.ZERO) == 0){
            return number;
        }
        BigDecimal divided = number.divide(pointOFive, 0, RoundingMode.UP);
        BigDecimal result = divided.multiply(pointOFive);
        return result;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }
}
