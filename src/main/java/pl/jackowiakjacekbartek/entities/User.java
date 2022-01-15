package pl.jackowiakjacekbartek.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.gson.Gson;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, scope= User.class)
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private int age;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy="users")
    private List<Product> products;

    public User(){ }

    public User(String username, String place, int age) {
        this.username = username;
        this.place = place;
        this.age = age;
    }

    public int getId() {
        return id;
    }

}