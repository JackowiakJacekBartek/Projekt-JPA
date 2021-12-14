package pl.jackowiakjacekbartek.controllers;

import pl.jackowiakjacekbartek.entities.Product;
import pl.jackowiakjacekbartek.entities.Seller;
import pl.jackowiakjacekbartek.services.ProductService;
import pl.jackowiakjacekbartek.services.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * Homepage controller.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "")
    String index() {
        return "index";
    }

    @PostMapping(value = "generateModel", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        Product p0 = new Product("GTA", new BigDecimal(200));
        Product p1 = new Product("Witcher 3", new BigDecimal(160));
        Product p2 = new Product("Fifa 21", new BigDecimal(200));
        Product p3 = new Product("PES 21", new BigDecimal(200));

        Seller seller = new Seller("EA", "Redwood City");
        Seller seller2 = new Seller("Ubisoft", "Montreuilo");

        p1.getSellers().add(seller);
        p2.getSellers().add(seller);
        p3.getSellers().add(seller);
        p1.getSellers().add(seller2);
        p2.getSellers().add(seller2);

        productService.saveProduct(p0);
        productService.saveProduct(p1);
        productService.saveProduct(p2);
        productService.saveProduct(p3);

        return "Model Generated";
    }
}