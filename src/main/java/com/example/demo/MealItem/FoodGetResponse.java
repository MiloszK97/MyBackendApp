package com.example.demo.MealItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FoodGetResponse {

    List<Common> common;
    List<Branded> branded;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Common{
        String food_name;
        String serving_unit;
        Long serving_qty;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Branded{
        String food_name;
        String serving_unit;
        Integer serving_qty;
    }

}
