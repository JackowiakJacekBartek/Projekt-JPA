package pl.jackowiakjacekbartek.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Product entity.
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, scope= Product.class)
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Seller> sellers = new HashSet<>();

    //required by Hibernate
    public Product(){ }

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(Set<Seller> sellers) {
        this.sellers = sellers;
    }
}
