package com.pedroso.sales.controller;

import com.pedroso.sales.model.Product;
import com.pedroso.sales.model.ProductsTax;
import com.pedroso.sales.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class SalesController {

    @Autowired
    private ProductService service;

    @PostMapping("/product")
    @ResponseBody
    public ProductsTax calculate(@RequestBody List<Product> products){
        List<Product> productsWithTaxPerProduct = service.calculateTaxes(products);
        ProductsTax calculated = new ProductsTax();
        calculated.setProducts(productsWithTaxPerProduct);
        return calculated;
    }

}
