package pl.jackowiakjacekbartek.services;

import pl.jackowiakjacekbartek.entities.User;
import pl.jackowiakjacekbartek.repositories.ProductRepository;
import pl.jackowiakjacekbartek.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> listAllUsers() { return userRepository.listAllUsers(); }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getByUsername(String username) { return userRepository.findByUsername(username); }

    @Override
    public int getProductsById(int id) {
        return userRepository.countProductsById(id);
    }

    @Override
    public List<User> getUsersAgeGreaterThan(int age) { return userRepository.findByAgeGreaterThan(age); }
}
