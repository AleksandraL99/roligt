package pl.roligt.roligt.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @Column(name="price")
    private int price;
    @Column(name="name")
    private String name;
    private int number_of_children;

    public Category(Long category_id, int price, String name, int number_of_children) {
        this.category_id = category_id;
        this.price = price;
        this.name = name;
        this.number_of_children = number_of_children;
    }

    public Category() {
    };

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber_of_children() {
        return number_of_children;
    }

    public void setNumber_of_children(int number_of_children) {
        this.number_of_children = number_of_children;
    }
}
