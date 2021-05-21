package com.pedroso.sales;

import com.pedroso.sales.model.Product;
import com.pedroso.sales.model.TaxTypes;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductTest extends SalesApplicationTests{
    @Test
    public void creationProductWithBasicTax(){
        Product p = new Product();
        p.setQuantity(2);
        p.setValue(new BigDecimal("10"));
        p.setDescription("mouse at");
        Assert.assertEquals(p.getTaxes().contains(TaxTypes.BASIC), true);
    }

    @Test
    public void creationProductWithoutBasicTax(){
        Product p = new Product();
        p.setQuantity(1);
        p.setValue(new BigDecimal("10"));
        p.setDescription("pills at");
        Assert.assertEquals(p.getTaxes().size(), 0);
    }
}
