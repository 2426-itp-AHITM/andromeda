package at.ac.htlleonding.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer size;

    private String language;

    private Long precision;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<User_Model> userModels = new ArrayList<>();

    public Model() {
    }

    public Model(Long id, String name, Integer size, String language, Long precision, List<User_Model> userModels) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.language = language;
        this.precision = precision;
        this.userModels = userModels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getPrecision() {
        return precision;
    }

    public void setPrecision(Long precision) {
        this.precision = precision;
    }

    public List<User_Model> getUserModels() {
        return userModels;
    }

    public void setUserModels(List<User_Model> userModels) {
        this.userModels = userModels;
    }
}
