package pl.jackowiakjacekbartek.controllers;

import pl.jackowiakjacekbartek.entities.Product;
import pl.jackowiakjacekbartek.entities.Seller;
import pl.jackowiakjacekbartek.services.ProductService;
import pl.jackowiakjacekbartek.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Homepage controller.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SellerService sellerService;

    @GetMapping(value = "")
    String index() {
        return "index";
    }

    @PostMapping(value = "generateProducts", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateProducts() {

        Product p0 = new Product("GTA V", new BigDecimal(200));
        Product p1 = new Product("Witcher 3", new BigDecimal(160));
        Product p2 = new Product("Fifa 21", new BigDecimal(200));
        Product p3 = new Product("Cyberpunk", new BigDecimal(200));
        Product p4 = new Product("Red Dead Redemption 2", new BigDecimal(250));

        productService.saveProduct(p0);
        productService.saveProduct(p1);
        productService.saveProduct(p2);
        productService.saveProduct(p3);
        productService.saveProduct(p4);

        return "Products Generated";
    }

    @PostMapping(value = "generateSellers", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateSellers() {

        Seller s0 = new Seller("EA", "Redwood City");
        Seller s1 = new Seller("Rockstar", "New York");
        Seller s2 = new Seller("CD Project", "Warsaw");

        sellerService.saveSeller(s0);
        sellerService.saveSeller(s1);
        sellerService.saveSeller(s2);

        return "Sellers Generated";
    }

    @PostMapping(value = "generateSales", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateSales() {

        Product p0 = new Product("Rocket League", new BigDecimal(99));
        Seller s0 = new Seller("Psyonix", "Raleigh");
        p0.getSellers().add(s0);
        productService.saveProduct(p0);

        return "Sales Generated";
    }
}