package com.pedroso.sales.service;

import com.pedroso.sales.model.Product;
import com.pedroso.sales.model.TaxTypes;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Service
public class ProductService {

    public List<Product> calculateTaxes(List<Product> products){
        BigDecimal taxes = new BigDecimal("0");
        for(Product p : products){
            int tax = 0;
            for(TaxTypes t : p.getTaxes()){
                tax += t.getValue();
            }
            taxes = p.getValue().multiply(new BigDecimal(((float)tax/(float)100)+""));
            p.setTax(taxes);
        }
        return products;
    }
}
