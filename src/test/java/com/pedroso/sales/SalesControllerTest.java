package com.pedroso.sales;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.pedroso.sales.controller.SalesController;
import com.pedroso.sales.model.Product;
import com.pedroso.sales.model.ProductsTax;
import com.pedroso.sales.service.ProductService;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalesControllerTest extends SalesApplicationTests {

    @Test
    public void testProductCalc() {
        ProductService service = new ProductService();
        SalesController controller = new SalesController(service);
        List<Product> products = populateProducts();
        ProductsTax productsCalculated = controller.calculate(products);
        Assert.assertEquals(productsCalculated.getTotalTax().toString(), "1.0");

    }

    private List<Product> populateProducts() {
        List<Product> prods = new ArrayList<>();
        Product p = new Product();
        p.setQuantity(1);
        p.setDescription("mouse at");
        p.setValue(new BigDecimal("10"));
        prods.add(p);
        return prods;
    }
}
