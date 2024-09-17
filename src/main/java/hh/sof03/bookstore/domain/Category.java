package hh.sof03.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long categodyId;
    private String name;

    public Category(Long categodyId, String name) {
        this.categodyId = categodyId;
        this.name = name;
    }

    public Category() {
    }

    public Long getCategodyId() {
        return categodyId;
    }

    public void setCategodyId(Long categodyId) {
        this.categodyId = categodyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category [categodyId=" + categodyId + ", name=" + name + "]";
    }

}
