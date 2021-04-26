package com.pedroso.sales.service;

import com.pedroso.sales.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Service
public class ProductService {

    public List<Product> calculateTaxes(List<Product> products){
        BigDecimal pointOFive = new BigDecimal("0.05");
        MathContext m = new MathContext(2);

        for(Product p : products){
            int tax = 0;
            if(p.isHasBasicTax()){
                tax += 10;
            }
            if(p.isImported()) {
                tax += 5;
            }
            BigDecimal taxes = roundPointOFive(p.getValue().multiply(new BigDecimal(((float)tax/(float)100)+"")), pointOFive, m);
            p.setTax(taxes);
        }
        return products;
    }

    public BigDecimal roundPointOFive(BigDecimal number, BigDecimal apxPoint, MathContext m){
        return number.subtract(apxPoint).round(m).add(apxPoint);
    }
}
