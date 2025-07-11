package com.example.studentcrud.model;
import jakarta.persistence.*;


@Entity
@Table(name = "engineer")
public class Engineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String gender;
    private String color;
    private String size;


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
     public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}