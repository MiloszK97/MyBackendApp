package com.example.demo.MealItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(path = "api/v1/mealitem")
public class MealItemController {

    private final MealItemService mealItemService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    public MealItemController(MealItemService mealItemService) {
        this.mealItemService = mealItemService;
    }

/*    @GetMapping(path = "siema")
    public Food getFood(){
        Map<String, String> bodyMap = new HashMap();
        bodyMap.put("query","bread");
        Food block = webClientBuilder.build()
                .post()
                .uri("https://trackapi.nutritionix.com/v2/natural/nutrients")
                .header("x-app-id", "86ae75c0")
                .header("x-app-key", "6e2a5c7f15298becaf573be50ca4cbc3")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(bodyMap))
                .retrieve()
                .bodyToMono(Food.class)
                .block();
        return block;
    }*/

    @GetMapping
    public List<MealItem> getMealItem(){
        return mealItemService.getMealItem();
    }

    @GetMapping(path = "{profileID}")
    public Optional<List<MealItem>>getMealItemById(
            @PathVariable("profileID") String profileID,
            @RequestParam Integer mealID,
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){


        return mealItemService.getProfileById(profileID, mealID, date);
    }

    @PostMapping
    public void addNewMealItem(@RequestBody MealItem mealItem){
        mealItemService.addNewMealItem(mealItem);
    }

    @DeleteMapping(path = "{mealItemID}")
    public void deleteMealItem(@PathVariable("mealItemID") UUID mealItemID){
        mealItemService.deleteMealItem(mealItemID);
    }

    @PutMapping(path = "{mealItemID}")
    public void updateMealItem(
            @PathVariable("mealItemID") UUID mealItemID,
            @RequestParam(required = false) Double itemWeight,
            @RequestParam(required = false) String itemName,
            @RequestParam(required = false) Double itemCalories,
            @RequestParam(required = false) Double itemProteins,
            @RequestParam(required = false) Double itemFat,
            @RequestParam(required = false) Double itemCarbs){
        mealItemService.updateMealItem(mealItemID, itemWeight, itemName, itemCalories, itemProteins, itemFat, itemCarbs);
    }

}
