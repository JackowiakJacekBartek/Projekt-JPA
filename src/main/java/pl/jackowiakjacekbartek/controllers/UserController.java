package pl.jackowiakjacekbartek.controllers;

import pl.jackowiakjacekbartek.entities.User;
import pl.jackowiakjacekbartek.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> list(Model model) {
        return userService.listAllUsers();
    }

    @GetMapping(value = "/user/{username}")
    public List<User> getByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @GetMapping(value = "/countproductsbyuserid/{id}")
    public int getProductsById(@PathVariable int id) { return userService.getProductsById(id); }

    @GetMapping(value = "/findbyagegreaterthan/{age}")
    public List<User> getUsersAgeGreaterThan (@PathVariable int age) {
        List<User> fu3 = userService.getUsersAgeGreaterThan(age);
        //fu3.get(0).getAge();
        //czy mozna sie dostac tu do obiektu
        fu3.forEach(System.out::println);

        return userService.getUsersAgeGreaterThan(age);
    }
}