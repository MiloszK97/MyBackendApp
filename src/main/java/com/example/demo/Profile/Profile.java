package com.example.demo.Profile;

import com.example.demo.MealItem.MealItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "profile")
@Data
public class Profile {

 /*   @SequenceGenerator(
            name = "profile_sequence",
            sequenceName = "profile_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "profile_sequence"
    )*/
    @Id
    @Column(name = "profileid", nullable = false)
    private String profileID;
    private String profileNickname;
    private Integer profileAge;
    private Integer profileHeight;
    private Double profileWeight;
    private String profileGender;
    private Integer profileTotCal;
    private Integer waterAmount;
    private Double profileTotProt;
    private Double profileTotFat;
    private Double profileTotCarbs;
    /*@OneToMany(mappedBy = "profile")
    private List<MealItem> items;*/

    public Profile() {}

    public Profile(
            String profileID,
            String profileNickname,
            Integer profileAge,
            Integer profileHeight,
            Double profileWeight,
            String profileGender,
            Integer profileTotCal,
            Integer waterAmount,
            Double profileTotProt,
            Double profileTotFat,
            Double profileTotCarbs
    ) {
        this.profileID = profileID;
        this.profileNickname = profileNickname;
        this.profileAge = profileAge;
        this.profileHeight = profileHeight;
        this.profileWeight = profileWeight;
        this.profileGender = profileGender;
        this.profileTotCal = profileTotCal;
        this.waterAmount = waterAmount;
        this.profileTotProt = profileTotProt;
        this.profileTotFat = profileTotFat;
        this.profileTotCarbs = profileTotCarbs;
    }
}
