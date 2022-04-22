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

    @GetMapping(path = "getWaterConsumed/{profileID}")
    public Optional<Integer> getWaterConsumed(
            @PathVariable("profileID") String profileID,
            @RequestParam Integer mealID,
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return mealItemService.totalWaterConsumed(profileID, mealID, date);
    }

    @GetMapping(path = "getdaymacros/{profileID}")
    public List<Optional<Double>> getDayMacros(
            @PathVariable("profileID") String profileID,
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){

        return mealItemService.getDayMacros(profileID, date);
    }

   @GetMapping(path = "getmealmacros/{profileID}")
    public List<List<Optional<Double>>> getMealMacrosKcal(
            @PathVariable("profileID") String profileID,
            @RequestParam Integer mealID,
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){

        List<Optional<Double>> list = new ArrayList<>();
        List<Optional<Double>> list2 = new ArrayList<>();
        List<Optional<Double>> list3 = new ArrayList<>();
        List<Optional<Double>> list4 = new ArrayList<>();
        List<Optional<Double>> list5 = new ArrayList<>();
        List<List<Optional<Double>>> correctList = new ArrayList<>();

        list.add(mealItemService.totalCaloriesOfMeal(profileID, 0, date));
        list.add(mealItemService.totalProteinsOfMeal(profileID, 0, date));
        list.add(mealItemService.totalFatOfMeal(profileID, 0, date));
        list.add(mealItemService.totalCarbsOfMeal(profileID, 0, date));

        list2.add(mealItemService.totalCaloriesOfMeal(profileID, 1, date));
        list2.add(mealItemService.totalProteinsOfMeal(profileID, 1, date));
        list2.add(mealItemService.totalFatOfMeal(profileID, 1, date));
        list2.add(mealItemService.totalCarbsOfMeal(profileID, 1, date));

        list3.add(mealItemService.totalCaloriesOfMeal(profileID, 2, date));
        list3.add(mealItemService.totalProteinsOfMeal(profileID, 2, date));
        list3.add(mealItemService.totalFatOfMeal(profileID, 2, date));
        list3.add(mealItemService.totalCarbsOfMeal(profileID, 2, date));

        list4.add(mealItemService.totalCaloriesOfMeal(profileID, 3, date));
        list4.add(mealItemService.totalProteinsOfMeal(profileID, 3, date));
        list4.add(mealItemService.totalFatOfMeal(profileID, 3, date));
        list4.add(mealItemService.totalCarbsOfMeal(profileID, 3, date));

        list5.add(mealItemService.totalCaloriesOfMeal(profileID, 4, date));
        list5.add(mealItemService.totalProteinsOfMeal(profileID, 4, date));
        list5.add(mealItemService.totalFatOfMeal(profileID, 4, date));
        list5.add(mealItemService.totalCarbsOfMeal(profileID, 4, date));

        correctList.add(0, list);
        correctList.add(1, list2);
        correctList.add(2, list3);
        correctList.add(3, list4);
        correctList.add(4, list5);

        return correctList;
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
