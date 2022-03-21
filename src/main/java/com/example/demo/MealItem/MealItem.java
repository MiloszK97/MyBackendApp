package com.example.demo.MealItem;

import com.example.demo.Profile.Profile;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "mealitem")
@Data
public class MealItem {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "mealitemid", nullable = false)
    private UUID mealItemID;
    private String itemName;
    private Double itemWeight;
    private Double itemCalories;
    private Double itemProteins;
    private Double itemFat;
    private Double itemCarbs;
    private String profileID;
    private Integer mealID;
    private LocalDate date;

    public MealItem(){}

    public MealItem(String itemName,
                    Double itemWeight,
                    Double itemCalories,
                    Double itemProteins,
                    Double itemFat,
                    Double itemCarbs,
                    String profileID,
                    Integer mealID,
                    LocalDate date) {
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        this.itemCalories = itemCalories;
        this.itemProteins = itemProteins;
        this.itemFat = itemFat;
        this.itemCarbs = itemCarbs;
        this.profileID = profileID;
        this.mealID = mealID;
        this.date = date;
    }
}
