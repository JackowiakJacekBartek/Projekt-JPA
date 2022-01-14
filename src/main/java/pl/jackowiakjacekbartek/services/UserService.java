package pl.jackowiakjacekbartek.services;

import pl.jackowiakjacekbartek.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Iterable<User> listAllUsers();

    Optional<User> getUserById(Integer id);

    User saveUser(User user);

    List<User> getByUsername(String username);

    int getProductsById(int id);

    List<User> getUsersAgeGreaterThan(int id);
}
