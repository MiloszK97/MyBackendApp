package com.example.demo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Meal {

    @Id
    @Column(name = "mealid", nullable = false)
    private Integer mealID;
    private String mealName;

    public Meal() {}

    public Meal(Integer mealID, String mealName) {
        this.mealID = mealID;
        this.mealName = mealName;
    }
}
