package com.pedroso.sales.controller;

import com.pedroso.sales.model.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class SalesController {

    @PostMapping("/product")
    @ResponseBody
    public List<Product> hello(@RequestBody List<Product> products){
        BigDecimal count = new BigDecimal(0);
        for(Product p : products){
            count.add(p.getValue());
        }
        return products;
    }

}
