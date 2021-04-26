package com.pedroso.sales.service;

import com.pedroso.sales.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    public BigDecimal calculateTaxes(List<Product> products){
        BigDecimal acumulated = new BigDecimal(0);
        BigDecimal onePointOne = new BigDecimal(1.1);
        BigDecimal onePointOFive = new BigDecimal(1.05);

        for(Product p : products){
            if(p.isHasBasicTax()){
                acumulated.add(p.getValue().min(p.getValue().multiply(onePointOne)));
            }
            if(p.isImported()){
                acumulated.add(p.getValue().min(p.getValue().multiply(onePointOFive)));
            }
        }

        return acumulated;
    }
}
