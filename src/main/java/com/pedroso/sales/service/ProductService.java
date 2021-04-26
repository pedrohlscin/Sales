package com.pedroso.sales.service;

import com.pedroso.sales.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ProductService {

    public List<Product> calculateTaxes(List<Product> products){
        BigDecimal onePointOne = new BigDecimal(1.1);
        BigDecimal onePointOFive = new BigDecimal(1.05);
        MathContext m = new MathContext(2);

        for(Product p : products){
            if(p.isHasBasicTax()){
                p.setTax(new BigDecimal(p.getValue().multiply(onePointOne).subtract(p.getValue()).round(m)+ ""));
            }
            if(p.isImported()){
                p.setTax(new BigDecimal(p.getTax().add(p.getValue().multiply(onePointOFive).subtract(p.getValue()).round(m))+ ""));
            }
        }
        return products;
    }

    public BigDecimal roundPointOFive(BigDecimal number, BigDecimal apxPoint, MathContext m){
        return number.subtract(apxPoint).round(m).add(apxPoint);
    }
}
