package com.example.demo.MealItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
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
    private RestTemplate restTemplate;

    @Autowired
    public MealItemController(MealItemService mealItemService) {
        this.mealItemService = mealItemService;
    }

    @GetMapping(path = "food/{foodName}")
    public FoodResponse getFood(@PathVariable String foodName){
        Map<String, String> bodyMap = new HashMap();
        bodyMap.put("query",foodName);

        String url = "https://trackapi.nutritionix.com/v2/natural/nutrients";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-app-id", "86ae75c0");
        headers.set("x-app-key", "6e2a5c7f15298becaf573be50ca4cbc3");
        HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(bodyMap, headers);
        FoodResponse response = restTemplate.postForObject(url, request, FoodResponse.class);

        return response;
    }

    @GetMapping(path = "getFood/{foodName}")
    public FoodGetResponse getRequestToAPI(@PathVariable String foodName){
        String url = "https://trackapi.nutritionix.com/v2/search/instant?query="+foodName;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-app-id", "86ae75c0");
        headers.set("x-app-key", "6e2a5c7f15298becaf573be50ca4cbc3");
        HttpEntity<Void> request = new HttpEntity(headers);
        ResponseEntity<FoodGetResponse> response = restTemplate.exchange(url, HttpMethod.GET, request, FoodGetResponse.class);

        return response.getBody();
    }

   /* @GetMapping
    public List<MealItem> getMealItem(){
        return mealItemService.getMealItem();
    }*/

    @GetMapping(path = "getmeal/{profileID}")
    public Optional<List<MealItem>>getMealItemById(
            @PathVariable("profileID") String profileID,
            @RequestParam Integer mealID,
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){


        return mealItemService.getProfileById(profileID, mealID, date);
    }

    @GetMapping(path = "getmealmacros/{profileID}")
    public Optional<Double>getMealMacrosKcal(
            @PathVariable("profileID") String profileID,
            @RequestParam Integer mealID,
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){


        return mealItemService.totalCaloriesOfMeal(profileID, mealID, date);
    }

    @GetMapping(path = "getmealmacrosP/{profileID}")
    public Optional<Double>getMealMacrosProt(
            @PathVariable("profileID") String profileID,
            @RequestParam Integer mealID,
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){


        return mealItemService.totalProteinsOfMeal(profileID, mealID, date);
    }

    @GetMapping(path = "getmealmacrosF/{profileID}")
    public Optional<Double>getMealMacrosFat(
            @PathVariable("profileID") String profileID,
            @RequestParam Integer mealID,
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){


        return mealItemService.totalFatOfMeal(profileID, mealID, date);
    }

    @GetMapping(path = "getmealmacrosC/{profileID}")
    public Optional<Double>getMealMacrosCarbs(
            @PathVariable("profileID") String profileID,
            @RequestParam Integer mealID,
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){


        return mealItemService.totalCarbsOfMeal(profileID, mealID, date);
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
