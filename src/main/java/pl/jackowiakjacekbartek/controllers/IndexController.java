package pl.jackowiakjacekbartek.controllers;

import com.google.gson.Gson;
import pl.jackowiakjacekbartek.entities.Product;
import pl.jackowiakjacekbartek.entities.User;
import pl.jackowiakjacekbartek.services.ProductService;
import pl.jackowiakjacekbartek.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

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

    @PostMapping(value = "generateUsers", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateBuyers() {

        User s0 = new User("adrian123", "Redwood City", 15);
        User s1 = new User("stasiek333", "New York", 16);
        User s2 = new User("jacek12", "Warsaw", 32);

        userService.saveUser(s0);
        userService.saveUser(s1);
        userService.saveUser(s2);

        return "Users Generated";
    }

    @PostMapping(value = "generateSales", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateSales() {

        //Jak zrobić tak żeby obiekt pobrać z bazy danych? tz, że tworze Userów w generateUsers, Products w generateProducts
        // a w generateSales chce pobrać usera i product zamiast tworzyć nowych

        Product p0 = new Product("Rocket League", new BigDecimal(99));
        Product p1 = new Product("Resident Evil 2", new BigDecimal(199));
        User s0 = new User("bartek35355", "Poznan", 17);
        p0.getUsers().add(s0);
        p1.getUsers().add(s0);
        productService.saveProduct(p0);
        productService.saveProduct(p1);

        return "Sales Generated";
    }
}