package pl.jackowiakjacekbartek.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, scope= Seller.class)
@Table(name = "Sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String place;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy="sellers")
    private List<Product> products;

    //required by Hibernate
    public Seller(){ }

    public Seller(String name, String place) {
        this.name = name;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getplace() {
        return place;
    }

    public void setplace(String place) {
        this.place = place;
    }
}