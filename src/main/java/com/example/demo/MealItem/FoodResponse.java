
package com.example.demo.MealItem;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FoodResponse {
    List<Food> foods;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Food{
       Double nf_calories;
       Integer serving_weight_grams;
       Double nf_protein;
       Double nf_total_fat;
       Double nf_total_carbohydrate;
    }

}
