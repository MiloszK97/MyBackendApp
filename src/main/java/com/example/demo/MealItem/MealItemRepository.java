package com.example.demo.MealItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MealItemRepository extends JpaRepository<MealItem, UUID> {

    @Query("FROM MealItem AS meal WHERE meal.profileID=?1 AND meal.mealID=?2 AND meal.date=?3")
    Optional<List<MealItem>> findMealItemByID(String profileID, Integer mealID, LocalDate date);

    @Query(value = "select SUM (item_calories) FROM MealItem WHERE profileID=?1 AND mealID=?2 AND date=?3", nativeQuery = true)
    Optional<Double> totalCaloriesOfMeal(String profileID, Integer mealID, LocalDate date);

    @Query(value = "select SUM (item_proteins) FROM MealItem WHERE profileID=?1 AND mealID=?2 AND date=?3", nativeQuery = true)
    Optional<Double> totalProteinsOfMeal(String profileID, Integer mealID, LocalDate date);

    @Query(value = "select SUM (item_fat) FROM MealItem WHERE profileID=?1 AND mealID=?2 AND date=?3", nativeQuery = true)
    Optional<Double> totalFatOfMeal(String profileID, Integer mealID, LocalDate date);

    @Query(value = "select SUM (item_carbs) FROM MealItem WHERE profileID=?1 AND mealID=?2 AND date=?3", nativeQuery = true)
    Optional<Double> totalCarbsOfMeal(String profileID, Integer mealID, LocalDate date);

    @Query(value = "select SUM (item_weight) FROM MealItem WHERE profileID=?1 AND mealID=?2 AND date=?3", nativeQuery = true)
    Optional<Integer> totalWaterConsumed(String profileID, Integer mealID, LocalDate date);

    @Query(value = "SELECT SUM(item_calories) FROM mealitem where profileid=?1 AND date=?2", nativeQuery = true)
    Optional<Double> getSumCalories(String profileID, LocalDate date);

    @Query(value = "SELECT SUM(item_proteins) FROM mealitem where profileid=?1 AND date=?2", nativeQuery = true)
    Optional<Double> getSumProteins(String profileID, LocalDate date);

    @Query(value = "SELECT SUM(item_fat) FROM mealitem where profileid=?1 AND date=?2", nativeQuery = true)
    Optional<Double> getSumFat(String profileID, LocalDate date);

    @Query(value = "SELECT SUM(item_carbs) FROM mealitem where profileid=?1 AND date=?2", nativeQuery = true)
    Optional<Double> getSumCarbs(String profileID, LocalDate date);


}
