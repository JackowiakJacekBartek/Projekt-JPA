package pl.jackowiakjacekbartek;

import pl.jackowiakjacekbartek.entities.Product;
import pl.jackowiakjacekbartek.entities.User;
import pl.jackowiakjacekbartek.repositories.ProductRepository;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.jackowiakjacekbartek.repositories.UserRepository;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.math.BigDecimal;
import java.util.UUID;
import static org.springframework.boot.test.context.SpringBootTest.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class WebAppApplicationTests {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void productTest() throws Exception {
        createProduct("Forza", new BigDecimal(149));
        mvc.perform(get("/api/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Forza"));
        deleteProduct();
    }
    private void createProduct(String name, BigDecimal price) { productRepository.save(new Product(name, price)); }
    private void deleteProduct() { productRepository.deleteAll(); }

    @Test
    public void userTest() throws Exception {
        createUser("Duda123", "Warszawa", 52);
        mvc.perform(get("/api/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value("1"));
        deleteUser();
    }
    private void createUser(String username, String place, int age) { userRepository.save(new User(username, place, age)); }
    private void deleteUser() { userRepository.deleteAll(); }

    @Test
    public void indexTest() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("index"));
    }
}