package com.example.demo.MealItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
public class MealItemService {

    private final MealItemRepository mealItemRepository;

    @Autowired
    public MealItemService(MealItemRepository mealItemRepository) {
        this.mealItemRepository = mealItemRepository;
    }

    public List<MealItem> getMealItem(){
        return mealItemRepository.findAll();
    }

    public Optional<List<MealItem>> getProfileById(String profileID, Integer mealID, LocalDate date) {
       return mealItemRepository.findMealItemByID(profileID, mealID, date);
    }

    public Optional<Double> totalCaloriesOfMeal(String profileID, Integer mealID, LocalDate date){
        return mealItemRepository.totalCaloriesOfMeal(profileID, mealID, date);
    }

    public Optional<Double> totalProteinsOfMeal(String profileID, Integer mealID, LocalDate date){
        return mealItemRepository.totalProteinsOfMeal(profileID, mealID, date);
    }

    public Optional<Double> totalFatOfMeal(String profileID, Integer mealID, LocalDate date){
        return mealItemRepository.totalFatOfMeal(profileID, mealID, date);
    }

    public Optional<Double> totalCarbsOfMeal(String profileID, Integer mealID, LocalDate date){
        return mealItemRepository.totalCarbsOfMeal(profileID, mealID, date);
    }


    public void addNewMealItem(MealItem mealItem) {
        mealItemRepository.save(mealItem);
    }

    public void deleteMealItem(UUID mealItemID) {
        boolean exists = mealItemRepository.existsById(mealItemID);
        if (!exists){
            throw new IllegalStateException("MealItem with id " + mealItemID + " does not exists");
        }
        mealItemRepository.deleteById(mealItemID);
    }

    @Transactional
    public void updateMealItem(UUID mealItemID,
                               Double itemWeight,
                               String itemName,
                               Double itemCalories,
                               Double itemProteins,
                               Double itemFat,
                               Double itemCarbs) {
        MealItem mealItem = mealItemRepository.findById(mealItemID).orElseThrow(() -> new IllegalStateException(
                "MealItem with id " + mealItemID + " does not exists"
        ));

        if (itemName != null && itemName.length() > 0 && !Objects.equals(mealItem.getItemName(), itemName)){
            mealItem.setItemName(itemName);
        }

        if(itemWeight != null && !Objects.equals(mealItem.getItemWeight(), itemWeight)){
            mealItem.setItemWeight(itemWeight);
        }

        if(itemCalories != null && !Objects.equals(mealItem.getItemCalories(), itemCalories)){
            mealItem.setItemCalories(itemCalories);
        }

        if(itemProteins != null && !Objects.equals(mealItem.getItemProteins(), itemProteins)){
            mealItem.setItemProteins(itemProteins);
        }

        if(itemFat != null && !Objects.equals(mealItem.getItemFat(), itemFat)){
            mealItem.setItemFat(itemFat);
        }

        if(itemCarbs != null && !Objects.equals(mealItem.getItemCarbs(), itemCarbs)){
            mealItem.setItemCarbs(itemCarbs);
        }
    }
}
