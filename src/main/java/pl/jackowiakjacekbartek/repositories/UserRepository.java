package pl.jackowiakjacekbartek.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.jackowiakjacekbartek.entities.Product;
import pl.jackowiakjacekbartek.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer>, PagingAndSortingRepository<User, Integer> {

    List<User> findByUsername(String username);

    List<User> findByAgeGreaterThan(int age);

    @Query("select count(*) from User s join s.products p where s.id = ?1")
    int countProductsById(int id);

    //Czemu zwraca mi REST tylko id? bez username, place, age. Rest products dobrze zwraca. Userów - nie. return userRepository.findAll(); sprawdzałem - nie działało. z @Query("SELECT u FROM User u") też zwraca tyko id
    @Query("SELECT u FROM User u")
    List<User> listAllUsers();
}